public class Day9 {
    public boolean hasCycle(ListNode head) {
              if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;          
            fast = fast.next.next;     
            if (slow == fast)          
                return true;
        }
        return false; 
    }
}

class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) 
        {
            if (interval[0] >= end) 
            {
                end = interval[1];
            } 
            else 
            {

                count++;
            }
        }

        return count;
    }
}

class Solution3 {
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode node = head;
        for (int i = 0; i < k; i++) 
        {
            if (node == null) return head; 
            node = node.next;
        }
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) 
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev; 
    }
}
