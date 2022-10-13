/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34953/homework/problems/1036/?navref=cl_pb_nv_tb
The local ship renting service has a special rate plan:
It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.
You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.

Problem Constraints
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.

Example Input
Input 1:
 A = 4
 B = 3
 C = [2, 1, 1]
Input 2:
 A = 4
 B = 3
 C = [2, 2, 2]

Example Output
Output 1:
 [5, 5]
Output 2:
 [7, 6]

Example Explanation
Explantion 1:
 Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 So, the cost will be 5.
 Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
 So, the cost will be 5.
Explanation 2:
 Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 So, the cost will be 7.
 Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
 So, the cost will be 6.
*/
import java.util.*;
public class TheShipCompany {
    public static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0;i<B;i++)
        {
            maxHeap.add(C[i]);
            minHeap.add(C[i]);
        }
        int minimum = 0;
        int maximum = 0;
        while(A > 0)
        {
            int cost = minHeap.poll();
            minimum += cost;
            cost--;
            if(cost > 0)
                minHeap.add(cost);
            cost = maxHeap.poll();
            maximum += cost;
            cost--;
            if(cost > 0)
                maxHeap.add(cost);
            A--;
        }
        int[] result = {maximum,minimum};
        return result;
    }
    public static void main(String[] args) {
        int A = 4;
        int B = 3;
        int[] C = {2,1,1};
        System.out.println(solve(A,B,C));
    }
}
