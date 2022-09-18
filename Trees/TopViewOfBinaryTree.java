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
class Pair
{
    TreeNode node;
    int column;
    public Pair(TreeNode node,int column)
    {
        this.node = node;
        this.column = column;
    }
}
public class TopViewOfBinaryTree {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        queue.add(new Pair(A,0));
        int max_level = Integer.MIN_VALUE;
        int min_level = Integer.MAX_VALUE;
        while(!queue.isEmpty())
        {
            Pair temp = queue.peek();
            queue.remove();
            TreeNode temp_node = temp.node;
            int temp_column = temp.column;
            if(!map.containsKey(temp_column))
            {
                map.put(temp_column,temp_node.val);
            }
            //map.put(temp_column,temp_level_list);
            if(temp_node.left!=null)
            {
                queue.add(new Pair(temp_node.left,temp_column-1));
            }
            if(temp_node.right!=null)
            {
                queue.add(new Pair(temp_node.right,temp_column+1));
            }
            max_level = Math.max(temp_column,max_level);
            min_level = Math.min(temp_column,min_level);
        }
        for(int i = min_level;i<=max_level;i++)
        {
            result.add(map.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(solve(root));
    }
}

