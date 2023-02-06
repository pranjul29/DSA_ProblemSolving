/* 
Source: https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 
Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
*/
import java.util.*;
public class GCDOfStrings {
    static boolean isGCD(String str1, String str2, StringBuilder pre)
    {
        int length = pre.length();
        if(str1.length()%length != 0 || str2.length()%length!=0 || str1.length() < length || str2.length() < length)
            return false;
        boolean isPossible = true;
        int i = 0;
        while(i < str1.length() && i < str2.length())
        {
            String temp1 = str1.substring(i,i+length);
            String temp2 = str2.substring(i,i+length);      
            i = i + length;
            if(!(temp1.equals(pre.toString()) && temp2.equals(pre.toString())))
            {
                isPossible = false;
                break;
            }
        }
        while(i < str1.length())
        {
            String temp1 = str1.substring(i,i+length);
            i = i + length;
            if(!(temp1.equals(pre.toString())))
            {
                isPossible = false;
                break;
            }
        }
        while(i < str2.length())
        {
            String temp1 = str2.substring(i,i+length);
            i = i + length;
            if(!(temp1.equals(pre.toString())))
            {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }
    public static String gcdOfStrings(String str1, String str2) {
        StringBuilder str = new StringBuilder("");
        String result = new String("");
        for(int i = 0;i<str1.length();i++)
        {
            str.append(str1.charAt(i));
            if(isGCD(str1,str2,str))
                result = str.toString();
        }
        return result;
    }
    public static void main(String[] args) {
        String str1 = new String("ABC");
        String str2 = new String("ABCABCABC");
        System.out.println(gcdOfStrings(str1,str2));
    }
}
