/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29518/assignment/problems/5550/?navref=cl_pb_nv_tb
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:
Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.

Problem Constraints
1 <= |A| <= 10^5

Example Input
Input 1:
 A = "abcd"
Input 2:
 A = "aab"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 String A can be rearranged into "cadb" or "bdac" 
Explanation 2:
 No arrangement of string A can make it free of boring substrings.
*/
import java.util.*;
public class BoringString {
    public static int solve(String A) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);
        }
        System.out.println(hm);
        for(char c = 'a';c<'z';c++)
        {
            System.out.println(c);
            if(hm.containsKey(c))
            {
                if(hm.containsKey((char)(c+1)))
                {
                    System.out.println("C: " + c + " C+1: "+(char)(c+1));
                    int count = hm.get(c) + hm.get((char)(c+1));
                    int rest = A.length() - count;
                    if(count-rest > 1)
                        return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        String A = "wwuvuw";
        System.out.println(solve(A));
    }
}
