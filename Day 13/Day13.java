import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class Day13 {
    public class Solution1 {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
    
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        perimeter += 4;
                        if (row + 1 < grid.length && grid[row + 1][col] == 1)
                            perimeter -= 2;
                        if (col + 1 < grid[0].length && grid[row][col + 1] == 1)
                            perimeter -= 2;
                    }
                }
            }
    
            return perimeter;
        }
    }
    class Solution2 
    {
        private int preorderIndex = 0;
        private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return build(preorder, 0, inorder.length - 1);
        }
    
        private TreeNode build(int[] preorder, int left, int right) {
            if (left > right) return null;
    
            int rootVal = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootVal);
    
            int inorderIndex = inorderIndexMap.get(rootVal);
            root.left = build(preorder, left, inorderIndex - 1);
            root.right = build(preorder, inorderIndex + 1, right);
    
            return root;
        }
}
class Solution3 {
    private int time = 0;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (List<Integer> edge : connections) 
        {
            int u = edge.get(0), v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] disc = new int[n];
        int[] low = new int[n];  
        Arrays.fill(disc, -1);
        dfs(0, -1, disc, low, graph);
        return result;
    }
    private void dfs(int u, int parent, int[] disc, int[] low, List<Integer>[] graph) 
    {
        disc[u] = low[u] = time++;
        for (int v : graph[u]) 
        {
            if (v == parent) continue; 
            if (disc[v] == -1) 
            {
                dfs(v, u, disc, low, graph);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u])
                result.add(Arrays.asList(u, v));
            } 
            else 
            {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

}
