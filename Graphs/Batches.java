/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35005/assignment/problems/4974/?navref=cl_pb_nv_tb
A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
All students who know each other are placed in one batch.
Strength of a batch is equal to sum of the strength of all the students in it.
Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
Find the number of batches selected.
NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.

Problem Constraints
1 <= A <= 10^5
1 <= M <= 2*10^5
1 <= B[i] <= 10^4
1 <= C[i][0], C[i][1] <= A
1 <= D <= 10^9

Input Format
The first argument given is an integer A.
The second argument given is an integer array B.
The third argument given is a matrix C.
The fourth argument given is an integer D.

Output Format
Return the number of batches selected in IB.

Example Input
Input 1:
 A = 7
 B = [1, 6, 7, 2, 9, 4, 5]
 C = [  [1, 2]
        [2, 3] 
       `[5, 6]
        [5, 7]  ]
 D = 12
Input 2:
 A = 5
 B = [1, 2, 3, 4, 5]
 C = [  [1, 5]
        [2, 3]  ]
 D = 6

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 Initial Batches :
    Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
    Batch 2 = {4} Batch Strength = 2
    Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
    Selected Batches are Batch 1 and Batch 2.
Explanation 2:
 Initial Batches :
    Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
    Batch 2 = {2, 3} Batch Strength = 5
    Batch 3 = {4} Batch Strength = 4  
    Selected Batch is only Batch 1.
*/
public class Batches {
    static int[] parent;
    // int[] height;
    static int find_root(int node)
    {
        if(node == parent[node])
            return node;
        parent[node] = find_root(parent[node]);
        return parent[node];
    }
    static boolean union_edge(int x,int y)
    {
        int r1 = find_root(x);
        int r2 = find_root(y);

        if(r1 == r2)
            return false;
        parent[r1] = r2;
        return true;
    }
    public static int solve(int A, int[] B, int[][] C, int D) {
        parent = new int[A+1];
        // height = new int[A+1];
        // Arrays.fill(heigh,0);
        for(int i = 1;i<=A;i++)
            parent[i] = i;
        for(int i = 0;i<C.length;i++)
        {
            boolean x = union_edge(C[i][0],C[i][1]);
        }
        
        int[] batch_strength = new int[A+1];
        for(int i = 1;i<parent.length;i++)
        {
            batch_strength[find_root(parent[i])] += B[i-1];
        }
        int count = 0;
        for(int i = 1;i<batch_strength.length;i++)
        {
            if(batch_strength[i] >= D)
                count++;
        }
        return count;
        
    }
    public static void main(String[] args) {
        int A = 9;
        int[] B = {10, 8, 2, 3, 4, 8, 3, 5, 9};
        int[][] C = {{1, 4},{1, 6},{2, 7},{2, 9},{3, 5},{3, 8},{4, 9},{5, 8},{6, 8}};
        int D = 25;
        System.out.println(solve(A,B,C,D));
    }
}
