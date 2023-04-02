/* 
Source: https://leetcode.com/problems/can-place-flowers/description/
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

Constraints:

1 <= flowerbed.length <= 2 * 10^4
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
*/
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(m == 1 )
            if ((flowerbed[0] == 0 && n <= 1) || (flowerbed[0] == 1 && n == 0))
                return true;
            else
                return false;
        for(int i = 0;i<m;i++)
        {
            if(n == 0)
                return true;
            if(i == 0)
            {
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0)
                {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else if(i == m-1)
            {
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0)
                {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else
            {
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0)
                {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if(n == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
