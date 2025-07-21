class Solution1 {
    public List<Double> averageOfLevels(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> l = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int count = q.size();
            double sum = 0;
            for(int i=0;i<count;i++)
            {
                TreeNode n = q.poll();
                sum = sum + n.val;
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
            }
            l.add(sum/count);
        }
        return l;
    }
}

class Solution2 {
    public ListNode deleteDuplicates(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummy;
        dummy.next = curr;
        while(curr!=null)
        {
            if(curr.next!= null && curr.val == curr.next.val)
            {
                while(curr.next!=null && curr.val == curr.next.val)
                {
                    curr = curr.next;
                }
                    prev.next = curr.next;
                    curr = curr.next;
            }
            else
            {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}

class Solution3 {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int currentMaxPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);
        return node.val + Math.max(leftGain, rightGain);
    }
}
