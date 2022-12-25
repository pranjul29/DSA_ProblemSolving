/* 
Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:
Input: prices = [1]
Output: 0
 
Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000
*/
public class BestTimeToBuyAndSellStockWithCooldown {
    static int[][] dp;
    static int profit(int start,int end,int[] prices)
    {
        if(start >= end)
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end];
        int ans = 0;
        for(int i = start+1;i<=end;i++)
        {
            // System.out.println("Start: "+ start + " i: " + i + " End: " + end);
            ans = Math.max(ans , prices[i] - prices[start] + profit(i+2,end,prices));
        }
        ans = Math.max(ans, profit(start+1,end,prices));
        dp[start][end] = ans;
        return ans;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][n];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++)
                dp[i][j] = -1;
        
        int ans = profit(0,n-1,prices);
        // for(int i = 0;i<n;i++)
        // {
        //     for(int j = 0;j<n;j++)
        //         System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }
        return ans;
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
