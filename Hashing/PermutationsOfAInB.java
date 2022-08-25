/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29518/assignment/problems/1089/?navref=cl_pb_nv_tb

You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.

Problem Constraints
1 <= N < M <= 10^5

Example Input
Input 1:
 A = "abc"
 B = "abcbacabc"
Input 2:
 A = "aca"
 B = "acaa"

Example Output
Output 1:
 5
Output 2:
 2

Example Explanation
Explanation 1:
 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:
 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
*/
import java.util.*;
public class PermutationsOfAInB {
    public static boolean isValidPermutation(HashMap<Character,Integer> A,HashMap<Character,Integer> B)
    {
        return A.equals(B);
    }
    public static int solve(String A, String B) {
        if(A.length()>B.length())
            return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);
        }
        System.out.println(hm);
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm2.put(B.charAt(i),hm2.getOrDefault(B.charAt(i),0)+1);
        }
        System.out.println(hm2);
        int count = 0;
        if(isValidPermutation(hm,hm2))
            count++;
        System.out.println(count);
        for(int i = A.length();i<B.length();i++)
        {
            hm2.put(B.charAt(i),hm2.getOrDefault(B.charAt(i),0)+1);
            hm2.put(B.charAt(i-A.length()),hm2.get(B.charAt(i-A.length()))-1);
            if(hm2.get(B.charAt(i-A.length())) == 0)
                hm2.remove(B.charAt(i-A.length()));
            System.out.println(hm2);
            if(isValidPermutation(hm,hm2))
                count++;
            System.out.println(count);
        }
        return count;
    }
    public static void main(String[] args) {
        String A = new String("docp");
        String B = new String("aoapeooeoapcpaocecddoocdcqqapeapccc");
        System.out.println(solve(A, B));
    }
}
