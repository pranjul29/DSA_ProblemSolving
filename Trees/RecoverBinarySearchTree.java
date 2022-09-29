/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/assignment/problems/216/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/recover-binary-search-tree/
Two elements of a binary search tree (BST), represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.
A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Problem Constraints
1 <= size of tree <= 100000

Example Input
Input 1: 
         1
        / \
       2   3
Input 2:
         2
        / \
       3   1

Example Output
Output 1:
 [2, 1]
Output 2:
 [3, 1]

Example Explanation
Explanation 1:
Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:
Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
*/
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
public class RecoverBinarySearchTree {
    static TreeNode prev;
    static TreeNode first;
    static TreeNode second;
    public static void findConflicts(TreeNode root)
    {
        if(root == null)
            return;
        findConflicts(root.left);
        if(prev!=null && prev.val > root.val)
        {
            if(first==null)
            {
                first = prev;
            }
            second = root;
        }
        prev = root;
        findConflicts(root.right);
    }
    public static int[] recoverTree(TreeNode A) {
        findConflicts(A);
        int[] result = {Math.min(first.val,second.val),Math.max(first.val,second.val)};
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(3);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(recoverTree(root));
    }
}
