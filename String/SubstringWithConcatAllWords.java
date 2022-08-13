/*
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
 
Constraints:
1 <= s.length <= 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
*/
import java.util.*;
public class SubstringWithConcatAllWords {
    public static boolean isValid(String s,HashMap<String,Integer> hm,int N,int window_size)
    {
        for(int i = 0;i<=s.length()-window_size;i=i+window_size)
        {
            String temp = s.substring(i,i+window_size);
            if(hm.containsKey(temp) && hm.get(temp)>0)
            {
                int left = hm.get(temp) - 1;
                if(left == 0)
                    hm.remove(temp);
                else
                    hm.put(temp,left);   
            }
            else
            {
                return false;
            }
        }
        if(hm.size()>0)
            return false;
        return true;
        
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int count = 0;
        HashMap<String,Integer> hm = new HashMap<>();
        int window_size = words[0].length();
        int N = words.length;
        int[] freq_arr = new int[N];
        List<Integer> ls = new ArrayList<Integer>();
        for(int i = 0;i<N;i++)
        {
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        for(int i = 0;i<=s.length()-window_size;i++)
        {
            String temp = s.substring(i,i+window_size);
            if(hm.containsKey(temp))
            {
                if((i+window_size*N) <= s.length())
                {
                    HashMap<String,Integer> temp_hm = (HashMap<String, Integer>)hm.clone();
                    String temp_s = s.substring(i,i+window_size*N);
                    if(isValid(temp_s,temp_hm,N,window_size))
                        ls.add(i);
                }
            }
        }
        return ls;
    }
    public static void main(String[] args) {
        String[] arr = {"word","good","best","word"};
        String s = new String("wordgoodgoodgoodbestword");
        System.out.println(findSubstring(s, arr));
    }
}
