/* 
Source: https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=study-plan&id=level-1
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 
Constraints:

1 <= s.length <= 10^5
s consists of only uppercase English letters.
0 <= k <= s.length
*/
public class LongestRepeatingCharacterReplacement {
    public static boolean isValidSubstring(String s, int k,int length)
    {
        int[] char_count = new int[26];
        int start = 0;
        int end = 0;
        int highestFreq = 0;
        while(end < s.length())
        {
            char_count[s.charAt(end)-'A']++;
            if(end-start + 1 > length)
            {
                char_count[s.charAt(start)-'A']--;
                start++;
                
            }
            highestFreq = Math.max(highestFreq,char_count[s.charAt(end)-'A']);
            if(length - highestFreq <= k)
                return true;
            end++;
        }
        return false;
    }
    public static int characterReplacement(String s, int k) {
        int low = 1;
        int high = s.length();
        int ans = 1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(isValidSubstring(s,k,mid))
            {
                low = mid+1;
                ans = mid;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = new String("AABABBA");
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
}
