/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29504/homework/problems/198/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/median-of-two-sorted-arrays/
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

Problem Constraints
1 <= N + M <= 2*10^6

Example Input
Input 1:
 A = [1, 4, 5]
 B = [2, 3]
Input 2:
 A = [1, 2, 3]
 B = [4]

Example Output
Output 1:
 3.0
Output 2:
 2.5

Example Explanation
Explanation 1:
 The median of both the sorted arrays will be 3.0.
Explanation 2:
 The median of both the sorted arrays will be (2+3)/2 = 2.5.
*/
import java.util.*;
class Solution {
	// DO NOT MODIFY BOTH THE LISTS
    public static int countLessElements(List<Integer> a,int k)
    {
        int low = 0;
        int high = a.size()-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int value = a.get(mid);
            if(value < k)
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans+1;
    }
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int N = a.size();
        int M = b.size();
        int low = 0;
        int high = 0;
        boolean even = false;
        if((N+M)% 2 == 0)
            even = true;
        if(a.size() == 0)
        {
            if(even)
            {
                double ans = ((double)b.get(M/2) + (double)b.get(M/2 - 1))/2;
                return ans;
            }
            else
                return (double)b.get(M/2);
        }
        else if(b.size() == 0)
        {
            if(even)
            {
                double ans = ((double)a.get(N/2) + (double)a.get(N/2 - 1))/2;
                return ans;
            }
            else
                return (double)a.get(N/2);
        }
        low = Math.min(a.get(0),b.get(0));
        high = Math.max(a.get(N-1),b.get(M-1));
        int middle_index = (N+M)/2;
        System.out.println("Middle_index: "+middle_index);
        double ans = 0;
        // middle_index++;
        while(low<=high)
        {
            System.out.println("Low: "+low+" High: "+high);
            int mid = (low+high)/2;
            System.out.println(mid);
            int count = countLessElements(a,mid) + countLessElements(b,mid);
            System.out.println("Count: "+count+" Middle Index: "+middle_index);
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
        System.out.println(ans);
        if((N+M)%2 == 0)
        {
            middle_index--;
            double ans1 = 0;
            low = Math.min(a.get(0),b.get(0));
            high = Math.max(a.get(N-1),b.get(M-1));
            while(low<=high)
            {
                System.out.println("Low: "+low+" High: "+high);
                int mid = (low+high)/2;
                System.out.println(mid);
                int count = countLessElements(a,mid) + countLessElements(b,mid);
                System.out.println("Count: "+count+" Middle Index: "+middle_index);
                if(count <= middle_index)
                {
                    ans1 = mid;
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            ans += ans1;
            ans = ans/2;
        }
        return ans;
	}
}
public class MedianArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        // -50, -41, -40, -19, 5, 21, 28
        a.add(-50);a.add(-41);a.add(-40);a.add(-19);a.add(5);a.add(21);a.add(28);
        // -50, -21, -10
        b.add(-50);b.add(-21);b.add(-10);
        // -50, -50, -41, -40, -21, -19, -10, 5, 21, 28
        System.out.println(s.findMedianSortedArrays(a, b));
    }
}

// Binary Search Function is Sending Wrong Answer for Duplicate, Try to understand if it requires to send first occurence or Last and implement Function Accordingly