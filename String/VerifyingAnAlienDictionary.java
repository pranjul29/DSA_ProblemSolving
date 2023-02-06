/* 
Source: https://leetcode.com/problems/verifying-an-alien-dictionary/description/
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
*/
public class VerifyingAnAlienDictionary {
    static boolean isSorted(int[] order_value,String word1,String word2)
    {
        for(int i = 0;i<Math.min(word1.length(),word2.length());i++)
        {
            int index1 = word1.charAt(i) - 'a';
            int index2 = word2.charAt(i) - 'a';
            if(order_value[index1] < order_value[index2])
                return true;
            else if(order_value[index1] > order_value[index2])
                return false;
        }
        if(word1.length() > word2.length())
            return false;
        return true;
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int[] order_value = new int[26];
        for(int i = 0;i<order.length();i++)
        {
            int index = order.charAt(i) - 'a';
            order_value[index] = i;
        }
        for(int i = 1;i<words.length;i++)
            if(!isSorted(order_value,words[i-1],words[i]))
                return false;
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = new String("hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(isAlienSorted(words,order));
    }
}