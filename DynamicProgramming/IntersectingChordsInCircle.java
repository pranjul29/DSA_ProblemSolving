/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/homework/problems/339/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords int
Two ways are different if there exists a chord which is present in one way and not in other.
Return the answer modulo 109 + 7.

Problem Constraints
1 <= A <= 10^3

Input Format
The first and the only argument contains the integer A.

Output Format
Return an integer answering the query as described in the problem statement.

Example Input
Input 1:
 A = 1
Input 2:
 A = 2
Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are: {(1-2)} only. So, we return 1.
Explanation 2:
 If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
 So, we return 2.
 */
import java.util.*;
public class IntersectingChordsInCircle {
    static int[] diff;
    static int mod = 1000000007;
    public static int numOfChord(int i,int j)
    {
        
        if((j-i) <= 1)
        {
            System.out.println(i + " " + j + " Ans: 1");
            return 1;
        }
        if(diff[j-i] != -1)
        {
            System.out.println(i + " " + j + " Ans: " + diff[j-i]);
            return diff[j-i];
        }
        int ans = 0;
        for(int k = i+1;k<=j;k=k+2)
        {
            int ans1 = numOfChord(i+1,k-1);
            int ans2 = numOfChord(k+1,j);
            System.out.println(ans1 + " " + ans2);
            ans = ans + ans1*ans2;
            System.out.println(i + " " + j + " Ans: " + ans);
            ans = ans % mod;
        }
        ans = ans%mod;
        diff[j-i] = ans;
        System.out.println(i + " " + j + " Ans: " + ans);
        return ans;
    }
    public static int chordCnt(int A) {
        diff = new int[2*A];
        Arrays.fill(diff,-1);
        diff[0] = 1;
        diff[1] = 1;
        int ans = (int)numOfChord(1,2*A);
        for(int i = 0;i<diff.length;i++)
            System.out.print(diff[i] + " ");
        System.out.println();
        return ans;
    }
    public static void main(String[] args) {
        int A = 3;
        System.out.println(chordCnt(A));
    }
}
