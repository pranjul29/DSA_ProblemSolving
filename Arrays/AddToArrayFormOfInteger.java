/* 
Source: https://leetcode.com/problems/add-to-array-form-of-integer/description/
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 

Constraints:

1 <= num.length <= 10^4
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104
*/
import java.util.*;
public class AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int counter = num.length-1;
        int carry = 0;
        while(k>0 || counter >= 0)
        {
            int number = 0;
            if(counter >= 0)
                number = carry + num[counter] + k%10;
            else
                number = carry + k%10;
            k=k/10;
            if(number >= 10)
            {
                carry = 1;
                result.add(0,number%10);
            }
            else
            {
                carry = 0;
                result.add(0,number);
            }
            counter--;
        }
        if(carry == 1)
            result.add(0,carry);
        return result;
    }
    public static void main(String[] args) {
        int[] num = {1,2,0,0};
        int k = 34;
        System.out.println(addToArrayForm(num,k));
    }
}
