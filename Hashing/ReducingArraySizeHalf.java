/*
Source: https://leetcode.com/problems/reduce-array-size-to-the-half/
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:
Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.

Example 2:
Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 
Constraints:
2 <= arr.length <= 10^5
arr.length is even.
1 <= arr[i] <= 10^5
*/
import java.util.*;
public class ReducingArraySizeHalf {
    public static int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<arr.length;i++)
        {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int[] freq = new int[hm.size()];
        int counter = 0;
        for(Map.Entry<Integer,Integer> element : hm.entrySet())
        {
            freq[counter] = element.getValue();
            counter++;
        }
        Arrays.sort(freq);
        //System.out.println(hm);
        int sum = 0;
        for(int i = freq.length-1;i>=0;i--)
        {
            sum = sum + freq[i];
            if(sum >= arr.length/2)
            {
                return freq.length-i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }
}
