/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29522/assignment/problems/4226/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/blog/remove-loop-in-linked-list/
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.

Problem Constraints
1 <= number of nodes <= 1000

Example Input
Input 1:
1 -> 2
^    |
| - - 
Input 2:
3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -

Example Output
Output 1:
 1 -> 2 -> NULL
Output 2:
 3 -> 2 -> 4 -> 5 -> 6 -> NULL

Example Explanation
Explanation 1:
 Chain of 1->2 is broken.
Explanation 2:
 Chain of 4->6 is broken.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class RemoveLoopFromLinkedList {
    public static ListNode solve(ListNode A) {
        if(A == null)
            return null;
        ListNode fast = A;
        ListNode slow = A;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                ListNode p1 = slow;
                ListNode p2 = A;
                while(p1.next != p2.next)
                {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                p1.next = null;
                break;
            }
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
        temp.next = head;
        head = solve(head);
    }
}