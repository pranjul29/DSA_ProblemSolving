/* 
Source: https://leetcode.com/problems/word-ladder/description/?envType=study-plan&id=graph-i
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/
import java.util.*;
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord + "" + 1);
        HashSet<String> visited = new HashSet<>();

        for(String i : wordList)
            set.add(i);
        int length = beginWord.length();
        while(!queue.isEmpty())
        {
            // System.out.println(queue);
            String curr = queue.peek();
            queue.remove();
            String gene = curr.substring(0,length);
            if(visited.contains(gene))
                continue;
            int count = Integer.parseInt(curr.substring(length));
            if(gene.equals(endWord))
                return count;
            visited.add(gene);
            for(int i = 0;i<length;i++)
            {
                int index = i;
                char[] char_array = gene.toCharArray();
                for(char c = 'a';c<='z'; c++)
                {
                    if(gene.charAt(index) == c)
                        continue;
                    char_array[index] = c;
                    String temp = new String(char_array);
                    if(set.contains(temp))
                        queue.add(temp + "" + (count+1));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = new String("hit");
        String endWord = new String("cog");
        List<String> wordList = new List<String>(Arrays.asList(
            "hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
