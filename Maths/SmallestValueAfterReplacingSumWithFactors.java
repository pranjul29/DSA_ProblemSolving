/* 
Source: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/
You are given a positive integer n.
Continuously replace n with the sum of its prime factors.
Note that if a prime factor divides n multiple times, it should be included in the sum as many times as it divides n.
Return the smallest value n will take on.

Example 1:
Input: n = 15
Output: 5
Explanation: Initially, n = 15.
15 = 3 * 5, so replace n with 3 + 5 = 8.
8 = 2 * 2 * 2, so replace n with 2 + 2 + 2 = 6.
6 = 2 * 3, so replace n with 2 + 3 = 5.
5 is the smallest value n will take on.
Example 2:
Input: n = 3
Output: 3
Explanation: Initially, n = 3.
3 is the smallest value n will take on.
 
Constraints:
2 <= n <= 10^5
*/
import java.util.*;
public class SmallestValueAfterReplacingSumWithFactors {
    public static int smallestValue(int n) {
        int array_length = n;
        boolean[] isPrime = new boolean[array_length+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i<=Math.floor(Math.sqrt(array_length));i++)
        {
            if(isPrime[i])
            {
                for(int j = i<<1;j<=array_length;j=j+i)
                {
                    isPrime[j] = false;
                }
            }
        }
        while(true)
        {
            int sum = 0;
            int temp = n;
            for(int i = 2;i<n;i++)
            {
                if(isPrime[i] && temp%i == 0)
                {
                    while(temp%i == 0)
                    {    
                        sum += i;
                        temp = temp/i;
                    }
                }
            }
            if(sum == 0 || sum == n)
                break;
            n = sum;
        }
        return n;
    }
    public static void main(String[] args) {
        int n = 15;
        System.out.println(smallestValue(n));
    }
}
