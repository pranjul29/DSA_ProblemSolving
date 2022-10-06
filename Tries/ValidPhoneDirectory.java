/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34941/homework/problems/9828/?navref=cl_pb_nv_tb
Given a phone directory in the form of string array A containing N numeric strings.
If any phone number is prefix of another phone number then phone directory is invalid else it is valid.
You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.

Problem Constraints
2 <= N <= 10^5
1 <= |A[i]| <= 50
A[i] consists only of numeric digits.

Example Input
Input 1:
 A = ["1234", "2342", "567"]
Input 2:
 A = ["00121", "001"]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 No number is prefix of any other number so phone directory is valid so we will return 1.
Explanation 2:
 "001" is prefix of "00121" so phone directory is invalid so we will return 0.
*/
class Node{
    char ch;
    Node[] child = new Node[10];
    boolean isEnd = false;
    Node(char ch)
    {
        this.ch = ch;
    }
}
public class ValidPhoneDirectory {
    public static boolean insert(String A,Node root)
    {
        char[] char_array = A.toCharArray();
        Node curr = root;
        int flag = 0;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'0';
            if(curr.child[index] == null)
            {
                flag = 1;
                curr.child[index] = new Node(char_array[i]);
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
        if(flag == 0)
            return false;
        for(int i = 0;i<curr.child.length;i++)
        {
            if(curr.child[i] != null)
                return false;
        }
        return true;
    }
    public static int solve(String[] A) {
        Node root = new Node('#');
        for(int i = 0;i<A.length;i++)
        {
            if(!insert(A[i],root))
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        String[] A = {new String("1234"), new String("2342"),new String("567")};
        System.out.println(solve(A));
    }
}
