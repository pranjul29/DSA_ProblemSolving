/* 
Source: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.

Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.

Example 3:
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
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
public class VerticalOrderTraversalOfABinaryTree {
    static ArrayList<ArrayList<Integer>> values = new ArrayList<>();
    public static void fillList(TreeNode root, int row, int column)
    {
        if(root == null)
            return;
        ArrayList<Integer> element_info = new ArrayList<Integer>();
        element_info.add(column);
        element_info.add(root.val);
        element_info.add(row);
        values.add(element_info);
        fillList(root.left,row+1,column-1);
        fillList(root.right,row+1,column+1);
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        fillList(root,0,0);
        //System.out.println(values);
        Collections.sort(values, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0) < o2.get(0))
                {
                    return -1;
                }
                else if(o1.get(0) > o2.get(0))
                {
                    return 1;
                }
                else
                {
                    if(o1.get(2) < o2.get(2))
                    {
                        return -1;
                    }
                    else if(o1.get(2) > o2.get(2))
                    {
                        return 1;
                    }
                    else
                        return o1.get(1).compareTo(o2.get(1));    
                }
            }
        });
        //System.out.println(values);
        List<List<Integer>> result = new ArrayList<>();
        if(values.size() == 0)
            return result;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(values.get(0).get(1));
        //System.out.println(temp);
        for(int i = 1;i<values.size();i++)
        {
            //System.out.println(temp);
            if(values.get(i).get(0) == values.get(i-1).get(0))
            {
                temp.add(values.get(i).get(1));
                if(i == values.size() - 1)
                {
                    result.add(temp);
                    //System.out.println(result);
                }
            }
            else
            {
                List<Integer> temp_result = new ArrayList<Integer>(temp);
                result.add(temp_result);
                //System.out.println(result);
                temp.clear();
                temp.add(values.get(i).get(1));
                if(i == values.size() - 1)
                {
                    result.add(temp);
                  //  System.out.println(result);
                }
            }
            //System.out.println(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(verticalTraversal(root));
    }
}
