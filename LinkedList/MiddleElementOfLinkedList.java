/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/assignment/problems/4370/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/middle-of-the-linked-list/
Given a linked list of integers, find and return the middle element of the linked list.
NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 10^9

Example Input
Input 1:
 1 -> 2 -> 3 -> 4 -> 5
Input 2:
 1 -> 5 -> 6 -> 2 -> 3 -> 4

Example Output
Output 1:
 3
Output 2:
 2

Example Explanation
Explanation 1:
 The middle element is 3.
Explanation 2:
 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class MiddleElementOfLinkedList {
    public static int solve(ListNode A) {
        if(A == null)
            return -1;
        ListNode fast = A;
        ListNode slow = A;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int[] arr = {1,2,3,4,5};
        int count = 0;
        while(count<arr.length)
        {
            temp.val = arr[count];
            count++;
            if(count == arr.length)
                break;
            else
                temp.next = new ListNode();
            temp = temp.next;
        }
        System.out.println(solve(head));
    }
}
