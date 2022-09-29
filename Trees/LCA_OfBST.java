/*
Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example1: 
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example2: 
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
1) The number of nodes in the tree is in the range [2, 10^5].
2) -10^9 <= Node.val <= 10^9
3) All Node.val are unique.
4) p != q
5) p and q will exist in the BST.
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
public class LCA_OfBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minimum = Math.min(p.val,q.val);
        int maximum = Math.max(p.val,q.val);
        TreeNode curr = root;
        while(curr!=null)
        {
            if((curr.val > minimum && curr.val < maximum) || curr == p || curr == q)
                return curr;
            if(curr.val > maximum)
            {
                curr = curr.left;
            }
            if(curr.val < minimum)
            {
                curr = curr.right;
            }
        }
        return null;
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
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
