/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/homework/problems/39/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
NOTE: If B is greater than the size of the list, remove the first node of the list.
NOTE: Try doing it using constant additional space.

Problem Constraints
1 <= |A| <= 10^6

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 2
Input 2:
A = [1]
B = 1

Example Output
Output 1:
[1, 2, 3, 5]
Output 2:
 [] 

Example Explanation
Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int length = 0;
        ListNode temp = A;
        while(temp.next!=null)
        {
            length++;
            temp = temp.next;
        }
        length++;
        int position = length - B + 1;
        if(position <= 1)
        {
            A = A.next;
        }
        else
        {
            temp = A;
            for(int i = 1;i<position-1;i++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
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
        head = removeNthFromEnd(head,3);
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
