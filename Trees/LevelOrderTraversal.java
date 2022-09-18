/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34913/assignment/problems/206/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/binary-tree-level-order-traversal/
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Problem Constraints
1 <= number of nodes <= 10^5

Example Input
Input 1:
    3
   / \
  9  20
    /  \
   15   7
Input 2:
   1
  / \
 6   2
    /
   3

Example Output
Output 1:
 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:
 [ 
   [1]
   [6, 2]
   [3]
 ]

Example Explanation
Explanation 1:
 Return the 2D array. Each row denotes the traversal of each level.
*/
import java.util.*;;
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
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode A) {
        List<List<Integer>> result = new ArrayList<>();
        if(A == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level_result = new ArrayList<>();
            for(int i = 0;i<size;i++)
            {
                TreeNode temp = queue.peek();
                level_result.add(temp.val);
                queue.remove();
                if(temp.left!=null)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
            }
            result.add(level_result);
        }
        return result;
    }
    go
}
