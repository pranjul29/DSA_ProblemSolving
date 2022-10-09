/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/assignment/problems/4857/?navref=cl_pb_nv_tb
You are given a Binary Tree A with N nodes.
Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
If the complete Binary Tree is BST, then return the size of the whole tree.
NOTE:
The largest subtree is the subtree with the most number of nodes.

Problem Constraints
1 <= N <= 10^5

Example Input
Input 1:
     10
    / \
   5  15
  / \   \ 
 1   8   7
Input 2:
     5
    / \
   3   8
  / \ / \
 1  4 7  9

Example Output
Output 1:
 3
Output 2:
 7

Example Explanation
Explanation 1:
 Largest BST subtree is
                            5
                           / \
                          1   8
Explanation 2:
 Given binary tree itself is BST.
*/
import java.util.*;
class IsBstDetails{
    boolean isBST = false;
    int min_val;
    int max_val;
    int size;
}
public class LargestBSTSubtree {
    static int answer;
    public static IsBstDetails findAns(TreeNode root)
    {
        if(root == null)
        {
            IsBstDetails result = new IsBstDetails();
            result.isBST = true;
            result.min_val = Integer.MAX_VALUE;
            result.max_val = Integer.MIN_VALUE;
            result.size = 0;
            return result;
        }

        IsBstDetails left = findAns(root.left);
        IsBstDetails right = findAns(root.right);
        
        if(left.isBST && right.isBST && (root.val < right.min_val && root.val > left.max_val))
        {
            IsBstDetails result = new IsBstDetails();
            result.isBST = true;
            result.min_val = Math.min(left.min_val,root.val);
            result.max_val = Math.max(right.max_val,root.val);
            result.size = 1 + left.size + right.size;
            answer = Math.max(answer,result.size);
            return result;
        }
        else
        {
            IsBstDetails result = new IsBstDetails();
            result.isBST = false;
            result.min_val = Math.min(left.min_val,root.val);
            result.max_val = Math.max(right.max_val,root.val);
            result.size = 1 + left.size + right.size;
            return result;
        }
    }
    public static int solve(TreeNode A) {
        answer = 0;
        IsBstDetails result = findAns(A);
        return answer;
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
        TreeNode A = getTree(a);
        System.out.println(solve(A));
    }
}
