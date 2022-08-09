/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29508/homework/problems/270/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/allocate-books/

Given an array of integers A of size N and an integer B.
The College library has N books. The ith book has A[i] number of pages.
You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Problem Constraints
1 <= N <= 10^5
1 <= A[i], B <= 10^5

Example Input
A = [12, 34, 67, 90]
B = 2

Example Output
113

Example Explanation
There are two students. Books can be distributed in following fashion : 

1)  [12] and [34, 67, 90]
    Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
2)  [12, 34] and [67, 90]
    Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
3)  [12, 34, 67] and [90]
    Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
    Of the 3 cases, Option 3 has the minimum pages = 113
*/
public class AllocateBooks {
    public static boolean checkValid(int[] A,int mid,int B)
    {
        int c = 1;
        int sum = 0;
        for(int i = 0;i<A.length;i++)
        {
            sum = sum + A[i];
            if(sum > mid)
            {
                sum = A[i];
                c++;
            }
            if(c > B)
                return false;
        }
        return true;
    }
    public static int books(int[] A, int B) {
        int N = A.length;
        if(N < B)
        {
            return -1;
        }
        int low = A[0];
        int high = A[0];
        for(int i = 1;i<N;i++)
        {
            high += A[i];
            if(A[i] > low)
                low = A[i];
        }
        int ans = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(checkValid(A,mid,B))
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(arr, B));
    }
}
