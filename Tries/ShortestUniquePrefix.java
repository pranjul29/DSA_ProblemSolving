/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34937/assignment/problems/277/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/shortest-unique-prefix/
Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

Problem Constraints
1 <= Sum of length of all words <= 10^6

Example Input
Input 1:
 A = ["zebra", "dog", "duck", "dove"]
Input 2:
A = ["apple", "ball", "cat"]

Example Output
Output 1:
 ["z", "dog", "du", "dov"]
Output 2:
 ["a", "b", "c"]

Example Explanation
Explanation 1:
 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".  
Explanation 2:
 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
*/
class Node{
    char ch;
    Node[] child = new Node[26];
    boolean isEnd = false;
    int prefix;
    Node(char ch,int prefix)
    {
        this.ch = ch;
        this.prefix = prefix;
    }
    @Override
    public String toString() {
        return this.ch + " + " + this.prefix;
    }
}
public class ShortestUniquePrefix {
    public static void insert(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                curr.child[index] = new Node(char_array[i],0);
            }
            curr.child[index].prefix++;
            for(int j = 0;j<26;j++)
                System.out.print(curr.child[j]+" ");
            System.out.println("");
            curr = curr.child[index];
            
        }
        curr.isEnd = true;
    }
    public static String search(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        StringBuilder str = new StringBuilder("");
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            str.append(char_array[i]);
            if(curr.child[index].prefix == 1)
            {
                return str.toString();
            }
            curr = curr.child[index];
        }
        return str.toString();
    }
    public static String[] prefix(String[] A) {
        Node root = new Node('#',-1);
        for(int i = 0;i<A.length;i++)
        {
            insert(A[i],root);
        }
        String[] result = new String[A.length];
        for(int i = 0;i<result.length;i++)
        {
            result[i] = search(A[i],root);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] A = {new String("zebra"),new String("dog"),new String("duck"),new String("dot")};
        System.out.println(prefix(A));
    }
}
