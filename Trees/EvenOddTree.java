/*
Source: https://leetcode.com/problems/even-odd-tree/
A binary tree is named Even-Odd if it meets the following conditions:
The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

Example 1:
Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
Example 2:
Input: root = [5,4,2,3,3,7]
Output: false
Explanation: The node values on each level are:
Level 0: [5]
Level 1: [4,2]
Level 2: [3,3,7]
Node values in level 2 must be in strictly increasing order, so the tree is not Even-Odd.
Example 3:
Input: root = [5,9,1,3,5,7]
Output: false
Explanation: Node values in the level 1 should be even integers.

Constraints:
The number of nodes in the tree is in the range [1, 10^5].
1 <= Node.val <= 10^6
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
public class EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // Flag to Check if It's an Odd Level or Even Level
        // If Flag is True it's an even level else it's an Odd Level
        boolean flag = true;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int temp_value = -1;
            for(int i = 0;i<size;i++)
            {
                TreeNode temp = queue.peek();
                // If Flag is False i.e. Odd Level and temp.val is odd Return False
                // Or if Flag is True i.e. Even level and temp.val is Even Return False
                if((!flag && temp.val%2 == 1) || (flag && temp.val%2 == 0))
                    return false;
                if(i == 0)
                    temp_value = temp.val;
                else
                {
                    // if Flag is False i.e. Odd Level and temp.val >= previous Value Return false
                    // or if flag is True i.e. Even Level and Temp.val <= previous Value , Return False
                    if((!flag && temp.val >= temp_value) || (flag && temp.val <= temp_value))
                        return false;
                    else
                        temp_value = temp.val;
                }
                queue.remove();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            flag = !flag;
        }    
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(isEvenOddTree(root));
    }
}
