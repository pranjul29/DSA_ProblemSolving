/*
Source: https://leetcode.com/problems/binary-tree-inorder-traversal/
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:
Input: root = []
Output: []
Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class InorderTraversal {
    static List<Integer> inorder;
    public static void traversal(TreeNode root)
    {
        if(root == null)
            return;
        traversal(root.left);
        inorder.add(root.val);
        traversal(root.right);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        inorder = new ArrayList<Integer>();
        traversal(root);
        return inorder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(4)),new TreeNode(3));
        System.out.println(inorderTraversal(root));
    }
}
