/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29522/homework/problems/36/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: list1 = [], list2 = []
Output: []
Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null)
            return B;
        else if(B == null)
            return A;
        ListNode temp1 = A;
        ListNode temp2 = B;
        ListNode newList;
        if(temp1.val < temp2.val)
        {
            newList = temp1;
            temp1 = temp1.next;
        }
        else{
            newList = temp2;
            temp2 = temp2.next;
        }
        ListNode temp3 = newList;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val < temp2.val)
            {
                temp3.next = temp1;
                temp1 = temp1.next;
                temp3 = temp3.next;
            }
            else
            {
                temp3.next = temp2;
                temp2 = temp2.next;
                temp3 = temp3.next;
            }
        }
        while(temp1!=null)
        {
            temp3.next = temp1;
            temp3 = temp3.next;
            temp1 = temp1.next;
        }
        while(temp2!=null)
        {
            temp3.next = temp2;
            temp3 = temp3.next;
            temp2 = temp2.next;
        }
        return newList;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode temp = head1;
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

        ListNode head2 = new ListNode();
        temp = head2;
        int[] arr1 = {6,7,8,9};
        count = 0;
        while(count<arr1.length)
        {
            temp.val = arr1[count];
            count++;
            if(count == arr1.length)
                break;
            else
                temp.next = new ListNode();
            temp = temp.next;
        }
        ListNode head = mergeTwoLists(head1, head2);
        temp = head;
        while(temp!=null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }
}

