/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/homework/problems/1192/?navref=cl_pb_nv_tb
Misha loves eating candies. She has been given N boxes of Candies.
She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
NOTE 2: The same box will not be chosen again.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^5
1 <= B <= 10^6

Example Input
Input 1:
 A = [3, 2, 3]
 B = 4
Input 2:
 A = [1, 2, 1]
 B = 2

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 She will not eat from the 3rd box as now it has candies greater than B.
 So the number of candies Misha eat is 2.
Explanation 2:
 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 She will not eat from the 2nd box as now it has candies greater than B.
 So the number of candies Misha eat is 1.
*/
import java.util.*;
public class MishaAndCandies {
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i = 0;i<A.length;i++)
        {
            heap.add(A[i]);
        }
        System.out.println(heap);
        int count = 0;
        while(!heap.isEmpty() && heap.peek()<=B)
        {
            int temp = heap.poll();
            count += temp/2;
            if(!heap.isEmpty())
            {
                int temp2 = heap.poll();
                temp2 += (temp+1)/2;
                heap.add(temp2);
            }
            else
                break;
            System.out.println(heap);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {110, 289, 585, 135, 314, 259, 238, 798, 954, 399, 492, 282, 311, 177, 804, 769, 191, 539, 830, 806, 854, 50, 373, 329, 549, 202, 399, 542, 166, 986, 446, 346, 58, 269, 103, 267, 547, 171, 713, 408, 847, 988, 704, 162, 850, 493, 59, 584, 588, 117, 639, 310, 615, 871, 977, 136, 973, 324, 450, 737, 778, 139, 606, 98, 968, 275, 911, 558, 849, 62, 495, 512, 106, 682, 980, 9, 517, 104, 80, 540, 689, 696, 396, 681, 541, 468, 12, 482, 459, 438, 924, 507, 725, 388, 579, 754, 421, 30, 151};
        int B = 80;
        System.out.println(solve(A, B));
    }
}
