/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/homework/problems/6708/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/k-th-smallest-prime-fraction/
Given a sorted array of integers A which contains 1 and some number of primes.
Then, for every p < q in the list, we consider the fraction p / q.
What is the B-th smallest fraction considered?
Return your answer as an array of integers, where answer[0] = p and answer[1] = q.

Problem Constraints
1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2

Example Input
Input 1:
 A = [1, 2, 3, 5]
 B = 3
Input 2:
 A = [1, 7]
 B = 1

Example Output
Output 1:
 [2, 5]
Output 2:
 [1, 7

Example Explanation
Explanation 1:
 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.
Explanation 2:
 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7.
*/
import java.util.*;
class Fraction{
    int numerator;
    int denominator;
    public Fraction(int x,int y)
    {
        numerator = x;
        denominator = y;
    }
}
public class BthSmallestPrimeFactorisation {
    public static int[] solve(int[] A, int B) {
        PriorityQueue<Fraction> heap = new PriorityQueue<Fraction>((o1, o2) -> o2.numerator*o1.denominator - o1.numerator*o2.denominator);
        for(int i = 0;i<A.length;i++)
        {
            for(int j = A.length-1;j>=i+1;j--)
            {
                Fraction f = new Fraction(A[i],A[j]);
                if(heap.size() < B)
                {
                    heap.add(f);
                }
                else if(heap.size() == B && heap.peek().numerator*f.denominator > f.numerator*heap.peek().denominator)
                {
                    Fraction temp = heap.poll();
                    heap.add(f);
                }
                else
                {
                    break;
                }
            }
        }
        Fraction temp = heap.peek();
        int[] result = {temp.numerator, temp.denominator};
        return result;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,5};
        int B = 3;
        System.out.println(solve(A,B));
    }
}
