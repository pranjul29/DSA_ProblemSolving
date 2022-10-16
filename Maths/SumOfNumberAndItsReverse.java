/*
Source: https://leetcode.com/problems/sum-of-number-and-its-reverse/
Given a non-negative integer num, return true if num can be expressed as the sum of any non-negative integer and its reverse, or false otherwise.

Example 1:
Input: num = 443
Output: true
Explanation: 172 + 271 = 443 so we return true.
Example 2:
Input: num = 63
Output: false
Explanation: 63 cannot be expressed as the sum of a non-negative integer and its reverse so we return false.
Example 3:
Input: num = 181
Output: true
Explanation: 140 + 041 = 181 so we return true. Note that when a number is reversed, there may be leading zeros.
 
Constraints:
0 <= num <= 10^5
*/
public class SumOfNumberAndItsReverse {
    public static int reverse(int A)
    {
        int temp = A;
        int reverse = A%10;
        A = A/10;
        while(A>0)
        {
            reverse = reverse*10 + A%10;
            A = A/10;
        }
        return reverse;
    }
    public static boolean sumOfNumberAndReverse(int num) {
        for(int i = 0;i<=num;i++)
        {
            int reverse = reverse(i);
            if (i+reverse == num)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int N = 443;
        System.out.println(sumOfNumberAndReverse(N));
    }
}
