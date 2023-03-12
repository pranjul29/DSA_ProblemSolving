/* 
Source: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 
Constraints:

The number of nodes in the tree is in the range [0, 10^5].
-1000 <= Node.val <= 1000
*/
public class MinimumDepthOfBinaryTree {
    public static int findHeight(TreeNode root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(left == 0 || right == 0)
            return Math.max(left,right) + 1;
        return Math.min(left,right) + 1;
    }
    public static int minDepth(TreeNode root) {
        return findHeight(root);
    }
}
