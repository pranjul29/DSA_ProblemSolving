/* 
Source: https://leetcode.com/problems/minimum-jumps-to-reach-home/description/
A certain bug's home is on the x-axis at position x. Help them get there from position 0.

The bug jumps according to the following rules:

It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.

Example 1:

Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
Output: 3
Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
Example 2:

Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
Output: -1
Example 3:

Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
Output: 2
Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.

Constraints:

1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
All the elements in forbidden are distinct.
Position x is not forbidden.
*/
import java.util.*;
class Pair{
    int pos;
    int isBackward;
    int jumps;
    public Pair(int pos,int isBackward,int jumps)
    {
        this.pos = pos;
        this.isBackward = isBackward;
        this.jumps = jumps;
    }
    public String toString()
    {
        return new String(this.pos + " " + this.jumps + " " + this.isBackward);
    }
}
public class MinimumJumpsToReachHome {
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : forbidden)
            set.add(i);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,0));
        HashSet<String> alreadyVisited = new HashSet<>();
        while(!queue.isEmpty())
        {
            Pair curr = queue.peek();
            queue.remove();
            if(alreadyVisited.contains(curr.pos+","+curr.isBackward))
                continue;
            if(curr.pos == x)
                return curr.jumps;
            alreadyVisited.add(curr.pos+","+curr.isBackward);
            int position = curr.pos + a;
            int jumps = curr.jumps+1;
            if(!alreadyVisited.contains(position) && !set.contains(position) && position<= 6000)
                queue.add(new Pair(position,0,jumps));  
            position = curr.pos - b;
            if(curr.isBackward == 0 && position >= 0 && !alreadyVisited.contains(position) && !set.contains(position))
                queue.add(new Pair(position,1,jumps));
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] forbidden = {14,4,18,1,15};
        int a = 3, b = 15, x = 9;
        System.out.println(minimumJumps(forbidden,a,b,x));
    }
}
