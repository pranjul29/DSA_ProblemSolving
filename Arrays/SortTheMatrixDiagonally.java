import java.util.*;
public class SortTheMatrixDiagonally {
    public static int[][] diagonalSort(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int i = 0;
        int j = 0;
        for(j = 0;j<M;j++)
        {
            int k = i;
            int l = j;
            ArrayList<Integer> arr = new ArrayList<>();
            while(k < N && l < M)
            {
                arr.add(mat[k][l]);
                k++;
                l++;
            }
            Collections.sort(arr);
            int count = 0;
            k = i;
            l = j;
            while(k < N && l < M)
            {
                mat[k][l] = arr.get(count);
                count++;
                k++;
                l++;
            }
        }
        j = 0;
        for(i = 1;i<N;i++)
        {
            int k = i;
            int l = j;
            ArrayList<Integer> arr = new ArrayList<>();
            while(k < N && l < M)
            {
                arr.add(mat[k][l]);
                k++;
                l++;
            }
            Collections.sort(arr);
            int count = 0;
            k = i;
            l = j;
            while(k < N && l < M)
            {
                mat[k][l] = arr.get(count);
                count++;
                k++;
                l++;
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        mat = diagonalSort(mat);
        for(int i = 0;i<mat.length;i++)
        {
            for(int j = 0;j<mat[0].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
