/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/homework/problems/900/?navref=cl_pb_nv_tb

Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.

Problem Constraints
1 <= N <= 10^5

Example Input
Input 1:
 A = "abbba"
Input 2:
 A = "adaddb"

Example Output
Output 1:
 "YES"
Output 2:
 "NO"

Example Explanation
Explanation 1:
 We can change the character at index 3(1-based) to any other character. The string will be palindromic.
Explanation 2:
 To make the string palindromic we need to change 2 characters. 
*/
public class ClosestPalindrome {
    public static String solve(String A) {
        int i = 0;
        int j = A.length()-1;
        int count = 0;
        while(i<j)
        {
            char a = A.charAt(i);
            char b = A.charAt(j);
            if(a == b)
            {
                i++;
                j--;
                continue;
            }
            else
            {
                i++;
                j--;
                count++;
            }
        }
        if(count == 0)
        {
            if(A.length()%2 == 1)
                return new String("YES");
            else
                return new String("NO");
        }
        if(count == 1)
            return new String("YES");
        else
            return new String("NO");
    }
    public static void main(String[] args) {
        String A = new String("abbbca");
        System.out.println(solve(A));
    }
}
