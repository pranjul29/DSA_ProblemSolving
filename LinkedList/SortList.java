/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29522/homework/problems/34?navref=cl_tt_lst_nm
Source: https://leetcode.com/problems/sort-list/
Sort a linked list, A in O(n log n) time using constant space complexity.

Problem Constraints
0 <= |A| = 10^5

Example Input
Input 1:
A = [3, 4, 2, 8]
Input 2:
A = [1]

Example Output
Output 1:
[2, 3, 4, 8]
Output 2:
[1]

Example Explanation
Explanation 1:
 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:
 The sorted form of [1] is [1].
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class SortList {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp1 = A;
        ListNode temp2 = B;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val < temp2.val)
            {
                curr.next = temp1;
                temp1 = temp1.next;
            }
            else
            {
                curr.next = temp2;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }
        while(temp1!=null)
        {
            curr.next = temp1;
            temp1 = temp1.next;
            curr = curr.next;
        }
        while(temp2!=null)
        {
            curr.next = temp2;
            temp2 = temp2.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    public static ListNode findMiddle(ListNode A)
    {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode sortList(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode mid = findMiddle(A);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode head1 = A;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return mergeTwoLists(head1,head2);
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
            head = sortList(head);
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
