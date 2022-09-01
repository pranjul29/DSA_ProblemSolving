/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29522/assignment/problems/33/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/reorder-list/
Given a singly linked list A
 A: A0 → A1 → … → An-1 → An 
reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.

Problem Constraints
1 <= |A| <= 10^6

Example Input
Input 1:
 A = [1, 2, 3, 4, 5] 
Input 2:
 A = [1, 2, 3, 4] 

Example Output
Output 1:
 [1, 5, 2, 4, 3] 
Output 2:
 [1, 4, 2, 3] 

Example Explanation
Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class ReorderList {
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
    public static ListNode reorderList(ListNode A) {
        if(A == null)
            return null;
        ListNode fast = A;
        ListNode slow = A;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        ListNode newList;
        ListNode temp1 = A;
        ListNode temp2 = head2;
        newList = temp1;
        temp1 = temp1.next;
        ListNode temp3 = newList;
        int flag = 1;
        while((flag == 0 && temp1!=null) || (flag==1 && temp2!=null))
        {
            if(flag == 1)
            {
                temp3.next = temp2;
                temp2 = temp2.next;
                temp3 = temp3.next;
                flag = 0;
            }
            else
            {
                temp3.next = temp1;
                temp1 = temp1.next;
                temp3 = temp3.next;
                flag = 1;
            }
        }
        return newList;
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
        head = reorderList(head);
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
