/*
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

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
 [1, 3, 7, 8]
Output 2:
 [1, 3, 4, 5]

Example Explanation
Explanation 1:
Right view is described.
Explanation 2:
Right view is described.
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
public class RightViewOfBinaryTree {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 1;i<=size;i++)
            {
                TreeNode temp = queue.peek();
                queue.remove();
                if(temp.left!=null)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
                if(i == size)
                {
                    result.add(temp.val);
                }
            }
        }
        return result;
    }
}
