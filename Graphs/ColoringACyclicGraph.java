/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34997/assignment/problems/9358/?navref=cl_pb_nv_tb
Given the number of vertices A in a Cyclic Graph.
Your task is to determine the minimum number of colors required to color the graph so that no two Adjacent vertices have the same color.

Problem Constraints
3 <= A <= 10^9

Example Input
Input 1:
 5
Input 2:
 4

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 Color required = 3
Explanation 2:
 Color required = 2
*/
public class ColoringACyclicGraph {
    public static int solve(int A) {
        if(A == 1)
            return 1;
        if(A%2 == 0)
            return 2;
        else
            return 3;
    }    
    public static void main(String[] args) {
        int A = 5;
        System.out.println(solve(A));
    }
}
