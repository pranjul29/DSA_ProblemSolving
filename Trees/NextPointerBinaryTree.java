/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/assignment/problems/235/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
Given a binary tree,
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Assume perfect binary tree and try to solve this in constant extra space.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Example Input
Input 1:
     1
    /  \
   2    3
Input 2:
        1
       /  \
      2    5
     / \  / \
    3  4  6  7

Example Output
Output 1:
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Output 2:
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

Example Explanation
Explanation 1:
Next pointers are set as given in the output.
Explanation 2:
Next pointers are set as given in the output.
*/
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class NextPointerBinaryTree {
    public static void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        TreeLinkNode temp;

        // Since it's Perfect Binary Tree, If Curr.left is Null all the Nodes of Curr level are Leaf Nodes
        while(curr!=null && curr.left!=null)
        {
            temp = curr;
            // Pointing Left Child next to Right Child for Curr
            while(temp!=null)
            {
                temp.left.next = temp.right;
                // If Temp is not the Last Node on the Current Level
                if(temp.next!=null)
                {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            curr = curr.left;
        }
    }
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        connect(root);
    }
}
