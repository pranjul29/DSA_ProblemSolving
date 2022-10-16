/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34961/assignment/problems/141/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/n-queens/
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

Problem Constraints
1 <= A <= 10

Example Input
Input 1:
A = 4
Input 2:
A = 1

Example Output
Output 1:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:
[
 [Q]
]

Example Explanation
Explanation 1:
There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:
There exist only one distinct solutions to the 1-queens puzzle:

See Expected Output
Your input
4
Output
[..Q. Q... ...Q .Q.. ] [.Q.. ...Q Q... ..Q. ]
*/
import java.util.*;
public class NQueens {
    static ArrayList<ArrayList<String>> result;
    // HashSet Storing Row Numbers Where a Queen is Already Placed
    static HashSet<Integer> HSR = new HashSet<>();
    // HashSet Storing i+j values of all the column numbers to Verify the lower left Diagonal Attack
    static HashSet<Integer> HSLL = new HashSet<>();
    // HashSet Storing i-j values of all the column numbers to Verify the upper left Diagonal Attack
    static HashSet<Integer> HSUL = new HashSet<>();
    static void nQueens(int n,int col,ArrayList<String> current)
    {
        System.out.println(result);
        if(n == col)
        {
            result.add((ArrayList)current.clone());
            return;
        }
        char[] current_col = new char[n];
        for(int i = 0;i<n;i++)
            current_col[i] = '.';
        for(int i = 0;i<n;i++)
        {
            if(HSR.contains(i))
                continue;
            if(HSLL.contains(i+col))
                continue;
            if(HSUL.contains(i-col))
                continue;
            // Insertion at Current i,col (row,col) is Possible as there is no Attack So we will place the queen here
            current_col[i] = 'Q';
            HSR.add(i);
            HSLL.add(i+col);
            HSUL.add(i-col);
            // System.out.println(String.valueOf(current_col));
            current.add(String.valueOf(current_col));
            nQueens(n,col+1,current);
            // Removing Values from the HashSet and ArrayList so in next step we can place at other value
            HSR.remove(i);
            HSLL.remove(i+col);
            HSUL.remove(i-col);
            current_col[i] = '.';
            current.remove(current.size()-1);
        }
    }
	public static ArrayList<ArrayList<String>> solveNQueens(int A) {
        result = new ArrayList<>();
        ArrayList<String> current = new ArrayList<>();
        nQueens(A,0,current);
        return result;
	}
    public static void main(String[] args) {
        int A = 4;
        System.out.println(solveNQueens(A));
    }
}
