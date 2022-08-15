/*
Source: https://leetcode.com/problems/roman-to-integer/
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/
public class RomanToInteger {
    public static int romanToInt(String s) {
        int ans = 0;
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == 'I' && i < s.length()-1)
            {
                char temp = s.charAt(i+1);
                if(temp == 'I')
                {
                    ans = ans + 2;
                    i++;
                }
                else if(temp == 'V')
                {
                    ans = ans + 4;
                    i++;
                }
                else if(temp == 'X')
                {
                    ans = ans + 9;
                    i++;
                }
                else
                {
                    ans = ans + 1;
                }
            }
            else if(c == 'X' && i < s.length()-1)
            {
                char temp = s.charAt(i+1);
                if(temp == 'X')
                {
                    ans = ans + 20;
                    i++;
                }
                else if(temp == 'L')
                {
                    ans = ans + 40;
                    i++;
                }
                else if(temp == 'C')
                {
                    ans = ans + 90;
                    i++;
                }
                else
                {
                    ans = ans + 10;
                }
            }
            else if(c == 'C' && i < s.length()-1)
            {
                char temp = s.charAt(i+1);
                if(temp == 'C')
                {
                    ans = ans + 200;
                    i++;
                }
                else if(temp == 'D')
                {
                    ans = ans + 400;
                    i++;
                }
                else if(temp == 'M')
                {
                    ans = ans + 900;
                    i++;
                }
                else
                {
                    ans = ans + 100;
                }
            }
            else if(c == 'I')
                ans = ans + 1;
            else if(c == 'V')
                ans = ans + 5;
            else if(c == 'X')
                ans = ans + 10;
            else if(c == 'L')
                ans = ans + 50;
            else if(c == 'C')
                ans = ans + 100;
            else if(c == 'D')
                ans = ans + 500;
            else
                ans = ans + 1000;
            //System.out.println("C: " + c + " Ans: " + ans );
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt(new String("DCXXI")));
    }
}
