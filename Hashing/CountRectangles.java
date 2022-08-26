/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29514/assignment/problems/4759/?navref=cl_pb_nv_tb

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 10^9

Example Input
Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 2:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 All four given points make a rectangle. So, the answer is 1.
Explanation 2:
 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)
*/
import java.util.*;
class Pair implements Comparable<Pair>{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + this.first + " , " + this.second + ")";
    }

    public int compareTo(Pair p)
    {
        if (first > p.first) {
            return 1;
        }
        else if (first < p.first) {
            return -1;
        }
        else {
            if(second>p.second)
                return 1;
            else if(second < p.second)
                return -1;
            else
                return 0;
        }
    }
}
public class CountRectangles {
    public static int solve(int[] A, int[] B) {
        TreeSet<Pair> coords = new TreeSet<>();
        for(int i = 0;i<A.length;i++)
        {
            coords.add(new Pair(A[i],B[i]));
        }
        System.out.println(coords);
        int count = 0;
        for(int i = 0;i<A.length;i++)
        {
            for(int j = 0;j<A.length;j++)
            {
                if(A[i] == A[j] || B[i] == B[j])
                    continue;
                else
                {
                    System.out.println("X1: "+A[i]+" Y1: "+B[i]);
                    System.out.println("X2: "+A[j]+" Y2: "+B[j]);
                    Pair first = new Pair(A[i],B[j]);
                    Pair second = new Pair(A[j],B[i]);
                    System.out.println(first);
                    System.out.println(second);
                    System.out.println(coords.contains(first));
                    System.out.println(coords.contains(second));
                    if(coords.contains(first) && coords.contains(second))
                        count++;
                }
            }
        }
        return count/4;
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};
        System.out.println(solve(A, B));
    }
}
