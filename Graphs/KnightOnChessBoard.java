/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35005/homework/problems/292/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/knight-on-chess-board/
Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.

The above figure details the movements for a knight ( 8 possibilities ).
If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
NOTE: A knight cannot go out of the board.

Problem Constraints
1 <= A, B <= 500

Input Format
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.

Output Format
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.

Example Input
Input 1:
 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:
 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4

Example Output
Output 1:
 6
Output 2:
 -1

Example Explanation
Explanation 1:
 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:
 It is not possible to move knight to position (4, 4) from (2, 1)
*/
class Pair{
    int x;
    int y;
    public Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class KnightOnChessBoard {
    static boolean isValid(int x,int y,int A,int B)
    {
        if(x <= 0 || y <= 0 || x>A || y > B)
            return false;
        return true;
    }
    public static int knight(int A, int B, int C, int D, int E, int F) {
        int[] x_n = {-2,-2,-1,-1,1,1,2,2};
        int[] y_n = {-1,1,-2,2,-2,2,-1,1};
        Queue<Pair> queue = new LinkedList<>();
        // C--;
        // D--;
        // E--;
        // F--;
        if(!isValid(E,F,A,B))
            return -1;
        queue.add(new Pair(C,D));
        int[][] board = new int[A+1][B+1];
        for(int i = 0;i<=A;i++)
            for(int j = 0;j<=B;j++)
                board[i][j] = -1;
        board[C][D] = 0;
        while(!queue.isEmpty())
        {
            Pair curr = queue.peek();
            queue.remove();
            for(int i = 0;i<8;i++)
            {
                int x = x_n[i] + curr.x;
                int y = y_n[i] + curr.y;
                if(isValid(x,y,A,B) && board[x][y]==-1)
                {
                    board[x][y] = board[curr.x][curr.y] + 1;
                    queue.add(new Pair(x,y));
                }
            }
        }
        return board[E][F];

    }
}
