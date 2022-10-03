/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34933/assignment/problems/234/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/path-sum/
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Problem Constraints
1 <= number of nodes <= 10^5
-100000 <= B, value of nodes <= 100000

Example Input
Input 1:
 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
 B = 22
Input 2:
 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4
 B = -1

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:
 There is no path which has sum -1.
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
public class PathSum {
    public static boolean isPathSumPossible(TreeNode root, int B)
    {
        if(root == null)
            return false;
        B = B - root.val;
        if(B == 0 && root.left==null && root.right==null)
            return true;
        else
        {
            return isPathSumPossible(root.left,B) || isPathSumPossible(root.right,B);
        }
    }
    public static int hasPathSum(TreeNode A, int B) {
        if(isPathSumPossible(A,B))
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(hasPathSum(root,10));
    }
}
