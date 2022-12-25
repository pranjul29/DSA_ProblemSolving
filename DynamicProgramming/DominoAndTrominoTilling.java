/* 
Source: https://leetcode.com/problems/domino-and-tromino-tiling/description/
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 10^9 + 7.
In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

Example 1:
Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 1000
*/
public class DominoAndTrominoTilling {
    public static int numTilings(int n) {
        if(n <= 2)
            return n;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        int mod = 1000000007;
        for(int i = 3;i<=n;i++)
            arr[i] = ((2*arr[i-1])%mod + arr[i-3])%mod;
        return arr[n];
    }
    public static void main(String[] args) {
        int n =5;
        System.out.println(numTilings(n));
    }
}
