/* 
Source: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".
Example 2:

Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
Example 3:

Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 
Constraints:
1 <= s1.length, s2.length, baseStr <= 1000
s1.length == s2.length
s1, s2, and baseStr consist of lowercase English letters.
*/
import java.util.*;
public class LexiographicallySmallestEquivalentString {
    static int[] parent;
    static int find_root(int node)
    {
        if(node == parent[node])
            return node;
        parent[node] = find_root(parent[node]);
        return parent[node];
    }
    static void union_edge(int x,int y)
    {
        int r1 = find_root(x);
        int r2 = find_root(y);
        if(r1 == r2)
            return;
        if(r1 < r2)
            parent[r2] = r1;
        else
            parent[r1] = r2;
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashSet<ArrayList<Integer>> adj = new HashSet<>();
        parent = new int[26];
        for(int i = 0;i<26;i++)
            parent[i] = i;
        for(int i = 0;i<s1.length();i++)
        {
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            if(char1 < char2)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(char1);
                temp.add(char2);
                adj.add(temp);
            }
            else if(char2 < char1)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(char2);
                temp.add(char1);
                adj.add(temp);
            }
        }
        for(ArrayList<Integer> edge : adj)
            union_edge(edge.get(0),edge.get(1));
        for(int i = 0;i<26;i++)
            parent[i] = find_root(i);
        char[] char_array = new char[baseStr.length()];
        for(int i = 0;i<baseStr.length();i++)
            char_array[i] = (char)(parent[baseStr.charAt(i) - 'a'] + 97);
        return new String(char_array);
    }
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("world");
        String baseStr = new String("hold");
        System.out.println(smallestEquivalentString(s1,s2,baseStr));
    }
}
