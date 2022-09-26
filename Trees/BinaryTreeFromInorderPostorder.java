/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34913/assignment/problems/224/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 10^5

Example Input
Input 1:
 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:
 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]

Example Output
Output 1:
   1
  / \
 2   3
Output 2:
   1  
  / \
 6   2
    /
   3

Example Explanation
Explanation 1:
 Create the binary tree and return the root node of the tree.
*/
public class BinaryTreeFromInorderPostorder {
    static HashMap<Integer,Integer> map;
    public static TreeNode constructTree(int[] preorder,int ps ,int pe ,int is ,int ie)
    {
        if(ps > pe)
            return null;
        int root_val = preorder[pe];
        TreeNode root = new TreeNode(root_val);

        int inorder_root_index = map.get(root_val);
        int lst_length = inorder_root_index - is;
        root.left = constructTree(preorder,ps,ps+lst_length-1,is,inorder_root_index-1);
        root.right = constructTree(preorder,ps+lst_length,pe-1,inorder_root_index+1,ie);
        return root;
    }
    public static TreeNode buildTree(int[] A, int[] B) {
        map = new HashMap<>();
        for(int i = 0;i<A.length;i++)
        {
            map.put(A[i],i);
        }
        return constructTree(B,0,A.length-1,0,B.length-1);
    }
    public static void main(String[] args) {
        int[] inorder = {2, 1, 3};
        int[] postorder = {2,3,1};
        TreeNode root = buildTree(inorder, postorder); 
    }
}
