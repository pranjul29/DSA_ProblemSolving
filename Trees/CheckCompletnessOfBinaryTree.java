/* 
Source: https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example 1:

Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:

Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 
Constraints:

The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000
*/
import java.util.*;
public class CheckCompletnessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean noChild = false;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = queue.peek();
                queue.remove();
                if(noChild)
                {
                    if(curr.left != null || curr.right!= null)
                        return false;
                }
                else
                {
                    if(curr.left == null && curr.right!=null)
                        return false;
                    if((curr.left != null && curr.right == null) || (curr.left == null && curr.right == null))
                        noChild = true;
                }
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
        }
        return true;
    }
}
