class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;
        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != color) return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, color, newColor);
        dfs(image, r - 1, c, color, newColor);
        dfs(image, r, c + 1, color, newColor);
        dfs(image, r, c - 1, color, newColor);
    }
}

class Solution {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length;
    int positive =0;
    int negative =1; 
    int result [] = new int[n];
    for(int i=0;i<n;i++)
    {
        if(arr[i]>0)
        {
            result[positive]=arr[i];
            positive+=2;
        }
        else if(arr[i]<0)
        {
            result[negative]=arr[i];
            negative+=2;
        }
    }
    return result;
    }
}
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minExitHealth = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minExitHealth - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
