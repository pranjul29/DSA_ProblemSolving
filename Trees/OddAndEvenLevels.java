/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34917/homework/problems/4677/?navref=cl_pb_nv_tb
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
NOTE: Consider the level of root node as 1.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Example Input
Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8 
Input 2:
        1
       / \
      2   10
       \
        4

Example Output
Output 1:
 10
Output 2:
 -7

Example Explanation
Explanation 1:
 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
Explanation 2:
 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12
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
public class OddAndEvenLevels {
    public static int solve(TreeNode A) {
        long sum_odd = 0;
        long sum_even = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean flag = true;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(flag)
            {
                for(int i = 0;i<size;i++)
                {
                    TreeNode temp = queue.peek();
                    sum_odd += (long)temp.val;
                    queue.remove();
                    if(temp.left!=null)
                        queue.add(temp.left);
                    if(temp.right!=null)
                        queue.add(temp.right);
                }
            }
            else
            {
                for(int i = 0;i<size;i++)
                {
                    TreeNode temp = queue.peek();
                    sum_even += (long)temp.val;
                    queue.remove();
                    if(temp.left!=null)
                        queue.add(temp.left);
                    if(temp.right!=null)
                        queue.add(temp.right);
                }
            }
            flag = !flag;
        }
        return (int)(sum_odd-sum_even);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(solve(root));
    }
}
