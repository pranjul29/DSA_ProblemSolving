/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34941/assignment/problems/4121/?navref=cl_pb_nv_tb

Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.

Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [5, 17, 100, 11]

Example Output
Output 1:
 7
Output 2:
 117

Example Explanation
Explanation 1:
 Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
Explanation 2:
 Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
*/
import java.util.*;
class Node{
    char ch;
    Node[] child = new Node[2];
    boolean isEnd = false;
    Node(char ch)
    {
        this.ch = ch;
    }
}
public class MaximumXor {
    static int num_of_bits;
    static int ans = Integer.MIN_VALUE;
    public static boolean checkBit(int A,int i)
    {
        if(((1<<i) & A)>0)
            return true;
        return false;
    }
    public static char[] changeToBinary(int A)
    {
        char[] binary_array = new char[num_of_bits];
        for(int i = binary_array.length-1;i>=0;i--)
        {
            if(checkBit(A,i))
                binary_array[binary_array.length - i - 1] = '1';
            else
                binary_array[binary_array.length - i - 1] = '0';
        }
        return binary_array;
    }
    public static void insert(int A,Node root)
    {
        char[] char_array = changeToBinary(A);
        Node curr = root;
        for(int i = 0;i<char_array.length;i++)
        {
            int index = char_array[i]-'0';
            if(curr.child[index] == null)
            {
                curr.child[index] = new Node(char_array[i]);
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    public static int solve(int[] A) {
        num_of_bits = (int)Math.ceil(Math.log(1000000000) / Math.log(2));
        Node root = new Node('#');
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<A.length;i++)
            insert(A[i],root);
        for(int i = 0;i<A.length;i++)
        {
            int xor = 0;
            Node curr = root;
            for(int j = num_of_bits-1;j>=0;j--)
            {
                if(checkBit(A[i],j))
                {
                    if(curr.child[0]!=null)
                    {
                        curr = curr.child[0];
                        xor = xor + (1<<j);
                    }
                    else
                    {
                        curr = curr.child[1];
                    }
                }
                else
                {
                    if(curr.child[1]!=null)
                    {
                        curr = curr.child[1];
                        xor = xor + (1<<j);
                    }
                    else
                    {
                        curr = curr.child[0];
                    }
                }
            }
            ans = Math.max(ans,xor);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        System.out.println(solve(A));
    }
}
