/* 
Source: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
You are given an integer array nums of length n, and an integer array queries of length m.
Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
Example 2:
Input: nums = [2,3,4,5], queries = [1]
Output: [0]
Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.

Constraints:
n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 10^6
*/
import java.util.*;
public class LongestSubsequenceWithLimitedSum {
    public static int maxSubSequenceLength(int[] nums,int q)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid] <= q)
            {
                ans = mid+1;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        if(ans == -1)
            return 0;
        return ans;
    }
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++)
            nums[i] = nums[i-1] + nums[i];
        
        int[] ans = new int[queries.length];
        
        for(int i = 0;i<ans.length;i++)
            ans[i] = maxSubSequenceLength(nums,queries[i]);
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(answerQueries(nums,queries));
    }
}
