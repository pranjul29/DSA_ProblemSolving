/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34921/homework/problems/4258/?navref=cl_pb_nv_tb
Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.

Problem Constraints
1 <= number of nodes <= 100000

Example Input
Input 1:
 A : [4, 10, 5, 8]
Input 2:
 A : [1, 5, 6, 4]

Example Output
Output 1:
 "YES"
Output 2:
 "NO"

Example Explanation
Explanation 1:
 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:
 There is no possible BST which have the above preorder traversal.
*/
import java.util.*;
public class CheckForBSTWithOneChild {
    public static String solve(int[] A) {
        int[] inorder = A.clone();
        Arrays.sort(inorder);
        HashMap<Integer,Integer> in = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)
            in.put(inorder[i],i);
        int ie = A.length-1;
        int is = 0;
        for(int i = 0;i<inorder.length;i++)
        {
            int root_index = in.get(A[i]);
            int lst_length = root_index-is;
            int rst_length = ie-root_index;
            if(rst_length != 0 && lst_length != 0)
                return new String("NO");
            if(rst_length == 0)
            {
                ie = root_index-1;
            }
            if(lst_length == 0)
            {
                is = root_index+1;
            }
        }
        return new String("YES");
    }
    public static void main(String[] args) {
        int[] preorder = {4, 10, 5, 8};
        System.out.println(solve(preorder));
    }
}
