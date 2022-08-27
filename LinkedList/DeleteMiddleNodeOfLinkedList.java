/*
Source: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/assignment/problems/4227/?navref=cl_pb_nv_tb

Given a singly linked list, delete middle of the linked list.
For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
Return the head of the linked list after removing the middle node.
If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class DeleteMiddleNodeOfLinkedList {
    public static ListNode solve(ListNode A) {
        if(A == null)
            return A;
        int count = 0;
        ListNode temp = A;
        while(temp.next!=null)
        {
            count++;
            temp = temp.next;
        }
        count++;
        if(count == 1)
            return null;
        int mid = 0;
        if(count%2 == 0)
        {
            mid = (count+1)/2;
        }
        else
        {
            mid = count/2;
        }
        mid--;
        temp = A;
        while(mid!=0)
        {
            temp = temp.next;
            mid--;
        }
        temp.next = temp.next.next;
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
        head = solve(head);
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
