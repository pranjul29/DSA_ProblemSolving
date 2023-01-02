/* 
Source: https://leetcode.com/problems/jump-game/description/
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5
*/
import java.util.*;
public class JumpGame {
    static int[] dp;
    static int canJumpFromIndex(int[] nums,int index)
    {
        //System.out.println(index);
        if(index >= nums.length)
            return 1;
        if(dp[index] != -1)
            return dp[index];
        int ans = 0;
        for(int i = nums[index];i>=1;i--)
        {
            ans = ans + canJumpFromIndex(nums,index+i);
            if(ans == 1)
                break;
        }
        dp[index] = ans;
        return ans;
    }
    public static boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[nums.length-1] = 1;
        if( canJumpFromIndex(nums,0) == 1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
