/* 
Source: https://leetcode.com/problems/water-and-jug-problem/description/?envType=study-plan&id=graph-i
You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 

Example 1:

Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 
Example 2:

Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 

Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6
*/
import java.util.*;
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        if(jug1Capacity + jug2Capacity == targetCapacity)
            return true;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(0,0));
        queue.add(temp);
        boolean isPossible = false;
        HashSet<ArrayList<Integer>> alreadyHas = new HashSet<>();
        if(jug1Capacity < jug2Capacity)
        {
            int temp_cap = jug1Capacity;
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp_cap; 
        }
        while(!queue.isEmpty())
        {
            // System.out.println(queue);
            // System.out.println("SET: " + alreadyHas);
            ArrayList<Integer> curr = queue.peek();
            queue.remove();
            if(alreadyHas.contains(curr))
                continue;
            if(curr.get(0) == targetCapacity || curr.get(0) + curr.get(1) == targetCapacity || curr.get(1) == targetCapacity)
            {
                isPossible = true;
                break;
            }
            alreadyHas.add(curr);
            int x = curr.get(0);
            int y = curr.get(1);
            // (0,4), (3,5)
            if(x > 0)
            {
                ArrayList<Integer> temp1 = new ArrayList<Integer>(Arrays.asList(x,0));
                if(!alreadyHas.contains(temp1))
                    queue.add(temp1);
            }
            if(y > 0)
            {
                ArrayList<Integer> temp2 = new ArrayList<Integer>(Arrays.asList(0,y));
                if(!alreadyHas.contains(temp2))
                    queue.add(temp2);
            }
            if(x < jug1Capacity)
            {
                ArrayList<Integer> temp3 = new ArrayList<Integer>(Arrays.asList(jug1Capacity,y));
                if(!alreadyHas.contains(temp3))
                    queue.add(temp3);
            }
            if(y < jug2Capacity)
            {
                ArrayList<Integer> temp4 = new ArrayList<Integer>(Arrays.asList(x,jug2Capacity));
                if(!alreadyHas.contains(temp4))
                    queue.add(temp4);
            }
            if(x + y >= jug1Capacity)
            {
                ArrayList<Integer> temp5 = new ArrayList<Integer>(Arrays.asList(jug1Capacity,y - (jug1Capacity-x)));
                if(!alreadyHas.contains(temp5))
                    queue.add(temp5);
            }
            if(x + y >= jug2Capacity)
            {
                ArrayList<Integer> temp6 = new ArrayList<Integer>(Arrays.asList(x - (jug2Capacity-y),jug2Capacity));
                if(!alreadyHas.contains(temp6))
                    queue.add(temp6);
            }
            if(x + y <= jug1Capacity)
            {
                ArrayList<Integer> temp7 = new ArrayList<Integer>(Arrays.asList(Math.min(x+y,jug1Capacity),0));
                if(!alreadyHas.contains(temp7))
                    queue.add(temp7);
            }
            if(x + y <= jug2Capacity)
            {
                ArrayList<Integer> temp8 = new ArrayList<Integer>(Arrays.asList(0,Math.min(x+y,jug2Capacity)));
                if(!alreadyHas.contains(temp8))
                    queue.add(temp8);
            }
            
        }
        return isPossible;
    }
}
public class WaterAndJugProblems {
    public static void main(String[] args) {
        int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
        Solution s = new Solution();
        System.out.println(s.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }
}
