/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29516/homework/problems/1255/?navref=cl_pb_nv_tb
You are given a string A. Find the number of substrings that start and end with 'a'.

Problem Constraints
1 <= |A| <= 10^5
The string will have only lowercase English letters.

Example Input
Input 1:
 A = "aab"
Input 2:
 A = "bcbc"

Example Output
Output 1:
 3
Output 2:
 0

Example Explanation
Explanation 1:
 Substrings that start and end with 'a' are:
    1. "a"
    2. "aa"
    3. "a"
Explanation 2:
 There are no substrings that start and end with 'a'.
*/
public class CountA {
    public static int solve(String A) {
        int count = 0;
        for(int i = 0;i<A.length();i++)
        {
            if(A.charAt(i) == 'a')
                count++;
        }
        return count*(count+1)/2;
    }
    public static void main(String[] args) {
        String A = new String("ahvhsdbauf");
        System.out.println(A);
    }
}
