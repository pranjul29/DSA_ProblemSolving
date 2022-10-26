/* 
Source; https://leetcode.com/problems/climbing-stairs/
Source; https://www.scaler.com/academy/mentee-dashboard/class/34965/assignment/problems/30?navref=cl_tt_lst_nm
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 
Constraints:
1 <= n <= 45
*/
public class Stairs {
    public static int climbStairs(int n) {
        int M = 1000000007;
        int[] ways = new int[n+1];
        if(n <=2)
            return n;
        ways[1] = 1;
        ways[2] = 2;
        for(int i = 3;i<=n;i++)
        {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
    public static void main(String[] args) {
        int n = 30;
        System.out.println(climbStairs(n));
    }
}
