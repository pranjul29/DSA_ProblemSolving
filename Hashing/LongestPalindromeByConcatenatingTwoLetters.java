/* 
Source: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
You are given an array of strings words. Each element of words consists of two lowercase English letters.
Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
A palindrome is a string that reads the same forward and backward.

Example 1:
Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:
Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:
Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 
Constraints:
1 <= words.length <= 10^5
words[i].length == 2
words[i] consists of lowercase English letters.
*/
import java.util.*;
public class LongestPalindromeByConcatenatingTwoLetters {
    public static int longestPalindrome(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> pal = new HashMap<>();
        int length = 0;
        for(int i = 0;i<words.length;i++)
        {
            char a = words[i].charAt(0);
            char b = words[i].charAt(1);
            if(a != b)
            {
                StringBuilder reverse_build = new StringBuilder();
                reverse_build.append(b);
                reverse_build.append(a);
                String reverse = reverse_build.toString();
                // System.out.println(reverse);
                if(map.containsKey(reverse))
                {
                    if(map.get(reverse) > 1)
                        map.put(reverse,map.get(reverse)-1);
                    else
                        map.remove(reverse);
                    length += 4;
                }
                else
                {
                    map.put(words[i],map.getOrDefault(words[i],0)+1);
                }
            }
            else 
            {
                pal.put(words[i],pal.getOrDefault(words[i],0)+1);
            }
            // System.out.println(map);
        }
        // System.out.println(pal);
        int highest_odd = 0;
        for (Map.Entry<String,Integer> mapElement : pal.entrySet())
        {
            // System.out.println(mapElement);
            if(mapElement.getValue()%2 == 1)
            {
                
                // System.out.println(mapElement.getValue());
                highest_odd = 2;
                length += (mapElement.getValue()-1)*2;
            }
            else
            {
                length += mapElement.getValue()*2;
            }
        }
        return length + highest_odd;
    }
    public static void main(String[] args) {
        String[] str = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        System.out.println(longestPalindrome(str));
    }
}
