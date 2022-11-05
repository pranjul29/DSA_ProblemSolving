import java.util.*;
public class WaysToSendSignal {
    static int M = 1000000007;
    static int[] dp;
    public static int findWays(int A)
    {
        if(A <= 0)
            return 0;
        if(A == 1)
            return 1;
        if(dp[A]!=-1)
            return dp[A];
        dp[A] = (findWays(A-1) + findWays(A-2))%M;
        return dp[A];
    }
    public static int solve(int A) {
        dp = new int[A+1];
        Arrays.fill(dp,-1);
        for(int i = 0;i<=A;i++)
        {
            dp[i] = -1;
        }
        return findWays(A);
    }
    public static void main(String[] args) {
        int A = 26;
        
        System.out.println(solve(A));
        for(int i = 0;i<=A;i++)
        {
            System.out.print(dp[i]+ " ");
        }
        System.out.println();
    }
}
