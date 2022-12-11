/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34965/homework/problems/10/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/decode-ways/
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 10^9 + 7.

Problem Constraints
1 <= length(A) <= 10^5

Input Format
The first and the only argument is a string A.

Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.

Example Input
Input 1:
 A = "12"
Input 2:
 A = "8"

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
Explanation 2:
 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
*/
import java.util.*;
public class WaysToDecode {
    static int M = 1000000007;
    static HashMap<String,Integer> results;
    static int numberOfDecodings(String A,int start)
    {
        if(start >= A.length() )
            return 0;
        if(A.charAt(start) == '0')
            return 0;
        if(results.containsKey(A.substring(start)))
            return results.get(A.substring(start));
        if(start == A.length()-2)
        {
            if(A.charAt(start) > '2' && A.charAt(start+1) == '0')
            {
                results.put(A.substring(start),0);
                return 0;
            }
            if(A.charAt(start) > '2' && A.charAt(start+1) >= '1')
            {
                results.put(A.substring(start),1);
                return 1;
            }
            if(A.charAt(start) == '2' && A.charAt(start+1) > '6')
            {
                results.put(A.substring(start),1);
                return 1;
            }
        }
        if(A.charAt(start) > '2' && A.charAt(start+1) =='0')
            return 0;
        int count =  numberOfDecodings(A,start+1)%M;
        if(start!= (A.length()-1))
        {
            if(A.charAt(start) == '1')
            {
                count = (count + numberOfDecodings(A,start+2))%M;
            }
            else if(A.charAt(start) == '2' && A.charAt(start+1)<='6')
            {
                count = (count + numberOfDecodings(A,start+2))%M;
            }
        }
        results.put(A.substring(start),count);
        return count;
    }
    public static int numDecodings(String A) {
        results = new HashMap<>();
        results.put("0",0);
        for(int i = 1;i<=10;i++ )
        {
            results.put(String.valueOf(i),1);
        }
        results.put("20",1);
        for(int i = 11;i<=19;i++)
        {
            results.put(String.valueOf(i),2);
        }
        for(int i = 21;i<=26;i++)
        {
            results.put(String.valueOf(i),2);
        }
        return numberOfDecodings(A,0);
    }
    public static void main(String[] args) {
        String S = "4612";
        System.out.println(numDecodings(S));
    }
}
