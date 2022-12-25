public class VerticalAndHorizontalSums {
    static boolean isPossible = false;
    static int[][] visited;
    static int count = 0;
    static boolean checkSum(int[][] B,int C,int N,int M)
    {
        for(int i = 0;i<N;i++)
        {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for(int j = 0;j<M;j++)
            {
                sum += B[i][j];
                if(ans < sum)
                    ans = sum;
                if(sum < 0)
                    sum = 0;
            }
            if(ans > C)
                return false; 
        }
        for(int i = 0;i<M;i++)
        {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for(int j = 0;j<N;j++)
            {
                sum += B[j][i];
                if(ans < sum)
                    ans = sum;
                if(sum < 0)
                    sum = 0;
            }
            if(ans > C)
                return false; 
        }
        return true;
    }
    static void generate(int[][] B,int i,int j,int A,int C,int N,int M)
    {
        if(i >= N || j >= M)
            return;
        if( i == (N-1) && j == (M-1))
        {
            // for(int k = 0;k<N;k++)
            // {
            //     for(int l = 0;l<M;l++)
            //         System.out.print(B[k][l] + " ");
            //     System.out.println("");
            // }
            // System.out.println();
            count++;
            if(checkSum(B,C,N,M))
                isPossible = true;
            return;
        }
        // if(visited[i][j] == 1)
        //     return;
        
        generate(B,i+1,j,A,C,N,M);
        generate(B,i,j+1,A,C,N,M);
        if(A == 0)
            return;
        B[i][j] = B[i][j]*(-1);
        generate(B,i+1,j,A-1,C,N,M);
        generate(B,i,j+1,A-1,C,N,M);
        B[i][j] = B[i][j]*(-1);
    }
    public static int solve(int A, int[][] B, int C) {
        int N = B.length;
        int M = B[0].length;
        visited = new int[N][M];
        generate(B,0,0,A,C,N,M);
        if(isPossible)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        int A = 2;
        int[][] B = {
            {71, -44, -11, 86, 27},
            {-34, 3, -21, 31, 93},
            {-15, 70, -17, -66, 76},
            {-85, -39, 92, -53, 28}
    };
        int C = 50;
        System.out.println(solve(A,B,C));
        System.out.println(count);
    }
}
