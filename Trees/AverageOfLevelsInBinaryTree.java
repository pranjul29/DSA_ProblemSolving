/*
Source: https://leetcode.com/problems/average-of-levels-in-binary-tree/
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 
Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1
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
public class AverageOfLevelsInBinaryTree {
    static HashMap<Integer,ArrayList<Double>> level_sum = new HashMap<>();
    public static void levelSum(TreeNode root,int level)
    {
        if(root == null)
            return;
        if(level_sum.containsKey(level))
        {
            ArrayList<Double> temp = level_sum.get(level);
            temp.set(0,temp.get(0)+root.val);
            temp.set(1,temp.get(1)+1);
            level_sum.put(level,temp);
        }
        else
        {
            ArrayList<Double> temp = new ArrayList<>();
            Double val = Double.valueOf(root.val);
            temp.add(val);
            val = Double.valueOf(1);
            temp.add(val);
            level_sum.put(level,temp);
        }
        levelSum(root.left,level+1);
        levelSum(root.right,level+1);
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        levelSum(root,0);
        Double[] result_array = new Double[level_sum.size()];
        List<Double> result = new ArrayList<>(Arrays.asList(result_array));
        for(Map.Entry<Integer,ArrayList<Double>> mapElement : level_sum.entrySet())
        {
            int level = mapElement.getKey();
            double Average = mapElement.getValue().get(0);
            Average = Average/mapElement.getValue().get(1);
            result.set(level,Average);
            //System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(averageOfLevels(root));
    }
}
