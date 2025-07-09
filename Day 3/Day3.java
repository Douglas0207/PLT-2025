import java.util.*;

public class Day3 {

    // 1. Missing Number
    public static int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }
        int miss = xor1 ^ xor2;
        return miss;
    }
    public static int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2]; 
        for (int i = 0; i < n - 2; i++) 
        {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) 
                {
                    result = sum;
                }

                if (sum == target) return target;
                else if (sum < target) left++;
                else right--;
            }
        }

        return result;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Test 1: Missing Number
        int[] arr1 = {3, 0, 1};
        System.out.println("Missing Number: " + missingNumber(arr1)); // Output: 2

        // Test 2: Three Sum Closest
        int[] arr2 = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("Three Sum Closest: " + threeSumClosest(arr2, target)); // Output: 2

        // Test 3: Max Sliding Window
        int[] arr3 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr3, k);
        System.out.print("Max Sliding Window: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
