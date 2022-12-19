/* 
Source: https://leetcode.com/problems/count-pairs-of-similar-strings/description/
You are given a 0-indexed string array words.
Two strings are similar if they consist of the same characters.
For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.
Example 1:
Input: words = ["aba","aabb","abcd","bac","aabc"]
Output: 2
Explanation: There are 2 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'. 
- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'. 
Example 2:
Input: words = ["aabb","ab","ba"]
Output: 3
Explanation: There are 3 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'. 
- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
Example 3:
Input: words = ["nba","cba","dba"]
Output: 0
Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.
 
Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consist of only lowercase English letters.
*/
import java.util.*;
public class CountPairsOfSimilarStrings {
    public static HashSet getCharacters(String word)
    {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<word.length();i++)
        {
            set.add(word.charAt(i));
        }
        return set;
    }
    public static int similarPairs(String[] words) {
        HashSet<Character>[] sets = new HashSet[words.length];
        for(int i = 0;i<words.length;i++)
        {
            sets[i] = getCharacters(words[i]);
        }
        int ans = 0;
        HashMap<HashSet<Character>,Integer> count = new HashMap<>();
        for(int i = 0;i<sets.length;i++)
        {
            count.put(sets[i],count.getOrDefault(sets[i],0) + 1);
        }
        for (Map.Entry<HashSet<Character>,Integer> mapElement : count.entrySet()) {
            int value = mapElement.getValue();
            ans += ((value*(value-1))/2);
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(similarPairs(words));
    }
}
