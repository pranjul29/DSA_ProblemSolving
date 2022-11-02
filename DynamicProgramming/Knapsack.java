import java.util.*;
class Pair
{
    int index;
    int capacity;
    public Pair(int index,int capacity)
    {
        this.index = index;
        this.capacity = capacity;
    }
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(index);
        str.append(" ");
        str.append(capacity);
        return str.toString();
    }
}
public class Knapsack {
    static int[][] dp;
    public static int knapsack(int[] A,int[] B,int C,int i)
    {
        if(C == 0 || i == 0)
            return 0;
        if(dp[i][C]!=-1)
            return dp[i][C];
        
        int profit = knapsack(A,B,C,i-1);
        if(C-B[i-1] >= 0)
            profit = Math.max(profit,knapsack(A,B,C-B[i-1],i-1)+A[i-1]);
        
        dp[i][C] = profit;
        return dp[i][C];
    }
    public static int solve(int[] A, int[] B, int C) {
        dp = new int[A.length+1][C+1];
        for(int i = 0;i<=A.length;i++)
            for(int j = 0;j<=C;j++)
                dp[i][j] = -1;
        int ans = knapsack(A,B,C,A.length);
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {468, 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392, 605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812, 323};
        int[] B = {4, 4, 5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5, 9, 7, 6, 1, 10, 1, 1, 7, 2, 4, 9, 10, 4, 5, 5, 7};
        int C = 841;
        System.out.println(solve(A,B,C));
    }
}
