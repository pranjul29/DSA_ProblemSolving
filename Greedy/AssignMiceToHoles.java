/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34953/homework/problems/290/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/assign-mice-to-holes/
N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Problem Constraints
1 <= N <= 10^5
-10^9 <= A[i], B[i] <= 10^9

Example Input
Input 1:
 A = [-4, 2, 3]
 B = [0, -2, 4]
Input 2:
 A = [-2]
 B = [-6]

Example Output
Output 1:
 2
Output 2:
 4

Example Explanation
Explanation 1:
 Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
 The number of moves required will be 2, 2 and 1 respectively.
 So, the time taken will be 2.
Explanation 2:
 Assign the mouse at position -2 to -6.
 The number of moves required will be 4.
 So, the time taken will be 4.
*/
import java.util.*;
public class AssignMiceToHoles {
    public static int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int maximum = Integer.MIN_VALUE;
        for(int i = 0;i<A.length;i++)
        {
            maximum = Math.max(maximum,Math.abs(A[i]-B[i]));
        }
        return maximum;
    }
    public static void main(String[] args) {
        int[] A = {-4, 2, 3};
        int[] B = {0, -2, 4};
        System.out.println(mice(A, B));
    }
}
