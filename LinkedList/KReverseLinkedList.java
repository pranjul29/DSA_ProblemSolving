/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/assignment/problems/380/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/reverse-nodes-in-k-group/
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

Problem Constraints
1 <= |A| <= 10^3
B always divides A

Example Input
Input 1:
 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:
 A = [1, 2, 3, 4, 5, 6]
 B = 3

Example Output
Output 1:
 [2, 1, 4, 3, 6, 5]
Output 2:
 [3, 2, 1, 6, 5, 4]

Example Explanation
Explanation 1:
 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:
 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class KReverseLinkedList {
    
        public static void reverse(ListNode A)
        {
            ListNode prev = null;
            ListNode curr = A;
            while(curr!=null)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            //return prev;
        }
        public static void print(ListNode A)
        {
            ListNode temp = A;
            while(temp!=null)
            {
                System.out.print(temp.val+ " ");
                temp = temp.next;
            }
            System.out.println();
        }
        public static ListNode reverseList(ListNode A, int B) {
            ListNode temp = A;
        int count = 1;
        ListNode prev_A = null;
        ListNode a = null;
        ListNode b = null;
        ListNode next_B = null;
        ListNode dummy = new ListNode(-1);
        ListNode connect = dummy;
        while(temp!=null)
        {
            int start = count;
            int end = count+B-1;
            ListNode temp_prev = temp;
            b = null;
            while(temp!=null)
            {
                count++;
                if((count-1) == (start-1))
                {
                    prev_A = temp;
                }
                if((count-1) == start)
                {
                    a = temp;
                }
                if((count-1) == end)
                {
                    b = temp;
                    next_B = b.next;
                    temp_prev = temp;
                    temp = temp.next;
                    break;
                }
                temp_prev = temp;
                temp = temp.next;
            }
            if( b == null)
            {
                break;
            }
            if(prev_A!=null)
                prev_A.next = null;
            b.next = null;
            reverse(a);
            if(prev_A !=null)
            {
                connect.next = b;
                prev_A.next = b;
            }
            else
            {
                A = b;
                connect.next = A;
            }
            a.next = next_B;
            connect = a;
            print(dummy);
        }
        return dummy.next;
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
            head = reverseList(head,2);
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
