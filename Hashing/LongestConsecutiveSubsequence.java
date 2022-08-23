/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/assignment/problems/152/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/longest-consecutive-sequence/
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.

Problem Constraints
1 <= N <= 10^6
-10^6 <= A[i] <= 10^6

Example Input
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:
 The set of consecutive elements will be [1, 2].
*/
import java.util.*;
public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> hm = new HashSet<Integer>();
        for(int i = 0;i<A.length;i++)
            hm.add(A[i]);
        int longest = 1;
        int count = 0;
        for(int i = 0;i<A.length;i++)
        {
            if(hm.contains(A[i]-1))
                continue;
            else
            {
                count = 1;
                int temp = A[i] + 1;
                while(true)
                {
                    if(hm.contains(temp))
                    {
                        count++;
                        temp++;
                    }
                    else
                    {
                        break;
                    }
                }
                if(count > longest)
                    longest = count;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        //int[] arr = {100,4,200,1,3,2};
        int[] arr = {6,4,5,2,3};
        System.out.println(longestConsecutive(arr));
    }
}
