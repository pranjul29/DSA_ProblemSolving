/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/assignment/problems/221/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/validate-binary-search-tree/
You are given a binary tree represented by root A.
Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 10^5
0 <= node values <= 2^32-1

Example Input
Input 1:
   1
  /  \
 2    3
Input 2:
  2
 / \
1   3

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 2 is not less than 1 but is in left subtree of 1.
Explanation 2:
Satisfies all conditions.
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
public class ValidBinarySearchTree {
    public static boolean isValidBST(TreeNode root,long low,long high)
    {
        if(root == null)
            return true;
        System.out.println(root.val);
        System.out.println(high);
        System.out.println(low);    
        if(((long)root.val <= high || root.val == Integer.MAX_VALUE) && (long)root.val >= low)
        {
            System.out.println("HERE");
            return isValidBST(root.left,low,root.val-1) && isValidBST(root.right,root.val+1,high);
        }
        else
            return false;
    }
    public static int isValidBST(TreeNode A) {
        long max = (long)Integer.MAX_VALUE;
        long min = (long)Integer.MIN_VALUE;
        if(isValidBST(A,min,max))
            return 1;
        return 0;
    }

    public static TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(A.get(0) == -1)
            return null;
        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);
        for(int i = 1;i<A.size();i=i+2)
        {
            int left = A.get(i);
            int right = A.get(i+1);
            TreeNode left_child = null;
            TreeNode right_child = null;
            if(left!=-1)
                left_child = new TreeNode(left);
            if(right!=-1)
                right_child = new TreeNode(right);
            TreeNode temp = queue.peek();
            temp.left = left_child;
            temp.right = right_child;
            queue.remove();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return root;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(40, 35, 41, 34, 37, -1, 46, 31, -1, 36, 38, 45, 47, 29, 32, -1, -1, -1, 39, 43, -1, -1, -1, 28, 30, -1, 33, -1, -1, 42, 44, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, 26, -1, -1, -1, 27, -1, -1));
        TreeNode root = solve(arr);
        System.out.println(isValidBST(root));
    }
}
