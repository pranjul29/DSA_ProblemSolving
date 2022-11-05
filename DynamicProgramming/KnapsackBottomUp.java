import java.util.*;
public class KnapsackBottomUp {
    public static int solve(int[] A, int[] B, int C) {
        int[] dp = new int[C+1];
        Arrays.fill(dp,0);
        for(int i = 1;i<=A.length;i++)
        {
            for(int j = C;j>=0;j--)
            {
                if(j >= B[i-1])
                {
                    dp[j] = Math.max(dp[j],dp[j-B[i-1]] + A[i-1]);
                }
            }
            for(int j = 0;j<=C;j++)
                System.out.print(dp[j] + " ");
            System.out.println();
        }
        return dp[C];
    }
    public static void main(String[] args) {
        int[] A = {6, 10, 12};
        int[] B = {10, 20, 30};
        int C = 50;
        System.out.println(solve(A,B,C));
    }
}
