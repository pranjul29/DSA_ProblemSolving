/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29518/assignment/problems/151/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/minimum-window-substring/submissions/
Source: https://www.interviewbit.com/problems/window-string/
Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:
If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )

Problem Constraints
1 <= size(A), size(B) <= 10^6

Example Input
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:
 A = "Aa91b"
 B = "ab"

Example Output
Output 1:
 "BANC"
Output 2:
 "a91b"

Example Explanation
Explanation 1:
 "BANC" is a substring of A which contains all characters of B.
Explanation 2:
 "a91b" is the substring of A which contains all characters of B.
*/
import java.util.*;
public class WindowString {
    public static String minWindow(String A, String B) {
        HashMap<Character,Integer> hm = new HashMap<>();
        char[] a = B.toCharArray();
        for(char c: a)
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        //System.out.println(hm);
        int s = 0;
        int e = 0;
        int count = 0;
        int ans = Integer.MAX_VALUE;
        int ans_s = -1;
        int ans_e = -1;
        System.out.println(hm);
        System.out.println("S: "+s+" E: "+e+" Count: "+count);
        while(e<A.length() && s<A.length())
        {
            char b_end = A.charAt(e);
            char b_start = A.charAt(s);
            System.out.println("START: " +b_start+" END: "+b_end);
            if(hm.containsKey(b_end) && count!=hm.size())
            {
                int temp = hm.get(b_end);
                temp--;
                if(temp == 0)  
                    count++;
                hm.put(b_end,temp);
            }
            if(count == hm.size())
            {
                int length = e-s+1;
                if(length<ans)
                {
                    ans = length;
                    ans_s = s;
                    ans_e = e;
                    System.out.println("Answer: "+length+" Start: "+ans_s+" End: "+ans_e);
                }
                if(hm.containsKey(b_start))
                {
                    int temp = hm.get(b_start);
                    temp++;
                    if(temp>0)
                        count--;
                    hm.put(b_start,temp);
                }
                s++;
            }
            if(count != hm.size())
            {
                e++;
            }
            System.out.println(hm);
            System.out.println("S: "+s+" E: "+e+" Count: "+count);
        }
        System.out.println(ans);
        if(ans == Integer.MAX_VALUE)
            return new String("");
        else
            return A.substring(ans_s,ans_e+1);
        
    }
    public static void main(String[] args) {
        String A = "A";
        String B = "A";

        System.out.println(minWindow(A, B));
    }
}
