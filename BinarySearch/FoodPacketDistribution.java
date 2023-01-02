/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29508/homework/problems/9928/?navref=cl_pb_nv_tb
The government wants to set up B distribution offices across N cities for the distribution of food
packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city. We want to maximize the minimum number of people who can get food in any single office.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^6
1 <= B <= 5 x 10^5

Input Format
The first line of input contains an integer array A. 
The second line of input contains an integer B.

Output Format
Return one integer representing the maximum number of people who can get food in any single office.

Example Input
Input 1:
  A = [10000, 20000, 30000]
  B = 6
Input 2:
  A = [1, 1, 1]
  B = 4

Example Output
Output 1:
  10000
Output 2:
  0

Example Explanation
Explanation 1:
  1 office can be opened in the first city,
  2 offices in the second city and
  3 in the third. This way ,
  10,000 people can get food in the office in the first city, and
  10,000 people can get food in each office in the second city and
  10,000 people can get food in third city.
  We will allot 10000 people in each office in the third city. 
  Had we alloted more in some office, we had to allot lesser in some other office which will reduce the answer.
Explanation 2:
  We will have to allot 2 offices to one city. And one of these offices would give food to 0 people. 
*/
class Solution {
    public boolean isPossible(int[] A,int B,int mid)
    {
        int count = 0;
        for(int i = 0;i<A.length;i++)
        {
            count += A[i]/mid;
        }
        return count >= B;
    }
    public int solve(int[] A, int B) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<A.length;i++)
        {
            sum += (long)A[i];
            min = Math.min(min,A[i]);
        }
        if(sum < B)
            return 0;
        if(sum == B)
            return 1;
        int low = 1;
        int high = min;
        int ans = 0;
        while(low<=high)
        {
            int mid = (high-low)/2 + low;
            if(isPossible(A,B,mid))
            {
                low = mid+1;
                ans = mid;
            } 
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
}

public class FoodPacketDistribution {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5};
        int B = 13;
        Solution s = new Solution();
        System.out.println(s.solve(arr, B));;
        // System.out.println(s.checkValid(arr, B, 2));
    }
}
