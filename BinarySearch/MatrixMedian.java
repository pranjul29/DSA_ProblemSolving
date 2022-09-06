/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29506/homework/problems/357/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/matrix-median/
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 10^5
1 <= N*M <= 10^6
1 <= A[i] <= 10^9
N*M is odd

Example Input
Input 1:
A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ] 
Input 2:
A = [   [5, 17, 100]    ]

Example Output
Output 1:
 5 
Output 2:
 17

Example Explanation
Explanation 1:
A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5. 
Explanation 2:
Median is 17.
*/
public class MatrixMedian {
    public static int countLessElements(int[][] A,int mid, int N,int M)
    {
        int count = 0;
        for(int i = 0;i<N;i++)
        {
            if(A[i][M-1] < mid)
            {
                count+= M;
            }
            else
            {
                int low = 0;
                int high = M-1;
                int ans = 0;
                while(low<=high)
                {
                    int middle = (low+high)/2;
                    // System.out.println("MIDDLE : "+middle);
                    if(A[i][middle]<mid)
                    {
                        ans = middle+1;
                        low = middle+1;
                    }
                    else
                    {
                        high = middle-1;
                    }
                }
                count+=ans;
            }
            System.out.println(count);
        }
        return count;
    }
    public static int findMedian(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int low = A[0][0];
        for(int i = 0;i<N;i++)
        {
            if(A[i][0] < low)
                low = A[i][0];
        }
        int high = A[N-1][M-1];
        for(int i = 0;i<N;i++)
        {
            if(A[i][M-1] > high)
                high = A[i][M-1];
        }
        System.out.println(low);
        System.out.println(high);
        int middle_index = N*M/2;
        
        int ans = -1;
        while(low<=high)
        {
            int mid = high + (low-high)/2;
            int count = countLessElements(A,mid,N,M);
            System.out.println("MID: "+mid+" Count: "+count);
            if(count <= middle_index)
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {{5},{4},{3},{1},{3},{1},{4},{2},{5},{3},{3}};
        System.out.println(findMedian(arr));
    }
}
