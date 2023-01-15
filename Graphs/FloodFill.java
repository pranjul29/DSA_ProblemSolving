/* 
Source: https://leetcode.com/problems/flood-fill/description/?envType=study-plan&id=graph-i
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 
Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 2^16
0 <= sr < m
0 <= sc < n
*/
import java.util.*;
public class FloodFill {
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x>=n || y>=m)
            return false;
        return true;
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> source = new ArrayList<>();
        source.add(sr); source.add(sc);
        queue.add(source);
        int first_color = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        while(!queue.isEmpty())
        {
            ArrayList<Integer> curr = queue.peek();
            queue.remove();
            if(image[curr.get(0)][curr.get(1)] == color)
                continue;
            image[curr.get(0)][curr.get(1)] = color;
            int[] x_n = {1,-1,0,0};
            int[] y_n = {0,0,-1,1};
            for(int i = 0;i<4;i++)
            {
                int x = x_n[i] + curr.get(0);
                int y = y_n[i] + curr.get(1);
                if(isValid(x,y,n,m) && (image[x][y] == first_color))
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(x); temp.add(y);
                    queue.add(temp);
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        System.out.println(floodFill(image,sr,sc,color));
    }
}
