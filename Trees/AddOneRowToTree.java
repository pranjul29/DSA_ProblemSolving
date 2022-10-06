/*
Source: https://leetcode.com/problems/add-one-row-to-tree/
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.
The adding rule is:
Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 
Example 1:

Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:

Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 
Constraints:
The number of nodes in the tree is in the range [1, 10^4].
The depth of the tree is in the range [1, 10^4].
-100 <= Node.val <= 100
-105 <= val <= 10^5
1 <= depth <= the depth of tree + 1
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
public class AddOneRowToTree {
    public static void addRowAtDepth(TreeNode root,int val,int depth)
    {
        if(root == null)
            return;
        if(depth == 2)
        {
            TreeNode left_newNode = new TreeNode(val);
            left_newNode.left = root.left;
            TreeNode right_newNode = new TreeNode(val);
            right_newNode.right = root.right;
            root.left = left_newNode;
            root.right = right_newNode;
            return;
        }
        addRowAtDepth(root.left,val,depth-1);
        addRowAtDepth(root.right,val,depth-1);
    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
        {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        addRowAtDepth(root,val,depth);
        return root;
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
        System.out.println(addOneRow(A,1,3));
    }
}
