/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29484/homework/problems/6527/?navref=cl_pb_nv_tb

Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.

Problem Constraints
0 <= A <= 10^9
0 <= B <= 30

Example Input
Input 1:
 A = 3
 B = 3
Input 2:
 A = 15
 B = 2

Example Output
Output 1:
 7
Output 2:
 12

Example Explanation
Explanation 1:
 3 xor 7 = 4 which is minimum
Explanation 2:
 15 xor 12 = 3 which is minimum

 */
public class SmallestXOR {
    public static int solve(int A, int B) {
        boolean[] bits = new boolean[31];
        int X = 0;
        for(int i = 30;i>=0;i--)
        {
            if(B == 0)
                return X;
            if(((1<<i)&A) > 0)
            {
                X = X + (1<<i);
                bits[i] = true;
                B--;
            }
        }
        for(int i = 0;i<31;i++)
        {
            if(B == 0)
                return X;
            if(!bits[i])
            {
                X = X + (1<<i);
                bits[i] = true;
                B--;
            }
        }
        return X;
    }
    public static void main(String[] args)
    {
        System.out.println(solve(15,2));
    }
}
