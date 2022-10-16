/* 
Source; https://www.scaler.com/academy/mentee-dashboard/class/34953/assignment/problems/9291/?navref=cl_pb_nv_tb
There are N jobs to be done, but you can do only one job at a time.
Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
Return the maximum number of jobs you can finish.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] < B[i] <= 10^9

Example Input
Input 1:
 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:
 A = [3, 2, 6]
 B = [9, 8, 9]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:
 Since all three jobs collide with each other. We can do only 1 job.
*/
import java.util.*;
class Jobs{
    int start;
    int end;
    public Jobs(int start,int end)
    {
        this.start = start;
        this.end = end;
    }
}
public class FinishMaximumJobs {
    public static int solve(int[] A, int[] B) {
        ArrayList<Jobs> jobs = new ArrayList<>();
        for(int i = 0;i<A.length;i++)
        {
            jobs.add(new Jobs(A[i],B[i]));
        }
        Collections.sort(jobs,(j1,j2) ->{
            return j1.end - j2.end;
        });
        int last_time = 0;
        int count = 0;
        for(int i = 0;i<jobs.size();i++)
        {
            if(last_time <= jobs.get(i).start)
            {
                count++;
                last_time = jobs.get(i).end;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {};
        int[] B = {};
        System.out.println(solve(A, B));
    }
}
