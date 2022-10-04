/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34925/homework/problems/4465/?navref=cl_pb_nv_tb
Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
In case there is no common node, return 0.

NOTE:
Try to do it one pass through the trees.

Problem Constraints
1 <= Number of nodes in the tree A and B <= 10^5
1 <= Node values <= 10^6

Example Input
Input 1:
 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9
 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Input 2:
  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11
 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11

Example Output
Output 1:
 17
Output 2:
 46

Example Explanation
Explanation 1:
 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:
 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
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
    @Override
    public String toString()
    {
        return Integer.toString(this.val);
    }
}
public class CommonNodesInTwoBST {
    public static int solve(TreeNode A, TreeNode B) {
        Stack<TreeNode> a = new Stack<>();
        Stack<TreeNode> b = new Stack<>();
        TreeNode curr_A = A;
        TreeNode curr_B = B;
        long sum = 0;
        int M = 1000000007;
        int count  = 0;
        while((!a.isEmpty() && !b.isEmpty()) || (curr_A!=null || curr_B!=null))
        {
            System.out.println(a);
            System.out.println(b);
            if(curr_A!=null)
                System.out.println(curr_A.val);
            if(curr_B!=null)
                System.out.println(curr_B.val);
            while(curr_A!=null)
            {
                a.push(curr_A);
                curr_A = curr_A.left;
            }
            while(curr_B!=null)
            {
                b.push(curr_B);
                curr_B = curr_B.left;
            }
            System.out.println(a);
            System.out.println(b);
            curr_A = a.peek();
            a.pop();
            curr_B = b.peek();
            b.pop();
            
            System.out.println(curr_A.val);
            System.out.println(curr_B.val);
            if(curr_A.val == curr_B.val)
            {
                sum = (sum + (long)curr_A.val)%M;
                curr_A = curr_A.right;
                curr_B = curr_B.right;
            }
            else if(curr_A.val < curr_B.val)
            {
                curr_A = curr_A.right;
                b.push(curr_B);
                curr_B = null;
            }
            else
            {
                curr_B = curr_B.right;
                a.push(curr_A);
                curr_A = null;
            }
            count++;
            System.out.println("");
            // if(count == 20)
            //     break;
        }
        return (int)sum;
    }
    public static TreeNode getTree(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(A.get(0) == -1)
            return null;
        TreeNode root = new TreeNode(A.get(0));
        queue.add(root);
        for(int i = 1;i<A.size();i=i+2)
        {
            int left = A.get(i);
            int right = A.get(i+1);
            TreeNode left_child = null;
            TreeNode right_child = null;
            if(left!=-1)
                left_child = new TreeNode(left);
            if(right!=-1)
                right_child = new TreeNode(right);
            TreeNode temp = queue.peek();
            temp.left = left_child;
            temp.right = right_child;
            queue.remove();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return root;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(25,18 ,30 ,14 ,21 ,28 ,33 ,6 ,17 ,20 ,22 ,27 ,29 ,31 ,43 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1 ,-1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(18, 11, 24, 6, 14, 21, 28, 4, 7, 12, 16, 19, 22, 25, 31, -1, 5, -1, 9, -1, 13, 15, 17, -1, 20, -1, 23, -1, 26, 30, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));

        TreeNode A = getTree(a);
        TreeNode B = getTree(b);

        System.out.println(solve(A, B));
    }
}
