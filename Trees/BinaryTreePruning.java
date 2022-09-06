/*
Source: https://leetcode.com/problems/binary-tree-pruning/
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
A subtree of a node node is node plus every node that is a descendant of node.

Example 1:
Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation: 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
Example 2:
Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
Example 3:
Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]
 
Constraints:
The number of nodes in the tree is in the range [1, 200].
Node.val is either 0 or 1.
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
public class BinaryTreePruning {
    public static boolean hasOne(TreeNode root)
    {
        if(root == null)
            return false;
        boolean left = hasOne(root.left);
        boolean right = hasOne(root.right);
        if(!left)
            root.left = null;
        if(!right)
            root.right = null;
        if(left || right || root.val == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static TreeNode pruneTree(TreeNode root) {
        boolean ans = hasOne(root);
        if(ans)
            return root;
        else
            return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(0,new TreeNode(0),new TreeNode(0)),new TreeNode(1,new TreeNode(0),new TreeNode(1)));
        root = pruneTree(root);
    }
}
