/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29490/homework/problems/1857/?navref=cl_pb_nv_tb
You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.

Constraints: 
1 <= N <= 1e5
1 <= A[i] <= 1e5

Example:

Input:
    A = [1, 2, 3, 4]
Output:
     2

Explanation:
    here G = 1 * 2 * 3 * 4 = 24
    and distinct prime divisors of G are [2, 3]
*/
import java.util.*;
public class DistinctPrimes {
    public static int solve(int[] A) {
        int N = 100000;
        int[] spf = new int[N+1];
        for(int i = 0;i<spf.length;i++)
        {
            spf[i] = i;
        }
        for(int i = 2; i<= (int)Math.sqrt(N);i++)
        {
            if(spf[i] == i)
            {
                for(int j = i*i;j<=N;j=j+i)
                {
                    if(spf[j] == j)
                        spf[j] = i;
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<A.length;i++)
        {
            int temp = A[i];
            while(temp > 1)
            {
                int factor = spf[temp];
                hs.add(factor);
                while(temp%factor == 0)
                {
                    temp = temp/factor;
                }
            }
        }
        return hs.size();
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(solve(arr));
    }
}
