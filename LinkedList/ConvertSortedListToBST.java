/* 
Source: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.

Example 1:

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
 
Constraints:

The number of nodes in head is in the range [0, 2 * 10^4].
-10^5 <= Node.val <= 10^5
*/
public class ConvertSortedListToBST {
    public static TreeNode toBST(ListNode head,ListNode tail)
    {
        // System.out.println(head);
        // System.out.println(tail);
        if(head == tail)
            return null;
        // System.out.println(head.val);
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=tail && fast.next.next!=tail)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.val);
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return toBST(head,null);
    }
}
