/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29492/homework/problems/318/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/sorted-permutation-rank-with-repeats/
Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.

NOTE:

The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.

Problem Constraints
1 <= len(A) <= 1000000

Input Format
First argument is a string A.

Output Format
Return an integer denoting the rank.

Example Input
Input 1:
 A = "aba"
Input 2:
 A = "bca"

Example Output
Output 1:
 2
Output 2:
 4
 
Example Explanation
Explanation 1:
 The order permutations with letters 'a', 'a', and 'b' :
    aab
    aba 
    baa
 So, the rank is 2.
Explanation 2:
 The order permutations with letters 'a', 'b', and 'c' :
    abc
    acb 
    bac
    bca
    cab
    cba
 So, the rank is 4.
*/
import java.util.*;
class Solution {
    int mod = 1000003;
    int length;
    long[] fact;
    HashMap<Character,Integer> char_count;
    public long pow(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    long inverseNumber(long num) {
        // Find the modular multiplicative inverse
        // Calculates (num ^ (MOD - 2)) % MOD
        return pow(num, mod-2 , mod);
    }
    public long findRankBeforeThis(char curr,int i)
    {
        long rank = fact[length-i];
        for(Map.Entry<Character,Integer> map_entry: char_count.entrySet())
        {
            if(map_entry.getKey() == curr)
                rank = rank*inverseNumber(fact[map_entry.getValue()-1])%mod;
            else
                rank = rank*inverseNumber(fact[map_entry.getValue()])%mod;
        }
        rank = rank%mod;
        return rank;
    }
    public int findRank(String A) {
        char_count = new HashMap<>();
        length = A.length();
        fact = new long[length];
        for(int i = 0;i<length;i++)
            char_count.put(A.charAt(i),char_count.getOrDefault(A.charAt(i),0) + 1);
        fact[0] = 1;
        for(int i = 1;i<length;i++)
            fact[i] = (fact[i-1]*i)%mod;
        long rank = 0;
        for(int i = 0;i<length;i++)
        {
            long curr = fact[length - i - 1];
            int count = 0;
            for(Map.Entry<Character,Integer> map_entry: char_count.entrySet())
            {
                if(map_entry.getKey() < A.charAt(i))
                    rank = (rank + findRankBeforeThis(map_entry.getKey(),i+1)%mod)%mod;
            }
            if(char_count.get(A.charAt(i)) == 1)
                char_count.remove(A.charAt(i));
            else
                char_count.put(A.charAt(i),char_count.get(A.charAt(i))-1);
        }
        return (int)(rank+1);
        
    }
}
public class SortedPermutationRanksWithRepeats {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findRank(new String("bbbbaaaa"));
    }
}
