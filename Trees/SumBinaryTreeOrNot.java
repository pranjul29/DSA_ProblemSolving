/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/homework/problems/4401/?navref=cl_pb_nv_tb
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
Return 1 if it sum-binary tree else return 0.

Problem Constraints
1 <= length of the array <= 100000
0 <= node values <= 50

Example Input
Input 1:
       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:
       26
     /    \
    10     3
   /  \     \
  4   6      4

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 All leaf nodes are considered as SumTree. 
 Value of Node 10 = 4 + 6.
 Value of Node 3 = 0 + 3 
 Value of Node 26 = 20 + 6 
Explanation 2:
 Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
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
public class SumBinaryTreeOrNot {
    public static int isSumBinaryTree(TreeNode root)
    {
        if(root == null)
            return 1;
        if(root.left == null && root.right == null)
            return 1;
        if(isSumBinaryTree(root.left) == 1 && isSumBinaryTree(root.right) == 1)
        {
            int ls = 0;
            int rs = 0;
            if(root.left == null)
            {
                ls = 0;
            }
            else if(root.left.left == null && root.left.right == null) // Checking if root.left is Leaf Node
            {
                ls = root.left.val;
            }
            else
            {
                ls = root.left.val*2;
            }
            if(root.right == null)
            {
                rs = 0;
            }
            else if(root.right.left == null && root.right.right == null) // Checking if root.right is Leaf Node
            {
                rs = root.right.val;
            }
            else
            {
                rs = root.right.val*2;
            }
            if(ls + rs == root.val)
                return 1;
            else
                return 0;
        }
        return 0;
    }
    public static int solve(TreeNode A) {
        return isSumBinaryTree(A);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(26,new TreeNode(10, new TreeNode(4), new TreeNode(6)), new TreeNode(3, null, new TreeNode(3)));
        System.out.println(solve(root));
    }
}
