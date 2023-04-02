/* 
Source: https://leetcode.com/problems/implement-trie-prefix-tree/
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 
Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 
Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
*/
class TrieNode{
    char ch;
    TrieNode[] child = new TrieNode[26];
    boolean isEnd = false;
}
public class ImplementTrie {
    TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
        root.ch = '*';
    }
    
    public void insert(String word) {
        char[] char_array = word.toCharArray();
        TrieNode curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i] - 'a';
            if(curr.child[index] == null)
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
        TrieNode curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i] - 'a';
            if(curr.child[index] == null)
            {
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        char[] char_array = prefix.toCharArray();
        TrieNode curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i] - 'a';
            if(curr.child[index] == null)
            {
                return false;
            }
            curr = curr.child[index];
        }
        return true;
    }
}
