/*
Source: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/

Given a sorted linked list, delete all duplicates such that each element appears only once.

Problem Constraints
0 <= length of linked list <= 10^6

Example Input
Input 1:
 1->1->2
Input 2:
 1->1->2->3->3

Example Output
Output 1:
 1->2
Output 2:
 1->2->3

Example Explanation
Explanation 1:
 Each element appear only once in 1->2.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        while(temp!=null)
        {
            while(temp.next!=null && temp.val == temp.next.val)
            {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return A;
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
        head = deleteDuplicates(head);
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
