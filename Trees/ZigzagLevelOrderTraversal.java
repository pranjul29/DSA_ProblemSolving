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
public class ZigzagLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            ArrayList<Integer> level_result = new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode temp = stack1.peek(); 
                stack1.pop();
                if(temp.left!=null)
                    stack2.push(temp.left);
                if(temp.right!=null)
                    stack2.push(temp.right);
                level_result.add(temp.val);  
            }
            if(level_result.size() != 0)
                result.add(level_result);
            level_result = new ArrayList<>();
            while(!stack2.isEmpty()){
                TreeNode temp = stack2.peek(); 
                stack2.pop();
                if(temp.right!=null)
                    stack1.push(temp.right);
                if(temp.left!=null)
                    stack1.push(temp.left);
                level_result.add(temp.val);  
            }
            if(level_result.size() != 0)
                result.add(level_result);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(zigzagLevelOrder(root));
    }
}
