/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34917/homework/problems/4675/?navref=cl_pb_nv_tb
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
NOTE: The value comes first in the array which have lower level.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Example Input
Input 1:

            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5

Example Output
Output 1:
 [1, 2, 4, 8]
Output 2:
 [1, 2, 4, 5]

Example Explanation
Explanation 1:
 The Left view of the binary tree is returned.
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
public class LeftViewOfBinaryTree {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            result.add(queue.peek().val);
            for(int i = 0;i<size;i++)
            {
                TreeNode temp = queue.peek();
                queue.remove();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
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
