/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34905/assignment/problems/9014/?navref=cl_pb_nv_tb
A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.
Determine the minimum number of clock cycles to complete all the tasks.

Problem Constraints
1 <= N <= 1000
1 <= A[i], B[i] <= N

Example Input
Input 1:
A = [2, 3, 1, 5, 4]
B = [1, 3, 5, 4, 2]
Input 2:
A = [1]
B = [1]

Example Output
Output 1:
 10
Output 2:
 1

Example Explanation
Explanation 1:
According to the order array B task 1 has to be performed first, so the CPU will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
Total clock cycles till now = 2
Now CPU will perform task 1.
Total clock cycles till now = 3
Now, queue becomes [5, 4, 2, 3]
Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back one-by-one.
Total clock cycles till now = 6
Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
Total clock cycles = 10
Explanation 2:
Directly task 1 is completed.
*/
import java.util.*;
public class TaskScheduling {
    public static int solve(int[] A, int[] B) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<A.length;i++)
            queue.add(A[i]);
        int count = 0;
        for(int i = 0;i<B.length;i++)
        {
            while(queue.peek()!=B[i])
            {
                count++;
                queue.add(queue.remove());
            }
            queue.remove();
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {2,3,1,5,4};
        int[] B = {1,3,5,4,2};
        System.out.println(solve(A,B));
    }
}
