/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/assignment/problems/226/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= length of array <= 100000

Example Input
Input 1:
 A : [1, 2, 3]
Input 2:
 A : [1, 2, 3, 5, 10]

Example Output
Output 1:
      2
    /   \
   1     3
Output 2:
      3
    /   \
   2     5
  /       \
 1         10

Example Explanation
Explanation 1:
 You need to return the root node of the Binary Tree.
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
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(final int[] A,int start,int end) {
        if(start>end)
            return null;
        int length = (end-start+1);
        int middle = start + (length-1)/2;
        TreeNode root = new TreeNode(A[middle]);
        root.left = sortedArrayToBST(A,start,middle-1);
        root.right = sortedArrayToBST(A,middle+1,end);
        return root;
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        int length = A.length;
        int middle = (length-1)/2;
        TreeNode root = new TreeNode(A[middle]);
        root.left = sortedArrayToBST(A,0,middle-1);
        root.right = sortedArrayToBST(A,middle+1,length-1);
        return root;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        TreeNode root = sortedArrayToBST(A);
        System.out.println(root);
    }

}
