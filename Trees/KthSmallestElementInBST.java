/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/assignment/problems/335/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Example Input
Input 1:
            2
          /   \
         1    3
B = 2
Input 2:
            3
           /
          2
         /
        1
B = 1

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
2nd element is 2.
Explanation 2:
1st element is 1.
*/
public class KthSmallestElementInBST {
    static int count = 0;
    static int result;
    public static void findElement(TreeNode root,int B)
    {
        if(root == null)
            return;
        findElement(root.left,B);
        count++;
        if(count == B)
        {
            result = root.val;
            return;
        }
        findElement(root.right,B);
    }
    public static int kthsmallest(TreeNode A, int B) {
        result = -1;
        findElement(A,B);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null), new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
       System.out.println(kthsmallest(root,5)); 
    }
}
