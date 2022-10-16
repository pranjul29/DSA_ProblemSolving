/* 
Source: https://leetcode.com/problems/sudoku-solver/
Source: https://www.scaler.com/academy/mentee-dashboard/class/34961/assignment/problems/143/?navref=cl_pb_nv_tb
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
A sudoku puzzle,
and its solution numbers marked in red.

Problem Constraints
N = 9

Example Input
Input 1:
A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

Example Output
Output 1:
[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

Example Explanation
Explanation 1:
Look at the diagrams given in the question.
*/
import java.util.*;

public class Sudoku{
    static int flag = 0;
    static boolean checkPossibility(int row,int col,char a,char[][] A)
    {
        // Check in Row
        for(int i = 0;i<9;i++)
        {
            if(A[row][i] == a)
                return false;
        }
        // Check in Column
        for(int i = 0;i<9;i++)
        {
            if(A[i][col] == a)
                return false;
        }
        // Check in 3*3 Matrix
        // (r,c) : Cell Number for first Element in 3*3 Matrix
        int r = row - row%3;
        int c = col - col%3;
        for(int i = r;i<=r+2;i++)
        {
            for(int j = c;j<=c+2;j++)
            {
                if(A[i][j] == a)
                    return false;
            }
        }
        return true;
    }
    static boolean sudoku(char[][] A,int index)
    {
        // Sudoku is Solved
        if(index == 81)
            return true;
        int row = index/9;
        int col = index%9;

        
        if(A[row][col] == '.')
        {
            for(char i = '1';i<='9';i++)
            {
                if(checkPossibility(row,col,i,A))
                {
                    A[row][col] = i;
                    boolean check = sudoku(A,index+1);
                    if(check)
                        return true;
                    else
                        A[row][col] = '.';
                }
            }
            return false;
        }
        else
            return sudoku(A, index+1);
    }
	public static void solveSudoku(char[][] A) {
        sudoku(A,0);
        // return A;
	}
    public static void main(String[] args) {
        char[][] A = {{'5', '3', '.', '.', '7', '.','.', '.', '.'}, {'6', '.', '.', '1', '9', '5','.', '.', '.'}, {'.', '9', '8', '.', '.', '.','.', '6', '.'}, {'8', '.', '.', '.', '6', '.','.', '.', '3'}, {'4', '.', '.', '8', '.', '3','.', '.', '1'}, {'7', '.', '.', '.', '2', '.','.', '.', '6'}, {'.', '6', '.', '.', '.', '.','2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.','.', '7', '9'}};
        solveSudoku(A);
        for(int i = 0;i<9;i++)
            {
                for(int j = 0;j<9;j++)
                {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println("");
            }
        System.out.println("");
    }
}
