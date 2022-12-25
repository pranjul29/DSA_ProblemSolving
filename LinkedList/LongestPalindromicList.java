/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/29524/assignment/problems/4386/?navref=cl_pb_nv_tb

Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
A palindrome list is a list that reads the same backward and forward.
Expected memory complexity : O(1)

Problem Constraints
1 <= length of the linked list <= 2000
1 <= Node value <= 100

Input Format
The only argument given is head pointer of the linked list.

Output Format
Return the length of the longest palindrome list.

Example Input
Input 1:
 2 -> 3 -> 3 -> 3
Input 2:
 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2

Example Output
Output 1:
 3
Output 2:
 5

Example Explanation
Explanation 1:
 3 -> 3 -> 3 is largest palindromic sublist
Explanation 2:
 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class LongestPalindromicList {
    public static int countCommon(ListNode A,ListNode B)
    {
        int count = 0;
        while(A!=null && B!=null)
        {
            if(A.val == B.val)
            {
                count++;
            }
            else
                break;
            A = A.next;
            B = B.next;
        }
        return count;
    }
    public static int maxPalindrome(ListNode A)
    {
        ListNode curr = A;
        ListNode prev = null;
        int result = 0;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            

            result = Math.max(result,2*countCommon(next,prev) + 1);

            result = Math.max(result,2*countCommon(curr,next));

            prev = curr;
            curr = next;
        }
        return result;
    }
    public static int solve(ListNode A) {
        return maxPalindrome(A);
    }
}
