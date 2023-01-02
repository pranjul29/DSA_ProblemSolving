/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34937/assignment/problems/9388/?navref=cl_pb_nv_tb
There is a dictionary A of N words, and ith word has a unique weight Wi.

Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.

Output the words in decreasing order of their weight.

NOTE: If there is no word that starts with the given prefix output -1.

Problem Constraints
1 <= T <= 5
1 <= N <= 20000
1 <= M <= 10000
1 <= Wi <= 10^6
1 <= length of any string either in A or B <= 30

Input Format
First line is an integer T denoting the number of test cases.
For each test case,
First line denotes two space seperated integer N and M.
Second line denotes N space seperated strings denoting the words in dictionary.
Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
Fourth line denotes M space seperated integers denoting the prefixes.

Output Format
For every prefix B[i], print the space seperated output on a new line.
NOTE: After every output there should be a space.

Example Input
Input 1:
 1
 6 3
 abcd aecd abaa abef acdcc acbcc
 2 1 3 4 6 5
 ab abc a
Input 2:
 1
 5 3
 aaaa aacd abaa abaa aadcc
 3 4 1 2 6 
 aa aba abc

Example Output
Output 1:
 abef abaa abcd 
 abcd 
 acdcc acbcc abef abaa abcd 
Output 2:
 aadcc aacd aaaa 
 abaa abaa 
 -1 

Example Explanation
Explanation 1:
 For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
 For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
 For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
 Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
Explanation 2:
 For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
 For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
 For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
*/
import java.lang.*;
import java.util.*;
class Node{
    char ch;
    Node[] child = new Node[26];
    boolean isEnd = false;
    int weight = 0;
    Node(char ch)
    {
        this.ch = ch;
    }
}
class Pair{
    String str;
    int weight;
    public Pair(String str,int weight)
    {
        this.str = str;
        this.weight = weight;
    }
    public String toString()
    {
        return new String(this.str + " " + this.weight);
    }
}
public class AutoComplete {
    static PriorityQueue<Pair> queue;
    public static void insert(String A,Node root,int weight)
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
        curr.weight = weight;
    }
    public static void strStartingFrom(Node root, StringBuilder prefix)
    {
        Node curr = root;
        for(int i = 0;i<26;i++)
        {
            if(curr.child[i] != null)
            {
                StringBuilder temp = new StringBuilder(prefix);
                temp.append((char)(i + 97));
                strStartingFrom(curr.child[i],temp);
            }
        }
        if(curr.isEnd == true)
            queue.add(new Pair(prefix.toString(),curr.weight));
    }
    public static void search(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        queue = new PriorityQueue<>((a,b) -> {
            return (b.weight-a.weight);
        });
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                return;
            }
            curr = curr.child[index];
        }
        StringBuilder temp = new StringBuilder(A);
        strStartingFrom(curr,temp);
    }
    public static void solve(String[] words, int[] weight, String[] prefixes)
    {
        Node root = new Node('#');
        for(int i = 0;i<words.length;i++)
        {
            insert(words[i],root,weight[i]);
        }
        for(int i = 0;i<prefixes.length;i++)
        {
            search(prefixes[i],root);
            int count = 0;
            // System.out.println(queue);
            if(queue.isEmpty())
                System.out.println("-1 ");
            else
            {
                while(!queue.isEmpty() && count < 5)
                {
                    System.out.print(queue.poll().str + " ");
                    count++;
                }
                System.out.println();
            }
        }
        
    }
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0;t<T;t++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            String second = sc.nextLine();
            // System.out.println(second);
            String[] words = second.split(" ");
            int[] weight = new int[N];
            for(int i = 0;i<words.length;i++)
            {
                weight[i] = sc.nextInt();
            }
            // for(int i = 0;i<words.length;i++)
            // {
            //     System.out.print(words[i] + " " + weight[i]);
            // }
            // System.out.println();
            sc.nextLine();
            String prefix_line = sc.nextLine();
            String[] prefixes = prefix_line.split(" ");
            solve(words,weight,prefixes);
        }
    }
}
