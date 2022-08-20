/*
Source: https://leetcode.com/problems/shifting-letters-ii/

You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

Example 1:

Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
Example 2:

Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
Output: "catz"
Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".
 
Constraints:

1 <= s.length, shifts.length <= 5 * 10^4
shifts[i].length == 3
0 <= starti <= endi < s.length
0 <= directioni <= 1
s consists of lowercase English letters.
*/
public class ShiftingLettersII {
    public static String shiftingLetters(String s, int[][] shifts) {
        int[] ascii_array = new int[s.length()];
        for(int i = 0;i<s.length();i++)
        {
            ascii_array[i] = s.charAt(i)-97;
        }
        
        int[] diff_array = new int[s.length()+1];
        diff_array[0] = ascii_array[0];
        diff_array[s.length()] = 0;
        for(int i = 1;i<s.length();i++)
        {
            diff_array[i] = ascii_array[i] - ascii_array[i-1];
        }
        
        for(int i = 0;i<shifts.length;i++)
        {
            int l = shifts[i][0];
            int r = shifts[i][1];
            int x = 1;
            if(shifts[i][2] == 0)
                x = -1;
            diff_array[l] += x;
            diff_array[r+1] -= x;
        }
        
        for(int i = 0;i<ascii_array.length;i++)
        {
            if(i == 0)
            {
                ascii_array[i] = diff_array[i];
                if(ascii_array[i] < 0)
                {
                    while(ascii_array[i]<0)
                        ascii_array[i] += 26;
                }
                else
                    ascii_array[i] = ascii_array[i]%26;
            }
            else
            {
                ascii_array[i] = diff_array[i] + ascii_array[i-1];
                if(ascii_array[i] < 0)
                {
                    while(ascii_array[i]<0)
                        ascii_array[i] += 26;
                }
                else
                    ascii_array[i] = ascii_array[i]%26;
            }
        }
        char[] result_array = new char[s.length()];
        for(int i = 0;i<s.length();i++)
        {
            result_array[i] = (char)(ascii_array[i] + 97);
        }
        System.out.println(diff_array[0]);
        return new String(result_array);
    }
    public static void main(String[] args) {
        int[][] arr = {{0,1,0},{1,2,1},{0,2,1}};
        String s = new String("abc");
        System.out.println(shiftingLetters(s, arr));
    }
}
