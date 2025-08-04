public class Day15 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
class Solution2 {
    public TreeNode sortedListToBST(ListNode head) 
    {
        if (head == null) return null;
        return buildBST(head, null);
    }
    private TreeNode buildBST(ListNode head, ListNode tail) 
    {
        if (head == tail) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) 
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }
}
import java.util.*;

public class Solution3 {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int shortest = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) 
        {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();

            dist[start] = 0;
            queue.add(start);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbor : graph.get(curr)) {
                    if (dist[neighbor] == -1) {
                        dist[neighbor] = dist[curr] + 1;
                        queue.add(neighbor);
                    } 
                    else if (dist[neighbor] >= dist[curr]) 
                    {
                        shortest = Math.min(shortest, dist[curr] + dist[neighbor] + 1);
                    }
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
