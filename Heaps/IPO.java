/* 
Source: https://leetcode.com/problems/ipo/description/
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Example 2:

Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6
 
Constraints:

1 <= k <= 10^5
0 <= w <= 10^9
n == profits.length
n == capital.length
1 <= n <= 105
0 <= profits[i] <= 10^4
0 <= capital[i] <= 10^9
*/
import java.util.*;
public class IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<ArrayList<Integer>> projects = new ArrayList<>();
        int n = profits.length;
        for(int i = 0;i<profits.length;i++)
        {
            ArrayList<Integer> project = new ArrayList<Integer>();
            project.add(capital[i]);
            project.add(profits[i]);
            projects.add(project);
        }

        Collections.sort(projects,(a,b) -> {
            if(a.get(0)==b.get(0))
                return b.get(1)-a.get(1);
            return a.get(0)-b.get(0);
        });
        // System.out.println(projects);
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((a,b) -> {
            if(a.get(1) == b.get(1))
                return a.get(0)-b.get(0);
            return b.get(1)-a.get(1);
        });
        int counter = 0;
        while(counter < n)
        {
            ArrayList<Integer> project = projects.get(counter);
            if(project.get(0) <= w)
            {
                queue.add(project);
                counter++;
            }
            else
                break;
        }
        while(k > 0 && !queue.isEmpty())
        {
            // System.out.println(queue);
            ArrayList<Integer> curr_project = queue.peek();
            queue.poll();
            w = w + curr_project.get(1);
            // System.out.println(w + " " + k);
            k--;
            
            while(counter < n)
            {
                ArrayList<Integer> project = projects.get(counter);
                if(project.get(0) <= w)
                {
                    queue.add(project);
                    counter++;
                }
                else
                    break;
            }
        }
        return w;
    }
    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        System.out.println(findMaximizedCapital(k,w,profits,capital));
    }
}
