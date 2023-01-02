/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34909/homework/problems/4354/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/maximum-frequency-stack/description/
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:
1 x: push an integer x onto the stack and return -1.
2 0: remove and return the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.

Problem Constraints
1 <= N <= 100000
1 <= A[i][0] <= 2
0 <= A[i][1] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the array of integers denoting the answer to each operation.

Example Input
Input 1:
A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:
 A =  [   
        [1, 5]
        [2, 0]
        [1, 4]   ]

Example Output
Output 1:
 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:
 [-1, 5, -1]

Example Explanation
Explanation 1:
 Just simulate given operations.
Explanation 2:
 Just simulate given operations.
*/
import java.util.*;
public class MaximumFrequencyStack {
    public static int[] solve(int[][] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Stack<Integer>> stack_at_freq = new HashMap<>();
        int maxFreq=0;
        int[] results = new int[A.length];
        for(int i = 0;i<A.length;i++)
        {
            if(A[i][0] == 1)
            {
                int val = A[i][1];
                results[i] = -1;
                int freq_val = freq.getOrDefault(val,0) + 1;
                freq.put(val,freq_val);
                if(freq_val > maxFreq)
                    maxFreq = freq_val;
                if(stack_at_freq.containsKey(freq_val))
                {
                    stack_at_freq.get(freq_val).push(val);
                }
                else
                {
                    stack_at_freq.put(freq_val,new Stack<>());
                    stack_at_freq.get(freq_val).push(val);
                }
            }
            if(A[i][0] == 2)
            {
                int element = stack_at_freq.get(maxFreq).pop();
                freq.put(element,freq.get(element)-1);
                if(stack_at_freq.get(maxFreq).size() == 0)
                    maxFreq--;
                results[i] = element;
            }
        }
        return results;
    }
    public static void main(String[] args) {
        int[][] A = {{1, 5},{1, 7},{1, 5},{1, 7},{1, 4},{1, 5},{2, 0},{2, 0},{2, 0},{2, 0}};
        System.out.println(solve(A));
    }
}
