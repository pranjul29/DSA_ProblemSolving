/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/homework/problems/6562/?navref=cl_pb_nv_tb
Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 10^9

Output Format
Return an integer denoting the distance between two nodes with given two keys B and C

Example Input
Input 1:    
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:
 Path between 2 and 6 is: 2 -> 6. Distance will be 1
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
public class DistanceBetweenTwoNodesInBST {
    public static int findNodeDistance(TreeNode root,int K)
    {
        if(root.val == K)
            return 0;
        else if(root.val < K)
        {
            return 1 + findNodeDistance(root.right,K);
        }
        else
        {
            return 1 + findNodeDistance(root.left,K);
        }
    }
    public static int solve(TreeNode A, int B, int C) {
        int minimum = Math.min(B,C);
        int maximum = Math.max(B,C);
        TreeNode curr = A;
        if(B == C)
            return 0;
        while(true)
        {
            if(curr.val == minimum)
            {
                return 1 + findNodeDistance(curr.right,maximum);
            }
            else if(curr.val == maximum)
            {
                return 1 + findNodeDistance(curr.left,minimum);
            }
            else if(curr.val < minimum)
            {
                curr = curr.right;
            }
            else if(curr.val > maximum)
            {
                curr = curr.left;
            }
            else
            {
                break;
            }
        }
        return 2 + findNodeDistance(curr.left,minimum) + findNodeDistance(curr.right,maximum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null), new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
        System.out.println(solve(root,11,13));
    }
}
