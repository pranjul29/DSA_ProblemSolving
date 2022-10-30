/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34969/assignment/problems/25/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/triangle/

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is

Problem Constraints
|A| <= 1000
A[i] <= 1000

Example Input
Input 1: 
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:
 A = [ [1] ]

Example Output
Output 1:
 11
Output 2:
 1

Example Explanation
Explanation 1:
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:
 Only 2 can be collected.
*/
import java.util.*;
public class MinSumPathInATriangle {
    // Bottom Up
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> temp = a.get(a.size()-1);
        for(int i = a.size()-2;i>=0;i--)
        {
            for(int j = 0;j<a.get(i).size();j++)
            {
                temp.set(j,Math.min(temp.get(j),temp.get(j+1)) + a.get(i).get(j));
            }
        }
        return temp.get(0);
	}
}
/*
Top Down
public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 1)
            return a.get(0).get(0);
        for(int i = 1;i<a.size();i++)
        {
            ArrayList<Integer> temp = a.get(i);
            for(int j = 0;j<temp.size();j++)
            {
                if(j == 0)
                {
                    temp.set(j,temp.get(j) + a.get(i-1).get(j));
                }
                else if(j == temp.size()-1)
                {
                    temp.set(j,temp.get(j) + a.get(i-1).get(j-1));
                }
                else
                {
                    temp.set(j,Math.min(temp.get(j) + a.get(i-1).get(j-1),temp.get(j) + a.get(i-1).get(j)));
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        ArrayList<Integer> temp = a.get(a.size()-1);
        for(int i = 0;i<temp.size();i++)
        {
            minimum = Math.min(minimum,temp.get(i));
        }
        return minimum;
	}
*/