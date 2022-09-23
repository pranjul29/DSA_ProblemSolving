/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/homework/problems/4679/?navref=cl_pb_nv_tb
Given a binary search tree of integers. You are given a range B and C.
Return the count of the number of nodes that lie in the given range.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 10^9

Example Input
Input 1:
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8
     B = 12
     C = 20
Input 2:
            8
           / \
          6  21
         / \
        1   7
     B = 2
     C = 20

Example Output
Output 1:
 5
Output 2:
 3

Example Explanation
Explanation 1:
 Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2:
 Nodes which are in range [2, 20] are : [8, 6, 7]
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
public class BSTNodesInRange {
    static int count = 0;
    public static void countNodesInRange(TreeNode root,int B,int C)
    {
        if(root == null)
            return;
        if(root.val <= C && root.val >=B)
        {
            count++;
            countNodesInRange(root.left,B,C);
            countNodesInRange(root.right,B,C);
        }
        else if(root.val < B)
        {
            countNodesInRange(root.right,B,C);
        }
        else if(root.val > C)
        {
            countNodesInRange(root.left,B,C);
        }
    }
    public static int solve(TreeNode A, int B, int C) {
        countNodesInRange(A,B,C);
        return count;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(14,new TreeNode(1),new TreeNode(20));
        System.out.println(solve(root,0,19));
    }
}
