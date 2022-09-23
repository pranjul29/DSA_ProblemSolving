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
public class RangeSumOfBST {
    static int sum = 0;
    public static void countNodesInRange(TreeNode root,int B,int C)
    {
        if(root == null)
            return;
        if(root.val <= C && root.val >=B)
        {
            sum = sum + root.val;
            countNodesInRange(root.left,B,C);
            countNodesInRange(root.right,B,C);
        }
        else if(root.val < B)
        {
            countNodesInRange(root.right,B,C);
        }
        else if(root.val > C)
        {
            countNodesInRange(root.left,B,C);
        }
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        countNodesInRange(root,low,high);
        return sum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(14,new TreeNode(1),new TreeNode(20));
        System.out.println(rangeSumBST(root,0,19));
    }
}
