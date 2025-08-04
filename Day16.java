class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int temp =x;
        int res =0;
        while(temp>0)
        {
            int dg = temp%10;
            res = (res*10) + dg;
            temp = temp/10;
        }
        return res==x;
    }
}
import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) 
        {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;
            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return completedCourses == numCourses;
    }
}
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        List<List<Integer>> sol = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            wordMap.put(words[i], i);
            set.add(words[i].length());
        }
        for(int i = 0; i < words.length; i++){
            int length = words[i].length();
            String reverse= new StringBuilder(words[i]).reverse().toString();
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i)
                sol.add(Arrays.asList(i,wordMap.get(reverse)));
            for(Integer k : set){
                if(k==length)
                    break;
                if(isPalindrome(reverse,0,length-1-k)){
                    String s1 = reverse.substring(length-k);
                    if(wordMap.containsKey(s1))
                        sol.add(Arrays.asList(i,wordMap.get(s1)));
                }
                if(isPalindrome(reverse,k,length-1)){
                    String s2 = reverse.substring(0,k);
                    if(wordMap.containsKey(s2))
                        sol.add(Arrays.asList(wordMap.get(s2),i));
                }
            }
        }
        return sol;
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
