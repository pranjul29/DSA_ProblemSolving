/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/homework/problems/419/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/minimize-the-absolute-difference/

Given three sorted arrays A, B and Cof not necessarily same sizes.
Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:
A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:
1

Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
*/
public class MinimiseTheAbsoluteDifference {
    public static int solve(int[] A, int[] B, int[] C) {
        int len_A = A.length;
        int len_B = B.length;
        int len_C = C.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int lowest_diff = Integer.MAX_VALUE;
        int counter = 0;
        while(i<(len_A-1) || j<(len_B-1) || k<(len_C-1))
        {
            int temp_A = A[i];
            int temp_B = B[j];
            int temp_C = C[k];
            int highest = 0;
            int lowest = 0;
            if(temp_A == temp_B  && temp_B == temp_C)
            {
                i++;
                j++;
                k++;
                lowest_diff = Math.min(0,lowest_diff);
                break;
            }
            if(temp_A > temp_B)
            {
                if(temp_A > temp_C)
                {
                    highest = temp_A;
                }
                else
                {
                    highest = temp_C;
                }
            }
            else
            {
                if(temp_B > temp_C)
                {
                    highest = temp_B;
                }
                else
                {
                    highest = temp_C;
                }
            }
            if(temp_A < temp_B)
            {
                if(temp_A < temp_C)
                {
                    lowest = temp_A;
                }
                else
                {
                    lowest = temp_C;
                }
            }
            else
            {
                if(temp_B < temp_C)
                {
                    lowest = temp_B;
                }
                else
                {
                    lowest = temp_C;
                }
            }
            lowest_diff = Math.min(Math.abs(highest-lowest),lowest_diff);
            System.out.println("Highest: "+highest+" Lowest: "+lowest);
            System.out.println("A: "+temp_A+ " B: "+temp_B+" C: "+temp_C);
            if(temp_A == lowest)
            {
                if(i < (len_A - 1))
                    i++;
                else
                {
                    if(temp_B < temp_C)
                    {
                        if(j < (len_B-1))
                            j++;
                        else
                            k++;
                    }
                    else
                    {
                        if(k < (len_C-1))
                            k++;
                        else
                            j++;
                    }
                }
            
            }
            if(temp_B == lowest)
            {
                if(j < (len_B - 1))
                    j++;
                else
                {
                    if(temp_A < temp_C)
                    {
                        if(i < (len_A-1))
                            i++;
                        else
                            k++;
                    }
                    else
                    {
                        if(k < (len_C-1))
                            k++;
                        else
                            i++;
                    }
                }
            
            }
            if(temp_C == lowest)
            {
                if(k < (len_C - 1))
                    k++;
                else
                {
                    if(temp_B < temp_A)
                    {
                        if(j < (len_B-1))
                            j++;
                        else
                            i++;
                    }
                    else
                    {
                        if(i < (len_A-1))
                            i++;
                        else
                            j++;
                    }
                }
            }
            System.out.println("i: "+i+" j:"+j+" k:"+k);
            counter++;
            if(counter == 30)
                break;
        }
        int highest = Math.max(A[i],Math.max(B[j],C[k]));
        int lowest = Math.min(A[i],Math.min(B[j],C[k]));
        lowest_diff = Math.min(lowest_diff,Math.abs(highest-lowest));
        return lowest_diff;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,5,8,10};
        int[] arr1 = {6,9,10};
        int[] arr2 = {2,3,6,10};
        System.out.println(solve(arr, arr1, arr2));
    }
}
