/*
Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:
insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.
Note:
If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in a new line.

Problem Constraints
1 <= value <= 10^5
1 <= position <= n where, n is the size of the linked-list.

Example Input
5
i 1 23
i 2 24
p
d 1
p

Example Output
23 24
24

Example Explanation
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
*/
static class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class LinkedList {
    public static Node head = null;
    public static int length = 0;
        public static void insert_node(int position, int value) {
            // @params position, integer
            // @params value, integer
            if(position == 1)
            {
                Node NewNode = new Node(value);
                NewNode.next = head;
                head = NewNode;
                length++;
                return;
            }
            if(position > length+1)
            {
                return;
            }
            Node temp = head;
            for(int i = 1;i<position-1;i++)
            {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            
        }

        public static void delete_node(int position) {
            // @params position, integer
            if(position > length)
            {
                return;
            }
            if(position == 1)
            {
                head = head.next;
                length--;
                return;
            }
            else
            {
                Node temp = head;
                for(int i = 1;i<position-1;i++)
                {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                length--;
            }
        }

        public static void print_ll() {
            // Output each element followed by a space
            Node temp = head;
            if(head == null)
                return;
            while(temp.next!=null)
            {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print(temp.val);
        }
}
