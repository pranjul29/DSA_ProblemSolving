/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29486/homework/problems/1072/?navref=cl_pb_nv_tb

Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
"^" means power,
"%" means "mod", and
"!" means factorial.

Problem Constraints
1 <= A, B <= 5e5

Example Input
Input 1:
A = 1
B = 1
Input 2:
A = 2
B = 2

Example Output
Output 1:
1
Output 2:
4

Example Explanation
Explanation 1:
 1! = 1. Hence 1^1 = 1.
Explanation 2:
 2! = 2. Hence 2^2 = 4.
*/
public class VeryLargePower {
    public static long fastPow(int A,int B,int C)
    {
        if(B == 0)
            return 1;
        long x = fastPow(A,B/2,C)%C;
        if(B%2 == 0)
        {
            long temp = (x*x)%C;
            if(temp < 0)
                temp = temp + C;
            return temp;
        }
        else
        {
            long temp = (x*x)%C;
            if(temp < 0)
                temp = temp + C;
            temp = (temp*A)%C;
            if(temp < 0)
                temp = temp + C;
            return temp;
        }
    }
    
    public static int solve(int A, int B) {
        long result = 1;
        int M = 1000000007;
        long fact = 1;
        for(int i = 1;i<=B;i++)
        {
            fact = (fact * i)%(M-1);
        }
        result = fastPow(A,(int)fact,M);
        return (int)result;
    }
    public static void main(String[] args) {
        System.out.println(solve(2, 2));
    }
}
