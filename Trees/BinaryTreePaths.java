/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:
Input: root = [1]
Output: ["1"]
 
Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
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
public class BinaryTreePaths {
    static List<String> result;
    public static void traverseTillRoot(TreeNode root,ArrayList<Integer> temp)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            temp.add(root.val);
            StringBuilder str = new StringBuilder("");
            for(int i = 0;i<temp.size()-1;i++)
            {
                str.append(temp.get(i));
                str.append("->");
            }
            str.append(temp.get(temp.size()-1));
            result.add(str.toString());
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        traverseTillRoot(root.left,temp);
        traverseTillRoot(root.right,temp);
        temp.remove(temp.size()-1);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<String>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        traverseTillRoot(root,temp);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(3,new TreeNode(3),new TreeNode(1)),new TreeNode(3,new TreeNode(1),null));
        System.out.println(binaryTreePaths(root));
    }
}
