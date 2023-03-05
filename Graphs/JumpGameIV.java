/* 
Source: https://leetcode.com/problems/jump-game-iv/description/
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
Constraints:

1 <= arr.length <= 5 * 10^4
-108 <= arr[i] <= 10^8
*/
import java.util.*;
public class JumpGameIV {
    public static int minJumps(int[] arr) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                ArrayList<Integer> curr = map.get(arr[i]);
                curr.add(i);
            }
            else
            {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(i);
                map.put(arr[i],curr);
            }
        }
        int[] visited = new int[n];
        visited[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int steps = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                int curr = queue.peek();
                if(curr == n-1)
                    return steps;
                queue.remove();
                if(curr!=0 && visited[curr-1] == 0)
                {
                    queue.add(curr-1);
                    visited[curr-1] = 1;
                }
                if(curr!=n-1 && visited[curr+1] == 0)
                {
                    queue.add(curr+1);
                    visited[curr+1] = 1;
                }
                if(map.containsKey(arr[curr]))
                {
                    ArrayList<Integer> possible = map.get(arr[curr]);
                    for(int j = 0;j<possible.size();j++)
                    {
                        if(visited[possible.get(j)] == 0)
                        {
                            queue.add(possible.get(j));
                            visited[possible.get(j)] = 1;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return steps;
    }
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }
}
