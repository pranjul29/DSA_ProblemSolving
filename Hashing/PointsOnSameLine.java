/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/29514/homework/problems/4219/?navref=cl_pb_nv_tb
Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.

Find and return the maximum number of points that lie on the same line.

Problem Constraints
1 <= (length of the array A = length of array B) <= 1000
-10^5 <= A[i], B[i] <= 10^5

Input Format
The first argument is an integer array A.
The second argument is an integer array B.

Output Format
Return the maximum number of points which lie on the same line.

Example Input
Input 1:
 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]
Input 2:
 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]

Example Output
Output 1:
 4
Output 2:
 2

Example Explanation
Explanation 1:
 The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
Explanation 2:
 Any 2 points lie on a same line.
*/
public class PointsOnSameLine {
    public static int __gcd(int a,int b)
    {
        if(a == 0)
            return b;
        else
            return __gcd(b%a,a);
    }
    public static int solve(int[] A, int[] B) {
        int ans = 0;
        int curmax = 0;
        int vertical = 0;
        int overlap = 0;
        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
        for(int i = 0;i<A.length;i++)
        {
            for(int j = i+1;j<A.length;j++)
            {
                if(A[i] == A[j] && B[i] == B[j])
                    overlap++;
                else if(A[i] == A[j])
                    vertical;
                else
                {
                    int x_diff = A[i]-A[j];
                    int y_diff = B[i]-B[j];
                    int gcd = __gcd(x_diff,y_diff);
                    x_diff = x_diff/gcd;
                    y_diff = y_diff/gcd;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x_diff);
                    temp.add(y_diff);
                    map.put(temp,map.getOrDefault(temp,0) + 1);
                    curmax = Math.max(curmax,map.get(temp));
                }
                curmax = Math.max(curmax,vertical);
            }
            ans = Math.max(ans,curmax + overlap +1);
        }
        return ans;
    }
    public static void main(String[] args) {
        // int[] A = {-44, 44, 32, -43, -41, 18, -29, 49, 19, 28, 26, 29, 39, -4, 2, -36, 6, -45, -17, 16, -9, 34, 20, -48, -21, -19, -28, -45, -8, 8, 13, -42, -35, 15, -12, -36, 42, 24, 41};
        // int[] B = {40, -9, -31, 43, 33, -34, -40, 25, 32, -5, 34, 41, -11, 24, -31, 9, -27, -20, -40, 35, -44, 29, 45, 40, 40, 33, -33, -20, -11, 20, -7, -28, 48, -44, 3, 39, 26, 21, 8};
        //ANS = 4

        int[] A = {48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37};
        int[] B = {47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37};
        for(int i = 0;i<A.length;i++)
        {
            System.out.println("A[i]: "+A[i]+ " B[i]: "+B[i]);
        }
        System.out.println(solve(A,B));
    }
}
