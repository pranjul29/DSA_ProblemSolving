/*
Source: https://leetcode.com/problems/minimum-number-of-refueling-stops/

A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.

Constraints:

1 <= target, startFuel <= 10^9
0 <= stations.length <= 500
0 <= positioni <= positioni+1 < target
1 <= fueli < 10^9
*/
public class MinimumNumberOfRefuelStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        // Maximum Distance that can be Covered using i Stops is Stored at distance_travelled[i] 
        long[] distance_travelled = new long[stations.length+1];
        
        // If No Stations Used, We Can reach maximum upto StartFuel
        distance_travelled[0] = 1l*startFuel;
        
        for(int i = 0;i<stations.length;i++)
        {
            for(int j = i;j>=0;j--)
            {
                /*Check if the current Maximum Distance Covered with j Stops is Greater than Equal to
                Current Station Position, If Not we can't reach here so Can't add It's Fuel*/
                if(distance_travelled[j]>=stations[i][0])
                {
                    distance_travelled[j+1] = Math.max(distance_travelled[j+1],distance_travelled[j]+(1l*stations[i][1]));
                }
            }
        }
        
        // If distance_travelled[i] >= target , we Can reach Destination using i stops
        
        for(int i = 0;i<=stations.length;i++)
        {
            if(distance_travelled[i]>=target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] station = {{10,60},{20,30},{30,30},{60,40}};
        int target = 100;
        int startFuel = 10;
        System.out.println(minRefuelStops(target, startFuel, station));
    }
}
