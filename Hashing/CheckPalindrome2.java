/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/homework/problems/11859/?navref=cl_pb_nv_tb

Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 10^5
A consists only of lower-case characters.

Example Input
Input 1:
 A = "abcde"
Input 2:
 A = "abbaee"

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
*/
import java.util.*;
public class CheckPalindrome2 {
    public static int solve(String A) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);
        }
        int count_odd = 0;
        for(Map.Entry<Character,Integer> a : hm.entrySet())
        {
            if(a.getValue()%2==1)
                count_odd++;
        }
        if(count_odd<=1)
            return 1;
        else
            return 0;

    }
    public static void main(String[] args) {
        String A = new String("afadjasbc");
        System.out.println(solve(A));
    }
}
