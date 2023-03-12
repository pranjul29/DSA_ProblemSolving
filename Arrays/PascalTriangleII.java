/* 
Source: https://leetcode.com/problems/pascals-triangle-ii/description/
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 
Constraints:

0 <= rowIndex <= 33
 
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
*/
import java.util.*;
public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        
        for(int i = 1;i<=rowIndex;i++)
        {
            prev = new ArrayList<Integer>(curr);
            curr = new ArrayList<Integer>();
            curr.add(1);
            int length = prev.size()+1;
            for(int j = 1;j<length-1;j++)
            {
                int val = prev.get(j-1) + prev.get(j);
                curr.add(val);
            }
            curr.add(1);
            // System.out.println(curr_row);
        }
        return curr;
    }
    public static void main(String[] args) {
        int rowIndex = 4;
        System.out.println(getRow(rowIndex));
    }
}
