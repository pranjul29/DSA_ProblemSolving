/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29484/homework/problems/936/?navref=cl_pb_nv_tb

Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

Constraints:

1) 1 <= A <= 10^9

Example Input
A = 5

Example Output
10

Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */

public class StrangeEquality {
    public static int highestSetBit(int A)
    {
        for(int i = 30;i>=0;i--)
        {
            if(((1<<i)&A) > 0)
                return i;
        }
        return 0;
    }
    public static int solve(int A) {
        int highSetBit = highestSetBit(A);

        int X = 0;
        for(int i = highSetBit-1;i>=0;i--)
        {
            if(((1<<i)&A) == 0)
                X = X + (1<<i);
        }
        int Y = 1<<(highSetBit+1);
        return X^Y;
    }
    public static void main(String[] args)
    {
        System.out.println(solve(5));
    }
}
