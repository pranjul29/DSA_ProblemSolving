/*
Source: https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/

You are given a binary string s. In one second, all occurrences of "01" are simultaneously replaced with "10". This process repeats until no occurrences of "01" exist.

Return the number of seconds needed to complete this process.

Example 1:

Input: s = "0110101"
Output: 4
Explanation: 
After one second, s becomes "1011010".
After another second, s becomes "1101100".
After the third second, s becomes "1110100".
After the fourth second, s becomes "1111000".
No occurrence of "01" exists any longer, and the process needed 4 seconds to complete,
so we return 4.
Example 2:

Input: s = "11100"
Output: 0
Explanation:
No occurrence of "01" exists in s, and the processes needed 0 seconds to complete,
so we return 0.
 

Constraints:

1 <= s.length <= 1000
s[i] is either '0' or '1'.
*/
public class TimeNeededToRearrangeBinaryString {
    public static int secondsToRemoveOccurrences(String s) {
        int count = 0;
        char[] temp = s.toCharArray();
        int flag = 0;
        while(true)
        {
            flag = 0;
            for(int i = 0;i<temp.length-1;i++)
            {
                if(temp[i] == '0')
                {
                    if(temp[i+1] == '1')
                    {
                        temp[i] = '1';
                        temp[i+1] = '0';
                        flag = 1;
                        i++;
                    }
                }
            }
           // System.out.println(temp);
            if(flag == 0)
                break;
            else
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = new String("0110101");
        System.out.println(secondsToRemoveOccurrences(s));
    }
}
