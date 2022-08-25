/*
Source: https://leetcode.com/problems/power-of-three/
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Example 2:
Input: n = 0
Output: false
Example 3:
Input: n = 9
Output: true
 
Constraints:
-2^31 <= n <= 2^31 - 1
 
Follow up: Could you solve it without loops/recursion?
*/
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        while(n%3 == 0)
        {
            n = n / 3;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }
}
