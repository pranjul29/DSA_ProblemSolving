/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/assignment/problems/9323/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/k-diff-pairs-in-an-array/
Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

Problem Constraints
1 <= N <= 10^4
0 <= A[i], B <= 10^5

Example Input
Input 1:
 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:
 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:
 A = [1, 1, 1, 2, 2]
 B = 0

Example Output
Output 1:
 2
Output 2:
 5
Output 3:
 2

Example Explanation
Explanation 1:
 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:
 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:
 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
*/
import java.util.Arrays;
class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        int count = 0;
        while(j < A.length)
        {
            
            int diff = Math.abs(A[j] - A[i]);
            if(diff == B)
            {
                System.out.println("i: "+i+" j:"+j);
                count++;
                while(j<A.length-1 && A[j] == A[j+1] )
                {
                    j++;
                }
                while(i < j && A[i] == A[i+1])
                {
                    i++;
                }
                i++;
                j++;
            }
            else if(diff < B)
            {
                j++;
            }
            else
            {
                i++;
            }
            if(i == j)
                    j++;

        }
        return count;
    }
}
public class PairsWithGivenDiff {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,3,1,5,4};
        int B = 0;
        System.out.println(s.solve(A, B));
    }
}
