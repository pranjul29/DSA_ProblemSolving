/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/homework/problems/228/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/symmetric-tree/
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Problem Constraints
1 <= number of nodes <= 10^5

Example Input
Input 1:
    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:
    1
   / \
  2   2
   \   \
   3    3

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The above binary tree is symmetric. 
Explanation 2:
The above binary tree is not symmetric.
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
public class SymmetricBinaryTree {
    public static int isSymmetric(TreeNode A) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode left_child = A.left;
        TreeNode right_child = A.right;
        while((!left.isEmpty() && !right.isEmpty()) || (left_child!=null && right_child!=null))
        {
            while(left_child!= null && right_child!=null)
            {
                if(left_child.val != right_child.val)
                    return 0;
                left.push(left_child);
                right.push(right_child);
                left_child = left_child.left;
                right_child = right_child.right;
            }
            if(right_child!=null || left_child!=null)
                return 0;
            left_child = left.peek();
            left.pop();
            right_child = right.peek();
            right.pop();
            left_child = left_child.right;
            right_child = right_child.left;
        }
        if((!left.isEmpty() || !right.isEmpty()) || (left_child!=null || right_child!=null))
            return 0;
        return 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(isSymmetric(root));
    }
}
