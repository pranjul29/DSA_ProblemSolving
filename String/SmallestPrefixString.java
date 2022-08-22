/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/homework/problems/884/?navref=cl_pb_nv_tb

Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets, find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.

Problem Constraints
1 <= N, M <= 100000

Example Input
Input 1:
 A = "abba"
 B = "cdd"
Input 2:
 A = "acd"
 B = "bay"

Example Output
Output 1:
 "abbac"
Output 2:
 "ab"

Example Explanation
Explanation 1:
 We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
 The lexicographically smallest string will be "abbac".
Explanation 2:
 We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
 The lexicographically smallest string will be "ab".
*/
public class SmallestPrefixString {
    public static String smallestPrefix(String A, String B) {
        char c = B.charAt(0);
        int i;
        for(i = 1;i<A.length();i++)
        {
            char temp = A.charAt(i);
            if(temp >= c)
            {
                break;
            }
        }
        StringBuilder result = new StringBuilder(A.substring(0,i));
        result.append(c);
        return result.toString();
    }
    public static void main(String[] args) {
        String A = new String("Harry");
        String B = new String("Potter");
        System.out.println(smallestPrefix(A, B));
    }
}
