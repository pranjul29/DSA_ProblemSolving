/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/assignment/problems/9233/?navref=cl_pb_nv_tb
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.

Problem Constraints
1 ≤ length(A) = length(B) ≤ 10^5

Example Input
Input 1:
 A = "1001"
 B = "0011"
Input 2:
 A = "111"
 B = "111"

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 4 cyclic shifts of B exists: "0011", "0110", "1100", "1001".  
 There is only one cyclic shift of B i.e. "1001" which has 0 xor with A.
Explanation 2:
 All cyclic shifts of B are same as A and give 0 when taken xor with A. So, the ans is 3.
*/
public class CyclicPermutation {
    public static int solve(String A, String B) {
        StringBuilder str = new StringBuilder(A);
        str.append("#");
        System.out.println(str);
        str.append(B);
        System.out.println(str);
        str.append(B);
        System.out.println(str);
        String string = str.toString();
        string = string.substring(0,string.length()-1);
        System.out.println(string);
        int[] lps = new int[string.length()];
        lps[0] = 0;
        for(int i = 1;i<string.length();i++)
        {
            int X = lps[i-1];
            while(string.charAt(X)!=string.charAt(i))
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
        int length = A.length();
        int count = 0;
        for(int i = 0;i<lps.length;i++)
        {
            if(lps[i] == length)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String A = new String("1101111111");
        String B = new String("1101111111");
        System.out.println(solve(A, B));
    }
}
