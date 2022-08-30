/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29522/assignment/problems/43/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/linked-list-cycle-ii/
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.

Example:
Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class ListCycle {
    public static ListNode detectCycle(ListNode a) {
        if(a == null)
            return null;
        ListNode slow = a;
        ListNode fast = a;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            // Cycle Exists
            if(slow == fast)
            {
                ListNode p1 = slow;
                ListNode p2 = a;
                while(p1!=p2)
                {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
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
        System.out.println(detectCycle(head));
    }
}