/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34909/assignment/problems/4365/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.

Problem Constraints
1 <= |A| <= 100000

Example Input
Input 1:
 A = "abadbc"
Input 2:
 A = "abcabc"

Example Output
Output 1:
"aabbdd"
Output 2:
"aaabc#"

Example Explanation
Explanation 1:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
*/
import java.util.*;
public class FirstNonRepeatingCharacter {
    public static String solve(String A) {
        char[] char_array = A.toCharArray();
        HashMap<Character,Integer> freq = new HashMap<>();
        Queue<Character> queue = new LinkedList<Character>();
        StringBuilder str = new StringBuilder();
        str.append(char_array[0]);
        queue.add(char_array[0]);
        freq.put(char_array[0],1);
        for(int i = 1;i<char_array.length;i++)
        {
            queue.add(char_array[i]);
            freq.put(char_array[i],freq.getOrDefault(char_array[i],0)+1);
            while(!queue.isEmpty() && freq.get(queue.peek()) != 1)
            {
                queue.remove();
            }
            if(queue.isEmpty())
                str.append("#");
            else
                str.append(queue.peek());
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String S = new String("abadbc");
        System.out.println(solve(S));
    }
}
