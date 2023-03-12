/* 
Source: https://leetcode.com/problems/minimum-time-to-complete-trips/description/
You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.

Example 1:

Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.
Example 2:

Input: time = [2], totalTrips = 1
Output: 2
Explanation:
There is only one bus, and it will complete its first trip at t = 2.
So the minimum time needed to complete 1 trip is 2.
 

Constraints:

1 <= time.length <= 10^5
1 <= time[i], totalTrips <= 10^7
*/
public class MinimumTimeToCompleteTrips {
    static boolean isPossible(int[] time,int totalTrips,long minTime)
    {
        long count = 0;
        for(int t : time)
            count+= minTime/((long)t);
        if(count < (long)totalTrips)
            return false;
        return true;
    }
    public static long minimumTime(int[] time, int totalTrips) {
        // long low = 1;
        int max = Integer.MAX_VALUE;
        for(int t : time)
            max = Math.min(max,t);
        long low = max;
        long high = (((long)max*(long)totalTrips));
        long ans = -1;
        // System.out.println(low);
        // System.out.println(high);
        while(low<=high)
        {
            long mid = (high-low)/2 + low;
            if(isPossible(time,totalTrips,mid))
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
            // System.out.println("MID: " + mid + " ANS: " + ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] time = {1,2,3};
        int totalTrips = 5;
        System.out.println(minimumTime(time,totalTrips));
    }
}
