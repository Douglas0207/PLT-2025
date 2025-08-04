/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

 public class Solution extends GuessGame {
    public int guessNumber(int n) 
    {
        int left =1;
        int right =n;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            int res = guess(mid);
            if(res==0)
            {
                return mid;
            }
            else if(res<0)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return -1;
    }
}

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);  
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int[] allCuts = new int[cuts.length + 2];
        int c = cuts.length;
        allCuts[0] = 0;
        allCuts[c + 1] = n;
        for (int i = 0; i < c; i++) {
            allCuts[i + 1] = cuts[i];
        }
        Arrays.sort(allCuts);
        int[][] dp = new int[c + 2][c + 2];
        for (int length = 2; length <= c + 1; length++) {
            for (int i = 0; i + length <= c + 1; i++) {
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = allCuts[j] - allCuts[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][c + 1];
    }
}
