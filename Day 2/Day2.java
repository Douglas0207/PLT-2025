import java.util.Arrays;
import java.util.HashMap;

public class Day2 {

    // -------- Two Sum --------
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = target - arr[i];
            if (map.containsKey(sum)) {
                return new int[] { map.get(sum), i };
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

    // -------- Boats to Save People --------
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            count++;
        }
        return count;
    }

    // -------- Count Subarrays With Score Less Than K --------
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    // -------- Main Method to Test All 3 --------
    public static void main(String[] args) {
        Day2 obj = new Day2();

        // Test 1: Two Sum
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result1 = obj.twoSum(arr, target);
        System.out.println("Two Sum Result: " + Arrays.toString(result1));

        // Test 2: Boats to Save People
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int result2 = obj.numRescueBoats(people, limit);
        System.out.println("Boats Needed: " + result2);

        // Test 3: Count Subarrays With Score Less Than K
        int[] nums = {2, 1, 4, 3, 5};
        long k = 10;
        long result3 = obj.countSubarrays(nums, k);
        System.out.println("Count of Subarrays with Score < " + k + ": " + result3);
    }
}
