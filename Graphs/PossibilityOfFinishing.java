/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35001/assignment/problems/377/?navref=cl_pb_nv_tb
There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints
1 <= A <= 6*10^4
1 <= length(B) = length(C) <= 10^5
1 <= B[i], C[i] <= A

Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.

Output Format
Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Example Input
Input 1:
 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:
 A = 2
 B = [1, 2]
 C = [2, 1]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 It is possible to complete the courses in the following order:
    1 -> 2 -> 3
Explanation 2:
 It is not possible to complete all the courses.
*/
import java.util.*;
public class PossibilityOfFinishing {
    public static int solve(int A, int[] B, int[] C) {
        int[] indegree = new int[A+1];
        for(int i = 0;i<C.length;i++)
            indegree[C[i]]++;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i]).add(C[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int curr = queue.peek();
            result.add(curr);
            queue.remove();
            for(int i = 0;i<adj.get(curr).size();i++)
            {
                indegree[adj.get(curr).get(i)]--;
                if(indegree[adj.get(curr).get(i)] == 0)
                    queue.add(adj.get(curr).get(i));
            }
        }
        if(result.size() == A)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        int A = 3;
        int[] B = {1, 2};
        int[] C = {2, 3};
        System.out.println(solve(A,B,C));
    }
}
