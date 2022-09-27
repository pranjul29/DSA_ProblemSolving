/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/assignment/problems/218/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 10^9

Example Input
Input 1: 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:
      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 LCA is 1.
Explanation 2:
 LCA is 2.
*/
import java.util.*;
public class LCA_BinaryTree {
    static ArrayList<Integer> path_a;
    static ArrayList<Integer> path_b;
    public static boolean findPath(TreeNode root,int A,int flag)
    {
        if(root == null)
            return false;
        if(root.val == A )
        {
            if(flag == 0)
                path_a.add(root.val);
            else
                path_b.add(root.val);
            return true;
        }
        boolean left = findPath(root.left,A,flag);
        boolean right = findPath(root.right,A,flag);
        if(left || right)
        {
            if(flag == 0)
                path_a.add(root.val);
            else
                path_b.add(root.val);
            return true;
        }
        else
            return false;
    }
    public static int lca(TreeNode A, int B, int C) {
        path_a = new ArrayList<>();
        path_b = new ArrayList<>();
        boolean isA = findPath(A,B,0);
        boolean isB = findPath(A,C,1);
        int len_B = path_b.size()-1;
        int len_A = path_a.size()-1;
        if(len_A == -1 || len_B == -1)
            return -1;
        int ans = path_a.get(len_A);
        while(len_A >= 0 && len_B >= 0)
        {
            if((int)path_a.get(len_A) == (int)path_b.get(len_B))
                ans = path_a.get(len_A);
            else
                break;
            len_A--;
            len_B--;
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(lca(root, p.val, q.val));
    }
}
