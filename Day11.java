class Solution1 {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}

class Solution2 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int max = 0;
        for (int num : nums) 
        {
            points.put(num, points.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = points.getOrDefault(1, 0);
        for (int i = 2; i <= max; i++) 
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points.getOrDefault(i, 0));
        }
        return dp[max];
    }
}


class Solution3 {
    int c=0;
   public int minCameraCover(TreeNode root) {
       if(camera(root)==0) c++;
       return c;
   }
   public int camera(TreeNode node)
   {
       if(node==null) return -1;
       int left = camera(node.left);
       int right = camera(node.right);
       if(left==0|| right==0)
       {
           c++;
           return 1;
       }
       if(left==1 || right==1) return -1;
       return 0;
   }
}