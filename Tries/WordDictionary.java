/* 
Source: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 
Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.
*/
class TrieNode{
    char ch;
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
public class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
        root.ch = '*';
    }
    
    public void addWord(String word) {
        char[] char_array = word.toCharArray();
        TrieNode curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i] - 'a';
            if(curr.child[index]==null)
            {
                curr.child[index] = new TrieNode();
                curr.child[index].ch = char_array[i];
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        char[] char_array = word.toCharArray();
        return match(char_array,0, root);
    }

    private boolean match(char[] char_array,int k ,TrieNode root)
    {
        if(k == char_array.length)
            return root.isEnd;
        if(char_array[k] != '.')
        {
            int index = char_array[k] - 'a';
            if(root.child[index] == null)
                return false;
            else
                return match(char_array,k+1,root.child[index]);
        }
        else
        {
            for(int i = 0;i<26;i++)
            {
                if(root.child[i] != null)
                {
                    if(match(char_array,k+1,root.child[i]))
                        return true;
                }
            }
        }
        return false;
    }
}

