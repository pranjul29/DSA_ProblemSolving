/* 
Source: https://leetcode.com/problems/optimal-partition-of-string/description/
Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.
Example 2:

Input: s = "ssssss"
Output: 6
Explanation:
The only valid partition is ("s","s","s","s","s","s").
 
Constraints:

1 <= s.length <= 10^5
s consists of only English lowercase letters.
*/
import java.util.*;;
public class OptimalPartitionOfString {
    public static int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();

        int count = 1;
        for(int i = 0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                count++;
                set = new HashSet<>();
                set.add(s.charAt(i));
            }
            else
                set.add(s.charAt(i));
            // System.out.println(set);
            // System.out.println(count);
        }
        return count;
    }
    public static void main(String[] args) {
        String s = new String("abacaba");
        System.out.println(partitionString(s));
    }
    
}
