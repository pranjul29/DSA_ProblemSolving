/* 
Source: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
If you choose a job that ends at time X you will be able to start another job that starts at time X.

Example 1:
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 
Constraints:
1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4
*/
import java.util.*;
public class MaximumProfitInJobScheduling {
    static int[][] jobs;
    static int getLastPossibleJob(int i)
    {
        int low = 0;
        int high = i-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(jobs[mid][1] <= jobs[i][0])
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new int[startTime.length][3];
        for(int i = 0;i<jobs.length;i++)
        {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs,(a,b) ->{
            return a[1] - b[1];
        });
        int[] dp = new int[startTime.length];
        Arrays.fill(dp,-1);
        dp[0] = jobs[0][2];
        for(int i = 1;i<startTime.length;i++)
        {
            int ifExcluded = dp[i-1];
            int ifIncluded = jobs[i][2];
            int index = getLastPossibleJob(i);
            if(index != -1)
                ifIncluded += dp[index];
            dp[i] = Math.max(ifExcluded,ifIncluded);
        }
        return dp[startTime.length-1];
    }
    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.println(jobScheduling(startTime,endTime,profit));
    }
}
