/* 
Source: https://leetcode.com/problems/jump-game-iii/description/?envType=study-plan&id=graph-i
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Constraints:

1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length
*/
import java.util.*;
public class JumpGameIII {
    static boolean isValid(int x,int n)
    {
        if(x >= n || x < 0)
            return false;
        return true;
    }
    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] visited = new int[arr.length];
        visited[start] = 1;
        boolean ans = false;
        while(!queue.isEmpty())
        {
            int curr = queue.peek();
            queue.remove();
            if(arr[curr] == 0)
            {
                ans = true;
                break;
            }
            int x1 = curr + arr[curr];
            int x2 = curr - arr[curr];
            if(isValid(x1,arr.length) && visited[x1] == 0)
            {
                queue.add(x1);
                visited[x1] = 1;
            }
            if(isValid(x2,arr.length) && visited[x2] == 0)
            {
                queue.add(x2);
                visited[x2] = 1;
            }

        }
        return ans;
    }
}
