/* 
Source: https://leetcode.com/problems/add-digits/description/
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 
Constraints:
0 <= num <= 2^31 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?
*/
public class AddDigits {
    static int sumDigits(int num)
    {
        int sum = 0;
        while(num>0)
        {
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    public static int addDigits(int num) {
        while(num%10 != num)
        {
            num = sumDigits(num);
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(addDigits(6789));
    }
}
