/*
Source: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 
Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 10^4]
*/
import java.util.*;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class NaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> level = new LinkedList<>();
        level.add(root);
        int current_count = 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current_level = new ArrayList<>();
        if(root == null)
            return result;
        while(!level.isEmpty())
        {
            while(current_count>0)
            {
                Node tempNode = level.poll();
                current_level.add(tempNode.val);
                current_count--;
                List<Node> child = tempNode.children;
                if(child!=null){
                    for(int i = 0;i<child.size();i++)
                    {
                        level.add(child.get(i));
                    }
                }
            }
            if(current_count == 0)
            {
                List<Integer> temp = new ArrayList<Integer>(current_level);
                result.add(temp);
                current_level.clear();
                current_count = level.size();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Node> child = new ArrayList<Node>();
        Node temp1 = new Node(5);
        Node temp2 = new Node(6);
        child.add(temp1);child.add(temp2);
        Node child1 = new Node(3,child);

        Node child2 = new Node(2);
        Node child3 = new Node(4);

        List<Node> root_child = new ArrayList<>();
        root_child.add(child1);root_child.add(child2);root_child.add(child3);

        Node root = new Node(1,root_child);
        System.out.println(levelOrder(root));
    }
}
