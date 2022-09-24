/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:
Input: root = [1,2], targetSum = 0
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
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
public class PathSumII {
    static List<List<Integer>> result;
    public static void findPath(TreeNode root,int targetSum,List<Integer> path)
    {
        if(root == null)
            return;
        targetSum -= root.val;
        path.add(root.val);
        if(targetSum == 0 && root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        // path.add(root.val);
        if(root.left != null)
        {
            findPath(root.left,targetSum,path);
            path.remove(path.size()-1);
        }
        if(root.right != null)
        {
            findPath(root.right,targetSum,path);
            path.remove(path.size()-1);
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPath(root,targetSum,path);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null), new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
       System.out.println(pathSum(root, 22)); 
    }
}
