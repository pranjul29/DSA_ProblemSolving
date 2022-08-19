/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/assignment/problems/298/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/

Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 10^6
-10^7 <= A[i] <= 10^7

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
Example Input
A = [1,2,-2,4,-4]
Example Output
[2,-2,4,-4]
Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.

*/
import java.util.*;;
public class LargestContinousSequenceZeroSum {
    public static int[] lszero(int[] A) {
        long[] prefix = new long[A.length];
        prefix[0] = A[0];
        for(int i = 1;i<A.length;i++)
            prefix[i] = A[i] + prefix[i-1];
        HashMap<Long,Integer> hm= new HashMap<>();
        hm.put((long)0,-1);
        int start = -1;
        int end = -1;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0;i<prefix.length;i++)
        {
            if(hm.containsKey(prefix[i]))
            {
                int length = i - hm.get(prefix[i]);
                if(length > maximum)
                {
                    maximum = length;
                    start = hm.get(prefix[i])+1;
                    end = i;
                }
            }
            else
                hm.put(prefix[i],i);
            System.out.println(hm);
            System.out.println("Start: "+start+" End:"+end);
        }
        if(start == -1)
        {
            int[] result = new int[0];
            return result;
        }
        int[] result = new int[maximum];
        int counter = 0;
        for(int i = start;i<=end;i++)
        {
            result[counter] = A[i];
            counter++;
        }
        return result;
    }    
    public static void main(String[] args) {
        int[] arr = {-19, 8, 2, -8, 19, 5, -2, -23};
        System.out.println(lszero(arr));
    }
}
