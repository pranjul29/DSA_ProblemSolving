/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/24896/homework/problems/158
Source: https://leetcode.com/problems/valid-sudoku/

Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

The input corresponding to the above configuration :
["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/
import java.util.*;
public class ValidSudoku {
    public static boolean isValidSudokuGridWise(String[] A)
    {
        for(int k =0;k<3;k++)
        {
            HashSet<Character> hs1 = new HashSet<>();
            HashSet<Character> hs2 = new HashSet<>();
            HashSet<Character> hs3 = new HashSet<>();
            for(int i = 0 + 3*k;i<3 + 3*k;i++)
            {
                
                for(int j = 0;j<3;j++)
                {
                    char ch = A[j].charAt(i);
                    if(ch=='.')
                        continue;
                    else if(hs1.contains(ch))
                        return false;
                    else
                        hs1.add(ch);
                }
                for(int j = 3;j<6;j++)
                {
                    char ch = A[j].charAt(i);
                    if(ch=='.')
                        continue;
                    else if(hs2.contains(ch))
                        return false;
                    else
                        hs2.add(ch);
                }
                for(int j = 6;j<9;j++)
                {
                    char ch = A[j].charAt(i);
                    if(ch=='.')
                        continue;
                    else if(hs3.contains(ch))
                        return false;
                    else
                        hs3.add(ch);
                }
            }
        }
        return true;
    }
    public static boolean isValidSudokuColumnWise(String[] A)
    {
        for(int i = 0;i<9;i++)
        {
            HashSet<Character> hs = new HashSet<>();
            for(int j = 0;j<9;j++)
            {
                char ch = A[j].charAt(i);
                if(ch=='.')
                    continue;
                else if(hs.contains(ch))
                    return false;
                else
                    hs.add(ch);
            }
        }
        return true;
    }
    public static boolean isValidSudokuRowWise(String[] A)
    {
        for(int i = 0;i<A.length;i++)
        {
            HashSet<Character> hs = new HashSet<>();
            for(int j = 0;j<A[i].length();j++)
            {
                char ch = A[i].charAt(j);
                if(ch=='.')
                    continue;
                else if(hs.contains(ch))
                    return false;
                else
                    hs.add(ch);
            }
        }
        
        return true;
    }
    public static int isValidSudoku(final String[] A) {
        if(isValidSudokuColumnWise(A) && isValidSudokuRowWise(A) && isValidSudokuGridWise(A))
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        String[] A = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        System.out.println(isValidSudoku(A));
    }
}
