/* 
Source: https://leetcode.com/problems/sort-characters-by-frequency/

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 
Constraints:
1 <= s.length <= 5 * 10^5
s consists of uppercase and lowercase English letters and digits.
*/
import java.util.*;
class Pair{
    char x;
    int y;
    public Pair(char x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return this.x + " " + this.y;
    }
}
public class SortCharacterByFreq {
    public static String frequencySort(String s) {
        char[] char_array = s.toCharArray();
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i = 0;i<char_array.length;i++)
        {
            freq.put(char_array[i],freq.getOrDefault(char_array[i],0)+1);
        }

        ArrayList<Pair> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> map : freq.entrySet())
        {
            list.add(new Pair(map.getKey(),map.getValue()));
        }
        Collections.sort(list,(a,b) -> {
            return b.y - a.y;
        });
        StringBuilder result = new StringBuilder("");
        for(int i = 0;i<list.size();i++)
        {
            for(int j = 0;j<list.get(i).y;j++)
                result.append(list.get(i).x);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort(new String("Tree")));
    }
}
