import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}


import java.util.*;

class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 1}); 
        visited.add("0,1");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int pos = state[0], speed = state[1];

                if (pos == target) return level;

                int newPos = pos + speed;
                int newSpeed = speed * 2;
                String keyA = newPos + "," + newSpeed;
                if (!visited.contains(keyA) && Math.abs(newPos - target) < target * 2) {
                    queue.offer(new int[]{newPos, newSpeed});
                    visited.add(keyA);
                }

                newSpeed = speed > 0 ? -1 : 1;
                String keyR = pos + "," + newSpeed;
                if (!visited.contains(keyR)) {
                    queue.offer(new int[]{pos, newSpeed});
                    visited.add(keyR);
                }
            }

            level++;
        }

        return -1;
    }
}
