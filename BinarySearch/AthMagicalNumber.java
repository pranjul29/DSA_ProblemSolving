/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29506/assignment/problems/5697
Source: https://leetcode.com/problems/nth-magical-number/

You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Problem Constraints
1 <= A <= 10^9
2 <= B, C <= 40000

Example Input
Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Example Output
Output 1:
 2
Output 2:
 6

Example Explanation
Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
*/
public class AthMagicalNumber
{
    public static long GCD(long a,long b)
    {
        if(a==0)
            return b;
        return GCD(b%a,a);
    }
    public static long countMagicalNumber(int B,int C,long mid,int M)
    {
        long count = 0;
        count = mid/(B*1l) + mid/(C*1l);
        long gcd = GCD(B,C);
        long lcm = (1l*B*C)/gcd;
        count = count - (mid/lcm);
        return count;
    }
    public static int solve(int A, int B, int C) {
        int M = 1000000007;
        long low = Math.min(B,C);
        long high = (1l*A)*low;
        System.out.println("low: "+low+" High: "+high);
        long ans = -1;
        while(low<=high)
        {
            long mid = low + (high-low)/2;
            System.out.println("low: "+low+" High: "+high+" Mid: "+mid);
            long count = countMagicalNumber(B,C,mid,M);
            System.out.println("Count: "+count);
            if(count >= (long)A)
            {
                ans = mid;
                high = mid-1;
            }
            else if(count > (long)A)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        ans = ans%M;
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(solve(807414236, 3788, 38141));
    }
}