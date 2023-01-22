/* 
Source: https://leetcode.com/problems/non-decreasing-subsequences/description/
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 
Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
*/
import java.util.*;
public class NonDecreasingSubsequence {
    static HashSet<List<Integer>> result;
    static void generateSubsequence(int index,int[] nums,List<Integer> temp,int previous)
    {
        if(index == nums.length)
        {
            List<Integer> temp_list = new ArrayList<Integer>(temp);
            if(temp.size() > 1)
                result.add(temp_list);
            return;
        }
        generateSubsequence(index+1,nums,temp,previous);
        if(nums[index] >= previous)
        {
            temp.add(nums[index]);
            generateSubsequence(index+1,nums,temp,nums[index]);
            temp.remove(temp.size()-1);
        }
        
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        result = new HashSet<>();
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<>();
        generateSubsequence(0,nums,temp,Integer.MIN_VALUE);
        for(List<Integer> list: result)
            results.add(list);
        return results;
    }
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(findSubsequences(nums));
    }
}
