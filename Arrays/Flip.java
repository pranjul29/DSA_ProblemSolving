/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29452/assignment/problems/329/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/flip/
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Constraints: 1 <= size of string <= 100000

Example Input
Input 1:
A = "010"

Input 2:
A = "111"

Example Output
Output 1:
[1, 1]
Output 2:
[]
*/
public class Flip {
    public static int[] flip(String A) {
        int[] arr = new int[A.length()];
        int count_one = 0;
        for(int i = 0;i<A.length();i++)
        {
            if(A.charAt(i) == '1')
            {
                arr[i] = -1;
                count_one++;
            }
            else
                arr[i] = 1;
        }
        if(count_one == A.length())
        {
            int[] result = {};
            return result;
        }
        int max_sub_sum = Integer.MIN_VALUE;
        int l = -1;
        int r = -1;
        int sum = 0;
        int s = 0;
        for(int i = 0;i<A.length();i++)
        {
            sum += arr[i];
            System.out.println("SUM: "+sum);
            if(sum > max_sub_sum)
            {
                l = s;
                max_sub_sum = sum;
                r = i;
                System.out.println("l: "+l+ " max_sub_sum: "+max_sub_sum+" r: "+r);
            }
            if(sum < 0)
            {
                sum = 0;
                s = i +1;
            }
        }
        if(l == -1)
        {
            int[] result = {};
            return result;
        }
        int[] result = {l+1,r+1};
        return result;
    }
    public static void main(String[] args)
    {
        int[] result = flip(new String("010"));
        System.out.println("L: " + result[0] + " R: "+result[1]);
    }
}
