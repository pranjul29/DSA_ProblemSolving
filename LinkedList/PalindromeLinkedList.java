/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29524/assignment/problems/331/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/palindrome-linked-list/
Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
*/
import java.util.*;
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
public class PalindromeLinkedList {
    public static ListNode reverse(ListNode A)
    {
        ListNode prev = null;
        ListNode curr = A;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static boolean isPalindrome(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        middle = reverse(middle);
        ListNode temp1 = A;
        ListNode temp2 = middle;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val !=temp2.val)
            {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1;i<arr.length;i++)
        {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        System.out.println(isPalindrome(head));
    }
}
