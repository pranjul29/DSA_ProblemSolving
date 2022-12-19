class Pair{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
    public String toString()
    {
        return new String("(" + first + " " + second + ")");
    }
    public Pair clone()
    {
        return new Pair(this.first,this.second);
    }
}
public class FlipArray {
    static Pair[][] dp;
    static int p;
    static int q;
    public static Pair maxFlip(int sum,int N,int[] A)
    {
        
        if(sum == 0 || N == 0)
            return new Pair(0,0);
        if(dp[sum][N].first != -1)
            return dp[sum][N];
        if(sum >= A[N-1])
        {
            Pair include = maxFlip(sum-A[N-1],N-1,A).clone();
            Pair exclude = maxFlip(sum,N-1,A).clone();

            // Pair include = new Pair(include1.first,include1.second);
            // Pair exclude = new Pair(exclude1.first,exclude1.second);

            // Because we Include N-1th Element in the Ans so Adding it's value in first nd cound in second
            include.first += A[N-1];
            include.second += 1;

            if(include.first > exclude.first)
            {
                dp[sum][N] = include;
            }
            else if(include.first < exclude.first)
            {
                dp[sum][N] = exclude;
            }
            else
            {
                dp[sum][N] = new Pair(include.first,Math.min(include.second,exclude.second));
            }
        }
        else
        {
            dp[sum][N] = maxFlip(sum,N-1,A);
        }
        System.out.println("Sum: " + sum + " N: " + N);
        for(int i = 0;i<= p;i++)
        {
            for(int j = 0;j<=q;j++)
                System.out.print(dp[i][j] + " ");
            System.out.println("");
        }
        System.out.println("");
        return dp[sum][N];
    }
    public static int solve(final int[] A) {
        int sum = 0;
        int N = A.length;
        for(int i = 0;i<A.length;i++)
            sum += A[i];
        sum = sum/2;
        System.out.println("SUM: " + sum);
        dp = new Pair[sum+1][N+1];
        p = sum;
        q = N;
        for(int i = 0;i<= sum;i++)
            for(int j = 0;j<=N;j++)
                dp[i][j] = new Pair(-1,-1);
        Pair ans = maxFlip(sum,N,A);
        for(int i = 0;i<= sum;i++)
        {
            for(int j = 0;j<=N;j++)
                System.out.print(dp[i][j] + " ");
            System.out.println("");
        }
        return ans.second;
    }
    public static void main(String[] args) {
        int[] A = {8, 4, 5, 7, 6, 2};
        System.out.println(solve(A));
    }
}
