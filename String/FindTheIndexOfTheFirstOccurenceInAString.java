/* 
Source: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 
Constraints:

1 <= haystack.length, needle.length <= 10^4
haystack and needle consist of only lowercase English characters.
*/
public class FindTheIndexOfTheFirstOccurenceInAString {
    public static int strStr(String haystack, String needle) {
        StringBuilder str = new StringBuilder(needle);
        str.append("#");
        str.append(haystack);
        String string = str.toString();

        int[] lps = new int[string.length()];
        lps[0] = 0;
        for(int i = 1;i<string.length();i++)
        {
            int X = lps[i-1];
            while(string.charAt(X)!=string.charAt(i))
            {
                if(X == 0)
                {
                    X = -1;
                    break;
                }
                X = lps[X-1];
            }
            lps[i] = X + 1;
        }
        int length = needle.length();
        for(int i = 0;i<lps.length;i++)
        {
            // Length * 2 Because, Length of Needle + Length of Starting Needle String at Start we appended
            if(lps[i] == length)
                return i-length*2;

        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = new String("sadbutsad");
        String needle = new String("sad");
        System.out.println(strStr(haystack,needle));
    }
}
