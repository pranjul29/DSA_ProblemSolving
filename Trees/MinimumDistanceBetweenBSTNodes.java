/* 
Source: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
Source: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

Example 1:

Input: root = [4,2,6,1,3]
Output: 1
Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1
 
Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 10^5
*/
import java.time.*;
public class MinimumDistanceBetweenBSTNodes {
    static ArrayList<Integer> inorder;
    public static void traverse(TreeNode root)
    {
        if(root == null)
            return;
        traverse(root.left);
        inorder.add(root.val);
        traverse(root.right);
    }
    public static int minDiffInBST(TreeNode root) {
        inorder = new ArrayList<>();
        traverse(root);
        int minimum = Integer.MAX_VALUE;
        for(int i = 1;i<inorder.size();i++)
            minimum = Math.min(minimum,inorder.get(i)-inorder.get(i-1));
        return minimum;
    }
}
