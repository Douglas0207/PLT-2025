import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Day12 
{
    class Solution1 
    {
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }
    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) 
    {
        if (node == null) return;
        currentPath.add(node.val);
        if (node.left == null && node.right == null && node.val == remainingSum) 
        {
            result.add(new ArrayList<>(currentPath));
        } 
        else 
        {
            dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
public class Codec {
    static TreeNode node;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        node = root;
        return " ";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        return node;
    }
}
}
