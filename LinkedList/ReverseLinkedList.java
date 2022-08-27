/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/assignment/problems/40?navref=cl_tt_lst_nm
Source: https://leetcode.com/problems/reverse-linked-list/
You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
NOTE: You have to do it in-place and in one-pass.

Problem Constraints
1 <= Length of linked list <= 10^5
Value of each node is within the range of a 32-bit integer.

Example Input
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
Input 2:
 A = 3 -> NULL 

Example Output
Output 1:
 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
Output 2:
 3 -> NULL 

Example Explanation
Explanation 1:
 The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
Expalantion 2:
 The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL 
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode() {}
}
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        while(curr!=null)
        {
            ListNode future = curr.next;
            curr.next = prev;
            prev = curr;
            curr = future;
        }
        return prev;
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
        head = reverseList(head);
        temp = head;
        if(head == null)
            return;
        while(temp.next!=null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print(temp.val);
        System.out.println();
    }
}
