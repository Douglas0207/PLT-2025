import java.util.*;

class Solution1 
{
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

class Solution2 
{
    public int reverse(int x) 
    {
        int temp = x;
        int rev = 0;
        while(temp!=0)
        {
            int digit = temp%10;
            if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10)
            {
                return 0;
            }
            rev = (rev*10) + digit;
            temp = temp/10;
        }
        return rev;
    }
}



class Solution3 
{
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll(); 
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
