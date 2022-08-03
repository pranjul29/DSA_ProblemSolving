/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29490/homework/problems/1262/?navref=cl_pb_nv_tb

You are given an even number N and you need to represent the given number as the sum of primes. The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.

You need to determine the minimum number of prime numbers needed to represent the given number.

Examples

Input
26
Output
2

Explanation
Testcase 1-

You can represent 26 as: 13+13
So we require minimum of 2 prime numbers to represent the number 26.
*/
public class PrimeAddition {
    public static int solve(int A) {
        if(A == 2)
            return 1;
        return 2;
    }
    public static void main(String[] args)
    {
        System.out.println(solve(10));
    }
    
}
