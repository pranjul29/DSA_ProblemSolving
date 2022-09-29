/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/assignment/problems/334/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/invert-binary-tree/
Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.

Problem Constraints
1 <= size of tree <= 100000

Example Input
Input 1:
     1
   /   \
  2     3
Input 2:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Example Output
Output 1:
     1
   /   \
  3     2
Output 2:
     1
   /   \
  3     2
 / \   / \
7   6 5   4

Example Explanation
Explanation 1:
Tree has been inverted.
Explanation 2:
Tree has been inverted.
*/
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
public class InvertBinaryTree {
    public static TreeNode treeInversion(TreeNode root)
    {
        if(root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        treeInversion(root.left);
        treeInversion(root.right);
        return root;
    }
    public static TreeNode invertTree(TreeNode A) {
        return treeInversion(A);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null), new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
       System.out.println(invertTree(root)); 
    }
}
