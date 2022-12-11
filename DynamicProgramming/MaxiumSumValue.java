/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34965/homework/problems/1140/?navref=cl_pb_nv_tb

You are given an array A of N integers and three integers B, C, and D.
You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.

Problem Constraints
1 <= N <= 10^5
-10000 <= A[i], B, C, D <= 10000

Input Format
First argument is an array A
Second argument is an integer B
Third argument is an integer C
Fourth argument is an integer D

Output Format
Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.

Example Input
Input 1:
 A = [1, 5, -3, 4, -2]
 B = 2
 C = 1
 D = -1
Input 2:
 A = [3, 2, 1]
 B = 1
 C = -10
 D = 3

Example Output
Output 1:
 18
Output 2:
 -4

Example Explanation
Explanation 1:
 If you choose i = 2, j = 2, and k = 3 then we will get
 A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
Explanation 2:
 If you choose i = 1, j = 3, and k = 3 then we will get
 A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
*/
import java.util.*;
public class MaxiumSumValue {
    public static int solve(int[] A, int B, int C, int D) {
        int N = A.length;
        int[] b = new int[N];
        int[] d = new int[N];
        Arrays.fill(b,Integer.MIN_VALUE);
        Arrays.fill(d,Integer.MIN_VALUE);
        b[0] = A[0]*B;
        d[N-1] = A[N-1]*D;
        for(int i = N-2;i>=0;i--)
        {
            d[i] = Math.max(d[i+1],D*A[i]);
        }
        for(int i = 1;i<N;i++)
        {
            b[i] = Math.max(b[i-1],B*A[i]);
        }
        int sum = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++)
        {
            sum = Math.max(sum,b[i] + d[i] + A[i]*C);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] A  = {-6, 12, 10, 28, -14, -35, 42, 28};
        int B = -5;
        int C = 14;
        int D = 6;
        System.out.println(solve(A,B,C,D));
    }
}
