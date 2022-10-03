/*
Source: https://leetcode.com/problems/binary-tree-maximum-path-sum/
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 
Constraints:
The number of nodes in the tree is in the range [1, 3 * 10^4].
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
public class BinaryTreeMaximumPathSum {
    static int ans = Integer.MIN_VALUE;
    public static int PathSum(TreeNode root)
    {
        // If Root is Null Return 0
        if(root == null)
            return 0;
        
        // Check what is the MaxPathSum in LST
        int left = PathSum(root.left);
        // Check what is the MaxPathSum in RST
        int right = PathSum(root.right);
        
        // Curr_sum is if left>0 or else 0, Right>0 or else 0 and then including curr value
        int curr_sum = root.val + Math.max(left,0) + Math.max(right,0);
        // Checking from Global Max if curr_sum is greater then ans
        ans = Math.max(ans,curr_sum);
        
        // returning root.val with max of Left or right if both < 0 then 0
        return root.val + Math.max(Math.max(left,right),0);
    }
    public static int maxPathSum(TreeNode root) {
        int maxSum = PathSum(root);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(26,new TreeNode(10, new TreeNode(4), new TreeNode(6)), new TreeNode(3, null, new TreeNode(3)));
        System.out.println(PathSum(root));
    }
}
