/*
Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.

A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.

In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
In the third go, he/she alters the states of doors numbered 3, 6, 9 …
This continues till the A'th go in, which you alter the state of the door numbered A.

Find and return the number of open doors at the end of the procedure.

Problem Constraints
1 <= A <= 10^9

Example Input
Input 1:
 A = 5
Input 2:
 A = 6

Example Output
Output 1:
 2
Output 2:
 2 
*/
public class NumberOfOpenDoors {
    // Can also Try with Perfect Square, Number that Are Perfect Square have ODD number of Factors that means door is open
    public static int solve(int A) {
        int count = 1;
        int increment = 2;
        int i = 1;
        while(true)
        {
            i = i + increment+1;
            System.out.println("i: "+i);
            if(i <=A)
                count++;
            else
                break;
            increment = increment + 2;
            System.out.println("increment: "+increment);
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println(solve(100));
    }
}
