/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29514/assignment/problems/960/?navref=cl_pb_nv_tb

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.

Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000
All the alphabets of S are lower case (a - z)

Example Input
Input 1:
 A = 2
 B = "bbaabb"
Input 2:
 A = 1
 B = "bc"

Example Output
Output 1:
 1
Output 2:
 1

Example Explanation
Explanation 1:
 We can re-order the given string into "abbabb".
Explanation 2:
 String "bc" is already arranged.
*/
import java.util.*;
public class ReplicatingSubstring {
    public static int solve(int A, String B) {
        char[] char_array = B.toCharArray();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<char_array.length;i++)
        {
            hm.put(char_array[i],hm.getOrDefault(char_array[i],0)+1);
        }
        for(Map.Entry<Character,Integer> entry : hm.entrySet())
        {
            if(entry.getValue()%A!=0)
                return -1;
        }
        return 1;
    }
    public static void main(String[] args) {
        String B = new String("aabbaa");
        int A = 2;
        System.out.println(solve(A, B));
    }
}
