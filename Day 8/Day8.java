class RecentCounter 
{
    Queue<Integer> queue;

    public RecentCounter() 
    {
        queue = new LinkedList<>();
    }
    public int ping(int t) 
    {
        queue.add(t);

        while (queue.peek() < t - 3000) 
        {
            queue.poll();
        }
        return queue.size();
    }
}

class Solution2 {
    public int primePalindrome(int n) {
        while (true) {
            if (isPalindrome(n) && isPrime(n)) return n;
            n++;
            if (10000000 < n && n < 100000000) n = 100000000;
        }
    }
    boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}


class Solution3 {
    public int findKthNumber(int n, int k) 
    {
         int curr = 1;
    k = k - 1; 

    while (k > 0) {
        long steps = countSteps(n, curr, curr + 1);
        if (steps <= k) 
        {
            curr++;      
            k -= steps;
        } else 
        {
            curr *= 10; 
            k -= 1;
        }
    }
    return curr;
}
private long countSteps(int n, long first, long last) {
    long steps = 0;
    while (first <= n) {
        steps += Math.min(n + 1, last) - first;
        first *= 10;
        last *= 10;
    }
    return steps;
    }
}
