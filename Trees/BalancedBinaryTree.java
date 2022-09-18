/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34917/assignment/problems/225/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/balanced-binary-tree/submissions/
Given a root of binary tree A, determine if it is height-balanced.
A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Problem Constraints
1 <= size of tree <= 100000

Example Input
Input 1:
    1
   / \
  2   3
Input 2:
       1
      /
     2
    /
   3

Example Output
Output 1:
1
Output 2:
0
Example Explanation
Explanation 1:
It is a complete binary tree.
Explanation 2:
Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
Difference = 2 > 1. 
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
public class BalancedBinaryTree {
    static HashMap<TreeNode,Integer> map;
    public static int fillHeights(TreeNode root)
    {
        if(root == null)
            return 0;
        int l = fillHeights(root.left);
        int r = fillHeights(root.right);
        int height = 1 + Math.max(l,r);
        map.put(root,height);
        return height;
    }
    public static boolean checkBalanceOfTree(TreeNode root)
    {
        int l = 0;
        int r = 0;
        if(root == null)
            return true;
        if(root.left!=null)
            l = map.get(root.left);
        if(root.right!=null)
            r = map.get(root.right);
        if(Math.abs(l-r)>1)
            return false;
        else
            return checkBalanceOfTree(root.left) && checkBalanceOfTree(root.right);
    }
    public static int isBalanced(TreeNode A) {
        map = new HashMap<>();
        int height = fillHeights(A);
        System.out.println(map);
        boolean result = checkBalanceOfTree(A);
        if(result)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2));
        System.out.println(isBalanced(root));
    }
}
