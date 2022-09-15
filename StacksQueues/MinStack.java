/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34909/assignment/problems/52/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/min-stack/
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.
Problem Constraints

1 <= Number of Function calls <= 10^7

Example Input
Input 1:
push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()
Input 2:
getMin()
pop()
top()
Example Output
Output 1:
 -2 1 2
Output 2:
 -1 -1
Example Explanation
Explanation 1:
Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.
Explanation 2:
Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.
*/
class Node{
    int val;
    int min;
    Node next;
    Node(int val,int min)
    {
        this.val = val;
        this.min = min;
    }
}
public class MinStack {
    Node top;
    int min = -1;
    int size = 0;
    public void push(int x) {
        Node newNode;
        if(size == 0)
        {
            newNode = new Node(x,-1);
        }
        else
        {
            newNode = new Node(x,min);
        }
        newNode.next = top;
        top = newNode;
        size++;
        if(size == 1)
        {
            min = x;
        }
        else
        {
            min = Math.min(x,min);
        }
    }

    public void pop() {
        if(size == 0)
            return;
        Node temp = top;
        if(min == temp.val)
        {
            min = temp.min;
        }
        top = top.next;
        size--;
    }

    public int top() {
        if(size == 0)
            return -1;
        else
            return top.val;
    }

    public int getMin() {
        if(size == 0)
            return -1;
        else
            return min;
    }
}
