/*
Source: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Example 1:
Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:
Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:
Input: root = [9]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 9
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
public class PseudoPalindromicPathInBST {
    static int count=0;
    public static boolean checkPalindromicPaths(int[] arr)
    {
            int count_odd = 0;
            for(int k = 1;k<10;k++)
            {
                if(arr[k]%2 == 1)
                    count_odd++;
            }
            if(count_odd <= 1)
                return true;
            else
                return false;
    }
    public static void traverseTillRoot(TreeNode root,int[] temp)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            temp[root.val]++;
            if(checkPalindromicPaths(temp))
                count++;
            temp[root.val]--;
            return;
        }
        temp[root.val]++;
        traverseTillRoot(root.left,temp);
        traverseTillRoot(root.right,temp);
        temp[root.val]--;
    }
    public static int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        traverseTillRoot(root,arr);
        return count;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(3,new TreeNode(3),new TreeNode(1)),new TreeNode(3,new TreeNode(1),null));
        System.out.println(pseudoPalindromicPaths(root));
    }
}
