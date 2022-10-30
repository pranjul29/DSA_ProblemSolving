/* 
Source: https://leetcode.com/problems/group-anagrams/
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/
import java.util.*;
public class GroupAnagrams {
    public static HashMap<Character,Integer> findMapping(String S)
    {
        char[] char_array = S.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<char_array.length;i++)
        {
            map.put(char_array[i],map.getOrDefault(char_array[i],0)+1);
        }
        return map;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> result_map = new HashMap<>();
        for(int i = 0;i<strs.length;i++)
        {
            HashMap<Character,Integer> temp = findMapping(strs[i]);
            if(result_map.containsKey(temp))
            {
                List<String> temp_list = new ArrayList<String>();
                temp_list = result_map.get(temp);
                temp_list.add(strs[i]);
            }
            else
            {
                List<String> temp_list = new ArrayList<String>();
                temp_list.add(strs[i]);
                result_map.put(temp,temp_list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<HashMap<Character,Integer>,List<String>> mapElement : result_map.entrySet()) {
            List<String> key = mapElement.getValue();
            result.add(key);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
