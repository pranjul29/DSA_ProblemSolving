/*
Source: https://leetcode.com/problems/top-k-frequent-words/
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 
Constraints:
1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 
Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
*/
import java.util.*;
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0;i<words.length;i++)
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue() > b.getValue())
                return -1;
            else if(a.getValue() < b.getValue())
                return 1;
            else
                return a.getKey().compareTo(b.getKey());
        });
        for(Map.Entry<String,Integer> e : map.entrySet())
            pq.offer(e); 
        List<String> result = new ArrayList<String>();
        while(k>0)
        {
            result.add(pq.poll().getKey());
            k--;
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        System.out.println(topKFrequent(words,k));
    }
}
