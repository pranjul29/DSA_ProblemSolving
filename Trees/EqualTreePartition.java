/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34929/assignment/problems/4859/?navref=cl_pb_nv_tb
Source: https://leetcode.ca/all/663.html
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.

Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 10^9

Example Input
Input 1: 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:
                1
               / \
              2   10
                  / \
                 20  2

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:
 The given Tree cannot be partitioned.
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
public class EqualTreePartition {
    static int totalSum = 0;
    static int flag = 0;
    public static void findTotalSum(TreeNode root)
    {
        if(root == null)
            return;
        totalSum+= root.val;
        findTotalSum(root.left);
        findTotalSum(root.right);
    }
    public static int sumOfTree(TreeNode root)
    {
        if(root == null)
            return 0;
        int sumLST = sumOfTree(root.left);
        int sumRST = sumOfTree(root.right);
        if(sumLST*2 == totalSum || sumRST*2 == totalSum)
            flag = 1;
        return root.val + sumLST + sumRST;
    }
    public static int solve(TreeNode A) {
        findTotalSum(A);
        int sum = sumOfTree(A);
        return flag;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(solve(root));
    }
}
