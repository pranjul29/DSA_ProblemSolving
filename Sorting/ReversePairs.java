/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29500/homework/problems/4192/?navref=cl_pb_nv_tb

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.

Problem Constraints
1 <= length of the array <= 10^5
-2 * 10^9 <= A[i] <= 2 * 10^9

Example Input
Input 1:
 A = [1, 3, 2, 3, 1]
Input 2:
 A = [4, 1, 2]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:
 There is only one pair i.e (4, 1).


*/
class Solution {
    public long merge(int[] A,int s,int e)
    {
        if(s==e)
            return 0;
        int mid = s + (e-s)/2;
        long l = merge(A,s,mid);
        long r = merge(A,mid+1,e);
        int[] temp = new int[(int)(e-s+1)];
        int p1 = s;
        int p2 = mid+1;
        long count = 0;
        int c = 0;
        while(p1<=mid && p2 <= e)
        {
            if(A[p1] <= A[p2])
            {
                temp[c] = A[p1];
                p1++;
                c++;
            }
            else
            {
                temp[c] = A[p2];
                if(A[p2] < 0)
                {
                    for(int i = s;i<=mid;i++)
                    {
                        long second= ((long)A[p2])*2;
                        long first = (long)A[i];
                        if(first > second)
                        {
                            count = count + (mid-i+1);
                            break;
                        }
                    }
                }
                else
                {
                    for(int i = p1;i<=mid;i++)
                    {
                        long second= ((long)A[p2])*2;
                        long first = (long)A[i];
                        if(first > second)
                        {
                            count = count + (mid-i+1);
                            break;
                        }
                    }
                }
                p2++;
                c++;
            }
        }
        while(p1<=mid)
        {
            temp[c] = A[p1];
            p1++;
            c++;
        }
        while(p2<=e)
        {
            temp[c] = A[p2];
            if(A[p2] < 0)
            {
                for(int i = s;i<=mid;i++)
                    {
                        long second= ((long)A[p2])*2;
                        long first = (long)A[i];
                        if(first > second)
                        {
                            count = count + (mid-i+1);
                            break;
                        }
                    }
            }
            p2++;
            c++;
        }
        int j = 0;
        for(int i = s;i<=e;i++)
        {
            A[i] = temp[j];
            j++;
        }
        
        return count+l+r;
    }
    public int solve(int[] A) {
        return (int)merge(A,0,A.length-1);
    }
}
public class ReversePairs {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40};
        System.out.println(s.solve(A));
    }
}
