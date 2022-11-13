/* 
Source: https://leetcode.com/problems/find-median-from-data-stream/
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:
MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 
Constraints:
-10^5 <= num <= 10^5
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 
Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
*/
import java.util.*;
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0)
            maxHeap.add(num);
        else if(maxHeap.peek() > num)
        {
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 1)
            {
                minHeap.add(maxHeap.poll());
            }
        }
        else
        {
            minHeap.add(num);
            if(minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if(minHeapSize == maxHeapSize)
        {
            double median = (double)maxHeap.peek() + (double)minHeap.peek();
            return median/2;
        }
        else
        {
            return (double)maxHeap.peek();
        }
    }
}
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(2);
        double param_2 = obj.findMedian();

    }
}
