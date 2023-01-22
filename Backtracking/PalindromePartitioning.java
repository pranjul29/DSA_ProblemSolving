/* 
Source: https://leetcode.com/problems/palindrome-partitioning/description/
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 
Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
import java.util.*;
public class PalindromePartitioning {
    static List<List<String>> results;
    static boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<=end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
    static void generatePalindromeStrings(int startIndex,int endIndex,String s,List<String> temp)
    {
        
        if(startIndex > endIndex)
            return;
        if(startIndex >= s.length() || endIndex > s.length())
        {
            int count= 0;
            for(int i = 0;i<temp.size();i++)
                count += temp.get(i).length();
            if(count == s.length())
                results.add(new ArrayList<String>(temp));
            return;
        }
        if(startIndex == endIndex)
            generatePalindromeStrings(startIndex,endIndex+1,s,temp);
        String temp_str = s.substring(startIndex,endIndex);
        if(isPalindrome(temp_str))
        {
            temp.add(temp_str);
            generatePalindromeStrings(endIndex,endIndex+1,s,temp);
            temp.remove(temp.size()-1);
        }
        generatePalindromeStrings(startIndex,endIndex+1,s,temp);
    }
    public static List<List<String>> partition(String s) {
        results = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        generatePalindromeStrings(0,1,s,temp);
        return results;
    }
    public static void main(String[] args) {
        String s = new String("aab");
        System.out.println(partition(s));
    }
}
