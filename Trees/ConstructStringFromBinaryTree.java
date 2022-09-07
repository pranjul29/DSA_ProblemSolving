/*
Source: https://leetcode.com/problems/construct-string-from-binary-tree/
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
Example 2:
Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 
Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-1000 <= Node.val <= 1000
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
public class ConstructStringFromBinaryTree {
    static StringBuilder result;
    public static void treeTraversal(TreeNode root)
    {
        if(root == null)
            return;
        result.append("(");
        result.append(root.val);
        if(root.left == null && root.right!=null)
        {
            result.append("()");
        }
        treeTraversal(root.left);
        treeTraversal(root.right);
        result.append(")");
    }
    public static String tree2str(TreeNode root) {
        result = new StringBuilder();
        if(root == null)
            return result.toString();
        result.append(root.val);
        if(root.left == null && root.right!=null)
        {
            result.append("()");
        }
        treeTraversal(root.left);
        treeTraversal(root.right);
        return result.toString();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(4)),new TreeNode(3));
        System.out.println(tree2str(root));
    }
}
