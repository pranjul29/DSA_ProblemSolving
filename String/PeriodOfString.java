/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/assignment/problems/9462/?navref=cl_pb_nv_tb

You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.

Problem Constraints
1 <= N <= 10^6

Example Input
Input 1:
 A = "abababab"
Input 2:
 A = "aaaa"

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 Period of the string will be 2: 
 Since, for all i, A[i] = A[i%2]. 
Explanation 2:
 Period of the string will be 1.
*/
public class PeriodOfString {
    public static int solve(String S) {
        int[] lps = new int[S.length()];
        lps[0] = 0;
        for(int i = 1;i<S.length();i++)
        {
            int X = lps[i-1];
            while(S.charAt(X)!=S.charAt(i))
            {
                if(X == 0)
                {
                    X = -1;
                    break;
                }
                X = lps[X-1];
            }
            lps[i] = X + 1;
        }
        System.out.println();
        for(int i = 0;i<lps.length;i++)
        {
            System.out.print(lps[i] + " ");
        }
        System.out.println();
        return S.length() - lps[S.length()-1];
    }
    public static void main(String[] args) {
        //String S = new String("abababab");
        String S = new String("abcabcdabc");
        System.out.println(solve(S));
    }
}
