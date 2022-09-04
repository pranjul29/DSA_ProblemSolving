/*
Given a linked list where every node represents a linked list and contains two pointers of its type:
Pointer to next node in the main list (right pointer)
Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.

Problem Constraints
1 <= Total nodes in the list <= 100000
1 <= Value of node <= 10^9

Example Input
Input 1:
   3 -> 4 -> 20 -> 20 ->30
   |    |    |     |    |
   7    11   22    20   31
   |               |    |
   7               28   39
   |               |
   8               39
Input 2:
   2 -> 4 
   |    |       
   7    11    
   |            
   7

Example Output
Output 1:
 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 
Output 2:
 2 -> 4 -> 7 -> 7 -> 11

Example Explanation
Explanation 1:
 The return linked list is the flatten sorted list.
*/
import java.util.*;

class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
public class FlattenALinkedList {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp1 = A;
        ListNode temp2 = B;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val < temp2.val)
            {
                curr.down = temp1;
                temp1 = temp1.down;
            }
            else
            {
                curr.down = temp2;
                temp2 = temp2.down;
            }
            curr = curr.down;
        }
        while(temp1!=null)
        {
            curr.down = temp1;
            temp1 = temp1.down;
            curr = curr.down;
        }
        while(temp2!=null)
        {
            curr.down = temp2;
            temp2 = temp2.down;
            curr = curr.down;
        }
        ListNode temp = dummy;
            while(temp!=null)
            {
                System.out.print(temp.val + " ");
                temp = temp.down;
            }
            System.out.println();
        return dummy.down;
    }
    public static ListNode findMiddle(ListNode A)
    {
        ListNode slow = A;
        ListNode fast = A;
        while(fast.right!=null && fast.right.right!=null)
        {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }
    public static ListNode flatten(ListNode A) {
        if(A == null || A.right == null)
                return A;
        ListNode mid = findMiddle(A);
        ListNode head2 = mid.right;
        mid.right = null;
        ListNode head1 = A;
        head1 = flatten(head1);
        head2 = flatten(head2);
        return mergeTwoLists(head1,head2);
    }    
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        int[] arr = {7,7,8};
        ListNode temp = root;
        for(int i = 0;i<arr.length;i++)
        {
            ListNode value = new ListNode(arr[i]);
            temp.down = value;
            temp = temp.down;
        }
        ListNode two = new ListNode(4);
        two.down = new ListNode(11);
        root.right = two;

        ListNode three = new ListNode(20);
        three.down = new ListNode(22);
        two.right = three;

        ListNode four = new ListNode(20);
        three.right = four;

        ListNode five = new ListNode(30);
        five.down = new ListNode(31);
        five.down.down = new ListNode(39);
        four.right = five;

        int[] arr1 = {20,28,39};
        temp = four;
        for(int i = 0;i<arr1.length;i++)
        {
            ListNode value = new ListNode(arr1[i]);
            temp.down = value;
            temp = temp.down;
        }
        root = flatten(root);
        temp = root;
            while(temp!=null)
            {
                System.out.print(temp.val + " ");
                temp = temp.down;
            }
            System.out.println();
    }
}
