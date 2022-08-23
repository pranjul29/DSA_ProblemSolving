/*
Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
 
Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
*/
import java.util.*;
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        boolean even = count%2 == 0 ? true : false;
        count = count/2;
        temp = head;
        Stack<Integer> stack = new Stack<>();
        while(count!=0)
        {
            stack.push(temp.val);
            temp = temp.next;
            count--;
        }
        if(!even)
        {
            temp = temp.next;
        }
        while(!stack.isEmpty())
        {
            Integer a = stack.pop();
            Integer b = temp.val;
            if(a!=b)
                return false;
           // System.out.println(stack);
            //System.out.println(temp.val);
            temp = temp.next;
            
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1;i<arr.length;i++)
        {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        System.out.println(isPalindrome(head));
    }
}
