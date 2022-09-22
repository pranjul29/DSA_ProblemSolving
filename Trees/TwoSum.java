/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/homework/problems/336/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
Return 1 to denote that two such nodes exist. Return 0, otherwise.

Problem Constraints
1 <= size of tree <= 100000
1 <= B <= 10^9

Example Input
Input 1:
         10
         / \
        9   20

B = 19
Input 2:
          10
         / \
        9   20
B = 40
Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 10 + 9 = 19. Hence 1 is returned.
Explanation 2:
 No such pair exists.
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
public class TwoSum {
    static HashSet<Integer> set;
    public static boolean findValue(TreeNode root, int k,HashSet<Integer> set)
    {
        if(root == null)
            return false;
        int valueRequired = k-root.val;
        if(set.contains(valueRequired))
            return true;
        set.add(root.val);
        return findValue(root.left,k,set) || findValue(root.right,k,set);
    }
    public static boolean t2Sum(TreeNode root, int k) {
        set = new HashSet<Integer>();
        if(findValue(root,k,set))
            return true;
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(14,new TreeNode(1),new TreeNode(20));
        System.out.println(t2Sum(root,21));
    }
}
