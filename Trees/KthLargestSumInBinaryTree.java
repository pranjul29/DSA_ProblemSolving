/* 
Source: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/
You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.

Example 1:

Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
Explanation: The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2nd largest level sum is 13.
Example 2:

Input: root = [1,2,null,3], k = 1
Output: 3
Explanation: The largest level sum is 3.
 
Constraints:

The number of nodes in the tree is n.
2 <= n <= 10^5
1 <= Node.val <= 10^6
1 <= k <= n
*/
import java.util.*;
public class KthLargestSumInBinaryTree {
    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Queue<TreeNode> level_order = new LinkedList<>();
        level_order.add(root);
        while(!level_order.isEmpty())
        {
            // System.out.println(level_order);
            // System.out.println(queue);
            int size = level_order.size();
            long sum = 0;
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = level_order.peek();
                level_order.remove();
                sum += (long)curr.val;
                if(curr.left!=null)
                    level_order.add(curr.left);
                if(curr.right!=null)
                    level_order.add(curr.right);
            }
            queue.add(sum);
            if(queue.size() > k)
            {
                queue.poll();
            }
        }
        if(queue.size() < k)
            return -1;
        return queue.peek();
    }
}
