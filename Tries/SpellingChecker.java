/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34937/assignment/problems/9366/?navref=cl_pb_nv_tb
Given an array of words A (dictionary) and another array B (which contain some words).
You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
NOTE: Try to do this in O(n) time complexity.

Problem Constraints
1 <= |A| <= 1000
1 <= sum of all strings in A <= 50000
1 <= |B| <= 1000

Example Input
Input 1:
A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:
A = [ "tape", "bcci" ]
B = [ "table", "cci" ]

Example Output
Output 1:
[1, 0]
Output 2:
[0, 0]

Example Explanation
Explanation 1:
Only "cat" is present in the dictionary.
Explanation 2:
None of the words are present in the dictionary.
*/
class Node{
    char ch;
    Node[] child = new Node[26];
    boolean isEnd = false;
    Node(char ch)
    {
        this.ch = ch;
    }
}
public class SpellingChecker {
    public static void insert(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                curr.child[index] = new Node(char_array[i]);
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    public static boolean search(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEnd;
    }
    public static int[] solve(String[] A, String[] B) {
        Node root = new Node('#');
        for(int i = 0;i<A.length;i++)
        {
            insert(A[i],root);
        }
        int[] result = new int[B.length];
        for(int i = 0;i<B.length;i++)
        {
            if(search(B[i],root))
                result[i] = 1;
        }
        return result;
    }
    public static void main(String[] args) {
        String[] A = {new String("a"),new String("b")};
        String[] B = {new String("a"),new String("c")};
        System.out.println(solve(A,B));
    }
}
