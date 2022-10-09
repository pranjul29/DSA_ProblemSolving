/*
Source: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
Return the lexicographically smallest string that can be written on the paper.

Example 1:
Input: s = "zza"
Output: "azz"
Explanation: Let p denote the written string.
Initially p="", s="zza", t="".
Perform first operation three times p="", s="", t="zza".
Perform second operation three times p="azz", s="", t="".
Example 2:
Input: s = "bac"
Output: "abc"
Explanation: Let p denote the written string.
Perform first operation twice p="", s="c", t="ba". 
Perform second operation twice p="ab", s="c", t="". 
Perform first operation p="ab", s="", t="c". 
Perform second operation p="abc", s="", t="".
Example 3:
Input: s = "bdda"
Output: "addb"
Explanation: Let p denote the written string.
Initially p="", s="bdda", t="".
Perform first operation four times p="", s="", t="bdda".
Perform second operation four times p="addb", s="", t="".
 
Constraints:
1 <= s.length <= 10^5
s consists of only English lowercase letters.
*/
public class UsingRobotToPrintLexiographicallySmallestString {
    public static String robotWithString(String s) {
        char[] start = s.toCharArray();
        char[] smallest = new char[start.length];
        smallest[start.length-1] = start[start.length-1];
        for(int i = start.length-2;i>=0;i--)
        {
            if(start[i] < smallest[i+1])
                smallest[i] = start[i];
            else
                smallest[i] = smallest[i+1];
        }
        char[] end = new char[start.length];
        int end_counter = 0;
        int start_counter = 0;
        StringBuilder result = new StringBuilder("");
        while(start_counter!=start.length)
        {
            if(end_counter > 0 && end[end_counter-1] <= smallest[start_counter])
            {
                result.append(end[end_counter-1]);
                end_counter--;
            }
            else if(start[start_counter] == smallest[start_counter])
            {
                result.append(start[start_counter]);
                start_counter++;
            }
            else
            {
                end[end_counter] = start[start_counter];
                start_counter++;
                end_counter++;
            }
        }
        end_counter--;
        while(end_counter >=0 )
        {
            result.append(end[end_counter]);
            end_counter--;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = new String("zza");
        System.out.print(robotWithString(s));
    }
}
