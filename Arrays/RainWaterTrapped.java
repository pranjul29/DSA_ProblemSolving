/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 10^4
0 <= height[i] <= 10^5
*/
public class RainWaterTrapped {
    public static int trap(int[] height) {
        int N = height.length;
        int[] left_max = new int[N];
        int[] right_max = new int[N];
        left_max[0] = height[0];
        right_max[N-1] = height[N-1];
        for(int i = 1;i<N;i++)
        {
            left_max[i] = Math.max(left_max[i-1],height[i]);
            right_max[N-i-1] = Math.max(right_max[N-i],height[N-i-1]);
        }
        int total = 0;
        for(int i = 0;i<N;i++)
        {
            total += Math.min(left_max[i],right_max[i])-height[i];
        }
        return total;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
