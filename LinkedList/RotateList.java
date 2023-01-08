/*
Source: https://leetcode.com/problems/rotate-list/description/
Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 
Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k <= 0 || head.next == null)
            return head;
        ListNode temp = head;
        int count = 0;
        while(temp!=null)
        {
            temp = temp.next;
            count++;
        }
        k = k%count;
        for(int i = 0;i<k;i++)
        {

            ListNode curr = head;
            while(curr.next.next!=null)
                curr = curr.next;
            curr.next.next = head;
            head = curr.next;
            curr.next = null;
        }
        return head;
    }
}
