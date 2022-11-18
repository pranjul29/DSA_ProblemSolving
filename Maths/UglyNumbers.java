/* 
Source: https://leetcode.com/problems/ugly-number/
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 
Constraints:
-2^31 <= n <= 2^31 - 1
*/
public class UglyNumbers {
    public static int mod(int n,int m)
    {
        if(n<0)
            return (n%m + m)%m;
        else
            return n%m;
    }
    public static boolean isUgly(int n) {
        if(n == 0)
            return false;
        while(mod(n,2) == 0)
            n = n/2;
        while(mod(n,3) == 0)
            n = n/3;
        while(mod(n,5) == 0)
            n = n/5;
        if(n == 1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int n = 19871;
        System.out.println(isUgly(n));
    }
}
