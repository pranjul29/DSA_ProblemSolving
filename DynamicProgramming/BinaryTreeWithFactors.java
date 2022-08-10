/*
Source: https://leetcode.com/problems/binary-trees-with-factors/

Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

Example 1:
Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:
Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 
Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 10^9
All the values of arr are unique.
*/
import java.util.*;
public class BinaryTreeWithFactors {
    public static int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        int M = 1000000007;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++)
        {
            hm.put(arr[i],i);
        }
        for(int i = 0;i<arr.length;i++)
            dp[i] = 1;
        for(int i = 1;i<arr.length;i++)
        {
            int temp = arr[i];
            for(int j = 2;j<=Math.sqrt(temp);j++)
            {
                if(temp%j == 0)
                {
                    if(temp/j == j)
                    {
                        if(hm.containsKey(temp/j))
                        {
                            
                            dp[i] = (dp[i] + (dp[hm.get(temp/j)]*dp[hm.get(temp/j)])%M)%M;
                        }
                    }
                    else
                    {
                        if(hm.containsKey(temp/j) && hm.containsKey(j))
                        {
                            dp[i] = (dp[i] + (dp[hm.get(temp/j)]*dp[hm.get(j)]*2)%M)%M;
                        }
                    }
                }
            }
        }
        long sum = 0;
        for(int i = 0;i<arr.length;i++)
            sum = (sum + dp[i])%M;
        return (int)sum;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,10};
        System.out.println(numFactoredBinaryTrees(arr));
    }
}
