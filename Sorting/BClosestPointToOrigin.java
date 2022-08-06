/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29500/homework/problems/4194/?navref=cl_pb_nv_tb
Soure: https://leetcode.com/problems/k-closest-points-to-origin/

We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)^2 + (y1-y2)^2 ).

Problem Constraints
1 <= B <= length of the list A <= 10^5
-10^5 <= A[i][0] <= 10^5
-10^5 <= A[i][1] <= 10^5

Example Input
Input 1:
 A = [[1, 3],[-2, 2]]
 B = 1
Input 2:
 A = [[1, -1],[2, -1]] 
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
public class BClosestPointToOrigin {
    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A,(a,b) -> {
            long distance_a = a.get(0)*a.get(0) + a.get(1)*a.get(1);
            long distance_b = b.get(0)*b.get(0) + b.get(1)*b.get(1);
            if(distance_a < distance_b)
                return -1;
            else
                return 1;
        });
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<B;i++)
        {
            result.add(A.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);temp.add(3);
        arr.add(temp);
        temp.clear();
        temp.add(-2);temp.add(2);
        arr.add(temp);
        ArrayList<ArrayList<Integer>> result = solve(arr, 1);
        for(int i = 0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    
}
