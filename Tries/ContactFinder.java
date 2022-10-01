/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34937/homework/problems/9384/?navref=cl_pb_nv_tb
We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
You have been given sequential add and find operations. You need to perform each operation in order.
And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .

Problem Constraints
1 <= |A| <= 10000
1 <= |length of strings in B| <= 10

Example Input
Input 1:
A = [0, 0, 1, 1]
B = ["hack", "hacker", "hac", "hak"]
Input 2:
A = [0, 1]
B = ["abcde", "abc"]

Example Output
Output 1:
[2, 0]
Output 2:
[1]

Example Explanation
Explanation 1:
We perform the following sequence of operations:
Add a contact named "hack".
Add a contact named "hacker".
Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
Explanation 2:
Add "abcde"
Find words with prefix "abc". We have answer as 1.
*/
import java.util.*;
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
}
public class ContactFinder {
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
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    public static int search(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        int prefix_value=0;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'a';
            if(curr.child[index] == null)
            {
                return 0;
            }
            prefix_value = curr.child[index].prefix;
            curr = curr.child[index];
        }
        return prefix_value;
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Node root = new Node('#',-1);
        for(int i = 0;i<A.size();i++)
        {
            if(A.get(i) == 0)
                insert(B.get(i),root);
            else
                result.add(search(B.get(i),root));
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1};
        String[] b = {new String("hack"),new String("hacker"),new String("hac"),new String("hak")};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
        ArrayList<String> B = new ArrayList<>(Arrays.asList(b));
        System.out.println(solve(A,B));
    }
}
