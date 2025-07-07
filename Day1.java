import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day1 {
    public static void main(String[] args) {
        Day1 obj = new Day1();

        // Test for intersection
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersectionResult = obj.intersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(intersectionResult));

        // Test for subarraySum
        int[] arr = {1, 2, 3};
        int k = 3;
        int subarrayCount = obj.subarraySum(arr, k);
        System.out.println("Subarray sum equals k: " + subarrayCount);

        // Test for minPatches
        int[] patchArray = {1, 3};
        int n = 6;
        int patchesNeeded = obj.minPatches(patchArray, n);
        System.out.println("Minimum patches needed: " + patchesNeeded);
    }
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        if(nums1.length>nums2.length)
        {
            return intersection(nums2,nums1);
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int nums : nums1)
        {
            set.add(nums);
        }
        for(int nums : nums2)
        {
            if(set.contains(nums))
            {
                result.add(nums);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }
        return ans;
    }

    public int subarraySum(int[] arr, int k) 
    {
        int prefixSum = 0;
        int count = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
           prefixSum = prefixSum + arr[i];
           int remove = prefixSum - k ;
           if(map.containsKey(remove))
           {
            count += map.get(remove);
           }
           map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
       return count;
    }

        public int minPatches(int[] nums, int n) 
        {
            long maxNumber = 0;
            int minNumberOfPatches = 0;
            int i = 0;
            int sz = nums.length;
    
            while (maxNumber < n) {
                if (i < sz && nums[i] <= maxNumber + 1) {
                    maxNumber += nums[i];
                    i++;
                } else {
                    minNumberOfPatches++;
                    maxNumber += (maxNumber + 1);
                }
            }
    
            return minNumberOfPatches;
        }
    }

