/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29520/assignment/problems/45/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/reverse-linked-list-ii/
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass.

Problem Constraints
1 <= |A| <= 10^6
1 <= B <= C <= |A|

Example Input
Input 1:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4
Input 2:
 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5

Example Output
Output 1:
 1 -> 4 -> 3 -> 2 -> 5
Output 2:
 5 -> 4 -> 3 -> 2 -> 1

Example Explanation
Explanation 1:
 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:
 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class ReverseLinkedListII {
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
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if(B == C)
            return A;
        ListNode temp = A;
        ListNode prev_A = null;
        ListNode a = null;
        ListNode b = null;
        ListNode next_B = null;
        int count = 0;
        while(temp!=null)
        {
            count++;
            if(count == (B-1))
            {
                prev_A = temp;
            }
            if(count == B)
            {
                a = temp;
            }
            if(count == C)
            {
                b = temp;
                next_B = b.next;
                break;
            }
            temp = temp.next;
        }
        if(prev_A!=null)
            prev_A.next = null;
        b.next = null;
        reverse(a);
        if(prev_A !=null)
            prev_A.next = b;
        else
            A = b;
        a.next = next_B;
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
        head = reverseBetween(head,2,4);
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
