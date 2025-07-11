import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray())
            jewelSet.add(c);

        int count = 0;
        for (char c : stones.toCharArray())
            if (jewelSet.contains(c))
                count++;

        return count;
    }
}

public class Day5 {
    public String findLongestWord(String s, List<String> dictionary) {
        String bestWord = "";
        for (String word : dictionary) {
            if (isSubsequence(s, word)) {
                if (word.length() > bestWord.length()) {
                    bestWord = word;
                }
                else if (word.length() == bestWord.length() && word.compareTo(bestWord) < 0) {
                    bestWord = word;
                }
            }
        }
        return bestWord;
    }
    private boolean isSubsequence(String s, String word) {
        int i = 0;     
    int j = 0; 

        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++; 
            }
            i++;
        }
        return j == word.length(); 
    }
}

class Solution2 {
    public String shortestPalindrome(String s) 
    {
        String rev = new StringBuilder(s).reverse().toString();
        for(int i=0;i<s.length();i++)
        {
            if(s.startsWith(rev.substring(i)))
            {
                return rev.substring(0,i) +s;
            }
        }
        return "";
    }
}
