/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29524/homework/problems/41/?navref=cl_pb_nv_tb
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
You should preserve the original relative order of the nodes in each of the two partitions.

Problem Constraints
1 <= |A| <= 10^6
1 <= A[i], B <= 10^9

Example Input
Input 1:
A = [1, 4, 3, 2, 5, 2]
B = 3
Input 2:
A = [1, 2, 3, 1, 3]
B = 2

Example Output
Output 1:
[1, 2, 2, 4, 3, 5]
Output 2:
[1, 1, 2, 3, 3]

Example Explanation
Explanation 1:
 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
Explanation 2:
 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.
*/
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(){}
}
public class PartitionList {
    public static ListNode partition(ListNode A, int B) {
        ListNode temp = A;
        ListNode prev = null;
        if(temp.val >= B)
        {
            while(temp!=null)
            {
                if(temp.val < B)
                {
                    prev.next = temp.next;
                    temp.next = A;
                    A = temp;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
        }
        temp = A;
        ListNode curr = A;
        prev = null;
        System.out.println(temp.val);
        System.out.println(curr.val);
        System.out.println(prev);
        while(curr!=null)
        {
            if(curr == temp)
            {
                prev = curr;
                curr = curr.next;
                continue;
            }
            System.out.println(temp.val);
            System.out.println(curr.val);
            if(prev!=null)
                System.out.println(prev.val);
            else
                System.out.println(prev);
            if(curr.val < B)
            {
                System.out.println("HERE");
                prev.next = curr.next;
                curr.next = temp.next;
                temp.next = curr;
                temp = temp.next;
                curr = prev.next;
            }
            prev = curr;
            if(curr!=null)
                curr = curr.next;
        }
        return A;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode();
            ListNode temp = head;
            int[] arr = {5,4,3,2,1};
            int count = 0;
            while(count<arr.length)
            {
                temp.val = arr[count];
                count++;
                if(count == arr.length)
                    break;
                else
                    temp.next = new ListNode();
                temp = temp.next;
            }
            head = partition(head,3);
            temp = head;
            if(head == null)
                return;
            while(temp.next!=null)
            {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.print(temp.val);
            System.out.println();
    }
}
