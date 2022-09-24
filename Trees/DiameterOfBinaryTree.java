/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/assignment/problems/9256/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/diameter-of-binary-tree/
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

Problem Constraints
0 <= N <= 10^5

Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6
Example Output
Output 1:
 3
Output 2:
 4
Example Explanation
Explanation 1:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
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
public class DiameterOfBinaryTree {
    static int maxDiameter;
    public static int findHeight(TreeNode root)
    {
        if(root == null)
            return -1;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        maxDiameter = Math.max(maxDiameter,2+leftHeight+rightHeight);
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }
    public static int solve(TreeNode A) {
        maxDiameter = Integer.MIN_VALUE;
        int height = findHeight(A);
        return maxDiameter;
    }
}
