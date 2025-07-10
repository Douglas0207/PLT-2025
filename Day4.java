import java.util.*;
class Solution1 {
    public int firstUniqChar(String s) 
    {
        int arr[] = new int [26];
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            if(arr[s.charAt(i)-'a']==1)
            {
                return i;
            }
        }
        return -1;
    }
}
class Solution2 {
    public int findMinArrowShots(int[][] points) 
    {
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));
        int arrpos = points[0][1];
        int arrow =1;
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0]>arrpos)
            {
                arrow++;
                arrpos=points[i][1];
            }
        }
        return arrow;
    }
}
class Solution3
{
    public static int maxEnvelopes(int arr [] [])
    {
        // sort
        Arrays.sort(arr,(a,b) ->{
            if(a[0]==b[0])
            {
             return b[1] - a[1];
            }
            return a[0]-b[0];
        });

        int [] heights = new int [arr.length];
        for(int i=0;i<arr.length;i++)
        {
            heights[i] = arr[i][1];
        }
        return lengthOfEnv(heights);
    }
    public static int lengthOfEnv(int []heights)
    {
      int [] sequence = new int [heights.length];
      int length =0;

      for(int height : heights)
      {
        int index = Arrays.binarySearch(sequence, 0,length,height);
        if(index<0)
        {
            index = -(index+1);
        }
        sequence[index] = height;
        if(index==height)
        {
            length++;
        }
      }
      return length;
    }
}