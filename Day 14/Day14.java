public class Day14 
{
    public class Solution1 
    {
        public int addDigits(int num) {
            if (num == 0) return 0;
            return 1 + (num - 1) % 9;
        }
    }

class Solution2 
{
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = head;
        while(curr.next!=null && curr.next.next!=null)
        {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = first;
        }
        return dummy.next;
    }
}

class Solution3 {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        List<List<Integer>> components = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(colors[i] == -1) {
                List<Integer> comp = new ArrayList<>();
                if(!isBipartite(graph, colors, i, comp)) return -1;
                components.add(comp);
            }
        }
        int maxGroups = 0;
        for(List<Integer> comp : components) {
            int maxLevel = 0;
            for(int node : comp) {
                maxLevel = Math.max(maxLevel, bfsLevel(graph, node));
            }
            maxGroups += maxLevel;
        }
        return maxGroups;
    }

    private boolean isBipartite(List<Integer>[] graph, int[] colors, int start, List<Integer> comp) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0;
        comp.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int neighbor : graph[curr]) {
                if(colors[neighbor] == -1) {
                    colors[neighbor] = colors[curr] ^ 1;
                    queue.offer(neighbor);
                    comp.add(neighbor);
                } else if(colors[neighbor] == colors[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int bfsLevel(List<Integer>[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                for(int neighbor : graph[curr]) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return level;
    }
}
}
