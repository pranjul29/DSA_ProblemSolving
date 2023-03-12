/* 
Source: https://leetcode.com/problems/pascals-triangle/description/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 
Constraints:

1 <= numRows <= 30
*/
import java.util.*;
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        result.add(row1);
        for(int i = 1;i<numRows;i++)
        {
            List<Integer> curr_row = new ArrayList<Integer>();
            curr_row.add(1);
            List<Integer> prev_row = result.get(i-1);
            int length = prev_row.size()+1;
            for(int j = 1;j<length-1;j++)
            {
                int val = prev_row.get(j-1) + prev_row.get(j);
                curr_row.add(val);
            }
            curr_row.add(1);
            result.add(curr_row);
            // System.out.println(curr_row);
        }
        return result;
    }
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
