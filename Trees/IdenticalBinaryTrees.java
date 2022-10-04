/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/homework/problems/231/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/same-tree/
Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Problem Constraints
1 <= number of nodes <= 10^5

Example Input
Input 1:
   1       1
  / \     / \
 2   3   2   3
Input 2:
   1       1
  / \     / \
 2   3   3   3

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Both trees are structurally identical and the nodes have the same value.
Explanation 2:
 Values of the left child of the root node of the trees are different.
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
    @Override
    public String toString()
    {
        return Integer.toString(this.val);
    }
}
public class IdenticalBinaryTrees {
    public static boolean isIdentical(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
            return true;
        else if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        else
        {
            boolean left = isIdentical(root1.left,root2.left);
            boolean right = isIdentical(root1.right,root2.right);
            if(left && right)
                return true;
            return false;
        }
    }
    public static int isSameTree(TreeNode A, TreeNode B) {
        if(isIdentical(A,B))
            return 1;
        return 0;
    }
    public static TreeNode getTree(ArrayList<Integer> A) {
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
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(25,18 ,30 ,14 ,21 ,28 ,33 ,6 ,17 ,20 ,22 ,27 ,29 ,31 ,43 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(18, 11, 24, 6, 14, 21, 28, 4, 7, 12, 16, 19, 22, 25, 31, -1, 5, -1, 9, -1, 13, 15, 17, -1, 20, -1, 23, -1, 26, 30, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));

        TreeNode A = getTree(a);
        TreeNode B = getTree(b);

        System.out.println(isSameTree(A,B));
    }
}
