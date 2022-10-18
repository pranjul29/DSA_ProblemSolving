/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/homework/problems/147/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/letter-phone/
Source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a digit string A, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
NOTE: Make sure the returned strings are lexicographically sorted.

Problem Constraints
1 <= |A| <= 10

Example Input
Input 1:
 A = "23"
Input 2:
 A = "012"

Example Output
Output 1:
 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:
 ["01a", "01b", "01c"]

Example Explanation
Explanation 1:
 There are 9 possible letter combinations.
Explanation 2:
 Only 3 possible letter combinations.
*/
import java.util.*;
public class LetterPhone {
    static ArrayList<String> result;
    static HashMap<Character,ArrayList<Character>> map;
    static void generateString(String A, int pos, int N,StringBuilder str)
    {
        if(pos == N)
        {
            result.add(str.toString());
            return;
        }
        if(map.containsKey(A.charAt(pos)))
        {
            ArrayList<Character> arr = map.get(A.charAt(pos));
            for(int i = 0;i<arr.size();i++)
            {
                str.append(arr.get(i));
                generateString(A,pos+1,N,str);
                str.deleteCharAt(str.length() - 1);
            }
        }
        else
        {
            str.append(A.charAt(pos));
            generateString(A,pos+1,N,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
    public static ArrayList<String> letterCombinations(String A) {
        result = new ArrayList<String>();
        map = new HashMap<>();
        map.put('2',new ArrayList<Character>(Arrays.asList('a','b','c')));
        map.put('3',new ArrayList<Character>(Arrays.asList('d','e','f')));
        map.put('4',new ArrayList<Character>(Arrays.asList('g','h','i')));
        map.put('5',new ArrayList<Character>(Arrays.asList('j','k','l')));
        map.put('6',new ArrayList<Character>(Arrays.asList('m','n','o')));
        map.put('7',new ArrayList<Character>(Arrays.asList('p','q','r','s')));
        map.put('8',new ArrayList<Character>(Arrays.asList('t','u','v')));
        map.put('9',new ArrayList<Character>(Arrays.asList('w','x','y','z')));
        generateString(A,0,A.length(),new StringBuilder(""));
        return result;
    }    
    public static void main(String[] args) {
        String A = new String("012");
        System.out.println(letterCombinations(A));
    }
}
