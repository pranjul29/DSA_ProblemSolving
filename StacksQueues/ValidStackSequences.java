/* 
Source: https://leetcode.com/problems/validate-stack-sequences/description/
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 
Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.
*/
import java.util.*;
public class ValidStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        int counter_push = 1;
        stack.push(pushed[0]);
        while(counter < popped.length)
        {
            if(stack.isEmpty() && counter_push < pushed.length)
            {
                stack.push(pushed[counter_push]);
                counter_push++;
            }
            while(counter_push < pushed.length && popped[counter]!=stack.peek())
            {
                stack.push(pushed[counter_push]);
                counter_push++;
            }
            if(stack.peek() == popped[counter])
            {
                stack.pop();
                counter++;
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
}
