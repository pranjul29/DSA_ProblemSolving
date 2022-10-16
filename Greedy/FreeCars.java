/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34953/assignment/problems/9294/?navref=cl_pb_nv_tb
Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
NOTE:
You can start buying from time = 0.
Return your answer modulo 10^9 + 7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9

Example Input
Input 1:
 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
Input 2:
 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]

Example Output
Output 1:
 20
Output 2:
 30

Example Explanation
Explanation 1:
 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
Explanation 2:
 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
*/
import java.util.*;
class Car{
    int time;
    int profit;
    public Car(int time,int profit)
    {
        this.time = time;
        this.profit = profit;
    }
}
public class FreeCars {
    public static int solve(int[] A, int[] B) {
        ArrayList<Car> cars = new ArrayList<>();
        for(int i = 0;i<A.length;i++)
        {
            cars.add(new Car(A[i],B[i]));
        }
        Collections.sort(cars,(a,b) -> {
            return a.time - b.time;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(cars.get(0).profit);
        for(int i = 1;i<A.length;i++)
        {
            if(cars.get(i).time == minHeap.size())
            {
                if(minHeap.peek() < cars.get(i).profit)
                {
                    minHeap.poll();
                    minHeap.add(cars.get(i).profit);
                }
            }
            else if(cars.get(i).time > minHeap.size())
            {
                minHeap.add(cars.get(i).profit);
            }
        }
        long total_profit = 0;
        long M = 1000000007;
        while(minHeap.size() > 0)
        {
            total_profit += minHeap.poll();
            total_profit = total_profit%M;
        }
        return (int)total_profit;
    }
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 3, 3};
        int[] B = {5, 6, 1, 3, 9};
        System.out.println(solve(A,B));
    }
}
