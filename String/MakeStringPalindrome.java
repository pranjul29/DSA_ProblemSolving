/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/homework/problems/363/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/

Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.
Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.

Problem Constraints
1 <= N <= 10^6

Example Input
Input 1:
 A = "abc"
Input 2:
 A = "bb"

Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:
 There is no need to insert any character at the beginning as the string is already a palindrome.
*/
public class MakeStringPalindrome {
    public static int solve(String A) {
        StringBuilder a = new StringBuilder(A);
        String S = a + "#" + a.reverse();
        int[] lps = new int[S.length()];
        lps[0] = 0;
        for(int i = 1;i<lps.length;i++)
        {
            int X = lps[i-1];
            while(S.charAt(X) != S.charAt(i))
            {
                if(X == 0)
                {
                    X= -1;
                    break;
                }
                X = lps[X-1];
            }
            lps[i] = X+1;
        }
        return A.length()-lps[S.length()-1];
    }
    public static void main(String[] args) {
        String A = new String("abcada");
        System.out.println(solve(A));
    }
}
