/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29518/assignment/problems/161/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
Given a string A, find the length of the longest substring without repeating characters.
Note: Users are expected to solve in O(N) time complexity.

Problem Constraints
1 <= size(A) <= 10^6
String consists of lowerCase,upperCase characters and digits are also present in the string A.

Example Input
Input 1:
 A = "abcabcbb"
Input 2:
 A = "AaaA"

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:
 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
*/
import java.util.*;
public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String A) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        int maximum_length = 1;
        while(start<A.length() && end<A.length())
        {
            char c = A.charAt(end);
            hm.put(c,hm.getOrDefault(c,0)+1);
            if(hm.get(c)>1)
            {
                while(hm.get(c)!=1)
                {
                    char temp = A.charAt(start);
                    if(hm.containsKey(temp))
                    {
                        hm.put(temp,hm.get(temp)-1);
                        if(hm.get(temp) == 0)
                            hm.remove(temp);
                    }
                    start++;
                }
            }
            maximum_length = Math.max(maximum_length,end-start+1);
            end++;
        }
        return maximum_length;
    }
    public static void main(String[] args) {
        String A = new String("abcabcbb");
        System.out.println(lengthOfLongestSubstring(A));
    }
}
