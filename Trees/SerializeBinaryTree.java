/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34913/homework/problems/9268/?navref=cl_pb_nv_tb
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 10^5

Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Example Output
Output 1:
 [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 2:
 [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example Explanation
Explanation 1:
 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:
 The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
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
}
public class SerializeBinaryTree {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(A == null)
        {
            result.add(-1);
            return result;
        }
        queue.add(A);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.peek();
            queue.remove();
            if(temp == null)
            {
                result.add(-1);
            }
            else
            {
                result.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(solve(root));
    }
}
