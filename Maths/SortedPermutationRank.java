/*

Source : https://www.interviewbit.com/problems/sorted-permutation-rank/

 Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003

Problem Constraints
1 <= |A| <= 1000

Example Input
Input 1:
A = "acb"

Input 2:
A = "a"

Example Output
Output 1:
2

Output 2:
1

Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is 1
*/
import java.util.*;
public class SortedPermutationRank {
    public static int findRank(String A) {
        int[] factorial = new int[A.length()];
        factorial[0] = 1;
        int M = 1000003;
        for(int i = 1;i<A.length();i++)
        {
            long temp = ((long)factorial[i-1] * (long)i)%M;
            factorial[i] = (int)temp;
            System.out.print(factorial[i] + " ");
        }
        System.out.println();
        char[] temp_array = A.toCharArray();
        boolean[] isUsed = new boolean[A.length()];
        Arrays.sort(temp_array);
        long rank = 0;
        for(int i = 0;i<A.length();i++)
        {
            char temp = A.charAt(i);
            System.out.println("i: " + temp);
            for(int j = 0;j<A.length();j++)
            {
                System.out.println("j: " + temp_array[j]);
                if(!isUsed[j])
                {
                    if(temp_array[j] == temp)
                    {
                        isUsed[j] = true;
                        break;
                    }
                    else
                    {
                        rank = (rank + factorial[A.length()-i-1])%M;
                    }
                }
                System.out.println("Rank: " + rank);
            }
        }
        rank = rank+1;
        return (int)rank;
    }

    public static void main(String[] args)
    {
        System.out.println(findRank("acdb"));
    }
}
