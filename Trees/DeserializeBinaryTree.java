/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34913/assignment/problems/9269/?navref=cl_pb_nv_tb
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 10^5
-1 <= A[i] <= 10^5

Example Input
Input 1:
 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:
 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example Output
Output 1:
           1
         /   \
        2     3
       / \
      4   5
Output 2:
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

Example Explanation
Explanation 1:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:
 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
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
public class DeserializeBinaryTree {
    public static TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(A.get(0) == -1)
            return null;
        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);
        for(int i = 1;i<A.size();i=i+2)
        {
            int left = A.get(i);
            int right = A.get(i+1);
            TreeNode left_child = null;
            TreeNode right_child = null;
            if(left!=-1)
                left_child = new TreeNode(left);
            if(right!=-1)
                right_child = new TreeNode(right);
            TreeNode temp = queue.peek();
            temp.left = left_child;
            temp.right = right_child;
            queue.remove();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return root;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
        System.out.println(solve(A));
    }
}
