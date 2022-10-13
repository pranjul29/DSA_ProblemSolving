/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34953/homework/problems/4669/?navref=cl_pb_nv_tb
The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:
 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.
Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).

Problem Constraints
1 <= A <= 2×10^9

Example Input
Input 1:
 A = 47
Input 2:
 A = 9

Example Output
Output 1:
 7
Output 2:
 5

Example Explanation
Explanation 1:
 Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
Explanation 2:
 Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).
*/
public class AnotherCoinProblem {
    public static int solve(int A) {
        int count = 0;
        while(A>0)
        {
            int result = (int)(Math.log(A) / Math.log(5));
            int n = A/(int)Math.pow(5,result);
            count+=n;
            A -= Math.pow(5,result)*n;
        }
        return count;
    }
    public static void main(String[] args) {
        int A = 14871;
        System.out.println(solve(A));
    }
}
