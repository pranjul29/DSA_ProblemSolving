/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34953/assignment/problems/3/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/candy/description/
N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?

Problem Constraints
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9

Input Format
The first and only argument is an integer array A representing the rating of children.

Output Format
Return an integer representing the minimum candies to be given.

Example Input
Input 1:
 A = [1, 2]
Input 2:
 A = [1, 5, 2, 1]

Example Output
Output 1:
 3
Output 2:
 7

Example Explanation
Explanation 1:
 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. 
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:
 Candies given = [1, 3, 2, 1]
*/
import java.util.*;
public class DistributeCandy {
    public static int candy(int[] A) {
        // int[] candies = new int[A.length];
        int[] left2Right = new int[A.length];
        int[] right2Left = new int[A.length];
        Arrays.fill(left2Right,1);
        Arrays.fill(right2Left,1);
        for(int i = 1;i<A.length;i++)
        {
            if(A[i] > A[i-1])
                left2Right[i] = left2Right[i-1] + 1;
        }
        for(int i = A.length-2;i>=0;i--)
        {
            if(A[i] > A[i+1])
                right2Left[i] = right2Left[i+1] + 1;
        }
        int count = 0;
        for(int i = 0;i<A.length;i++)
            count += Math.max(left2Right[i],right2Left[i]);
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        System.out.println(candy(A));
    }
}
