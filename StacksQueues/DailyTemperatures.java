/*
Source: https://leetcode.com/problems/daily-temperatures/description/
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 
Constraints:
1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100
 */
import java.util.*;
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] max_right = new int[N];
        max_right[N-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(N-1);
        for(int i = N-2;i>=0;i--)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
                max_right[i] = -1;
            else
                max_right[i] = stack.peek();
            stack.push(i);
        }
        int[] answers = new int[N];
        for(int i = 0;i<N;i++)
        {
            if(max_right[i] == -1)
                answers[i] = 0;
            else
                answers[i] = max_right[i] - i;
        }
        return answers;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
    }
}
