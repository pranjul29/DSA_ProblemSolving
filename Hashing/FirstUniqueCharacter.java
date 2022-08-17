/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 
Constraints:
1 <= s.length <= 10^5
s consists of only lowercase English letters.
*/
import java.util.*;
public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(hm.containsKey(c))
            {
                ArrayList<Integer> arr = hm.get(c);
                arr.set(1,arr.get(1)+1);
            }
            else
            {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                arr.add(1);
                hm.put(c,arr);
            }
        }
        int minimum_index = Integer.MAX_VALUE;
        for (Map.Entry<Character,ArrayList<Integer>> mapElement : hm.entrySet()) {
            ArrayList<Integer> value = mapElement.getValue();
            if(value.get(1) == 1)
                minimum_index = Math.min(minimum_index,value.get(0));
        }
        if(minimum_index == Integer.MAX_VALUE)
            return -1;
        return minimum_index;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar(new String("aadadaad")));
    }
}
