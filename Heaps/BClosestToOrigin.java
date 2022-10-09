/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/homework/problems/4194/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/k-closest-points-to-origin/
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
1 <= B <= length of the list A <= 10^5
-10^5 <= A[i][0] <= 10^5
-10^5 <= A[i][1] <= 10^5

Example Input
Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1

Example Output
Output 1:
 [ [-2, 2] ]
Output 2:
 [ [1, -1] ]

Example Explanation
Explanation 1:
 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
*/
import java.util.*;
public class BClosestToOrigin {
    public static int[][] solve(int[][] A, int B) {
        PriorityQueue<ArrayList<Long>> heap = new PriorityQueue<>((o1, o2) -> o1.get(0).intValue() - o2.get(0).intValue());
        for(int i = 0;i<A.length;i++)
        {
            ArrayList<Long> temp = new ArrayList<>();
            long distance = ((long)Math.abs(A[i][0]))*((long)Math.abs(A[i][0])) + ((long)Math.abs(A[i][1]))*((long)Math.abs(A[i][1]));
            // distance = (long)Math.sqrt(distance);
            temp.add(distance);
            temp.add((long)A[i][0]);
            temp.add((long)A[i][1]);
            heap.add(temp);
        }
        int[][] result = new int[B][2];
        for(int i = 0;i<B;i++)
        {
            ArrayList<Long> temp = heap.poll();
            result[i][0] = temp.get(1).intValue();
            result[i][1] = temp.get(2).intValue();
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] A = {{1, 3},{-2, 2}};
        int B = 1;
        System.out.println(solve(A, B));
    }
}
