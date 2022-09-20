/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34901/homework/problems/1157/?navref=cl_pb_nv_tb
Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
Find and return the maximum value of XOR among all subarrays.

Problem Constraints
2 <= N <= 10^5
1 <= A[i] <= 10^7

Example Input
Input 1:
 A = [2, 3, 1, 4]
Input 2:
 A = [1, 3]

Example Output
Output 1:
 7
Outnput 2:
 2

Example Explanation
Explanation 1:
 All subarrays of A having size greater than 1 are:
 Subarray            XOR of maximum and 2nd maximum no.
 1. [2, 3]           1
 2. [2, 3, 1]        1
 3. [2, 3, 1, 4]     7
 4. [3, 1]           2
 5. [3, 1, 4]        7
 6. [1, 4]           5
 So maximum value of Xor among all subarrays is 7.
Explanation 2:
 Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.
*/
public class AllSubarrays {
    
}
