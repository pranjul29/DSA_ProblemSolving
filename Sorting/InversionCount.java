/*
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Example Input
Input 1:
A = [3, 2, 1]
Input 2:
A = [1, 2, 3]

Example Output
Output 1:
3
Output 2:
0

Example Explanation
Explanation 1:
 All pairs are inversions.
Explanation 2:
 No inversions.
*/
public class InversionCount {
    static int M = 1000000007;
    public static long merge(int[] A,int s,int e)
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
                p2++;
                c++;
                count = (count + (long)(mid-p1+1))%M;
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
            p2++;
            c++;
        }
        int j = 0;
        for(int i = s;i<=e;i++)
        {
            A[i] = temp[j];
            j++;
        }
        
        return (count+l+r)%M;
    }
    public static int solve(int[] A) {
        return (int)merge(A,0,A.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {7,3,0,5,1,2,8,9,6,4};
        System.out.println(solve(arr));
    }
}
