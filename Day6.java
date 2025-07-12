import java.util.*;

class Solution1
 {
    public boolean checkIfExist(int[] arr) 
    {
       Set<Integer> set = new HashSet<>();
       for(int i : arr)
       {
        if(set.contains(i*2)|| (i%2==0 && set.contains(i/2)))
        {
            return true;
        }
        set.add(i);
       }
       return false;
    }
}



class Solution2
 {
    public String decodeString(String s) 
    {
       Stack<Integer> numStack = new Stack<>();
       Stack<StringBuilder> strStack = new Stack<>();
       StringBuilder current = new StringBuilder();
       int num =0;
       for(char ch : s.toCharArray())
       {
        if(Character.isDigit(ch))
        {
            num = num * 10 + (ch-'0');
        }
        else if(ch == '[')
        {
          numStack.push(num);
          strStack.push(current);
          num =0;
          current = new StringBuilder();
        }
        else if(ch == ']')
        {
            int repeat = numStack.pop();
            StringBuilder previous = strStack.pop();
            StringBuilder temp = new StringBuilder(previous);
            for(int i=0;i<repeat;i++)
            {
                temp.append(current);
            }
            current = temp;
        }
        else
        {
            current.append(ch);
        }
       }
       return current.toString();
    }
}


class Solution3
 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length)
         {
            int lineLength = words[i].length();
            int j = i + 1;

            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth)
             {
                lineLength += 1 + words[j].length(); 
                j++;
            }
            int wordCount = j - i;
            int totalSpaces = maxWidth - (lineLength - (wordCount - 1)); 

            StringBuilder line = new StringBuilder();
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            else 
            {
                int spacesBetweenWords = totalSpaces / (wordCount - 1);
                int extraSpaces = totalSpaces % (wordCount - 1);
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spacesBetweenWords + (extraSpaces-- > 0 ? 1 : 0);
                        line.append(" ".repeat(spacesToAdd));
                    }
                }
            }
            result.add(line.toString());
            i = j;  
        }
        return result;
    }
}