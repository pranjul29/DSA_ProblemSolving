/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/assignment/problems/169/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/container-with-most-water/

Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 

Problem Constraints
0 <= N <= 10^5
1 <= A[i] <= 10^5

Example Input
Input 1:
A = [1, 5, 4, 3]
Input 2:
A = [1]

Example Output
Output 1:
 6
Output 2:
 0

Example Explanation
Explanation 1:
5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6
Explanation 2:
No container is formed.
*/
public class ContainerWithMostWater {
    public static int maxArea(int[] A) {
        int i = 0;
        int j = A.length-1;
        int ans = 0;
        while(i<j)
        {
            ans = Math.max(ans,(j-i)*Math.min(A[i],A[j]));
            if(A[i] < A[j])
            {
                i++;
            }
            else
                j--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3};
        System.out.println(maxArea(arr));
    }
}
