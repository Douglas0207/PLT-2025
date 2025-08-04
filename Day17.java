class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        for(int num:arr)
        {
            if(num%2!=0)
            {
                c++;
                if(c==3)
                {
                    return true;
                }
            }
                else
                {
                    c=0;
                }
            }
        return false;
    }
}

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); 
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        dist[k] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0], node = current[1];
            if (currDist > dist[node]) continue;
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0], weight = neighbor[1];
                if (currDist + weight < dist[adjNode]) {
                    dist[adjNode] = currDist + weight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}

public class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[][] memo;
    private int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }
    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];
        int max = 1; 
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m &&
                newCol >= 0 && newCol < n &&
                matrix[newRow][newCol] > matrix[row][col]) {
                max = Math.max(max, 1 + dfs(matrix, newRow, newCol));
            }
        }
        memo[row][col] = max;
        return max;
    }
}
