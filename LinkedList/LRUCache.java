/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29524/homework/problems/239/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/lru-cache/
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :
Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
*/
import java.util.*;
class DoubleListNode{
    int key;
    int val;
    DoubleListNode next;
    DoubleListNode prev;
    DoubleListNode(int x, int y) {
        key = x;
        val = y;
        next = prev = null;
    }
}
class Solution {
DoubleListNode head;
DoubleListNode tail;
HashMap<Integer,DoubleListNode> reference = new HashMap<>();
int maximum_capacity;
    public Solution(int capacity) {
        maximum_capacity = capacity;
        head = new DoubleListNode(-1,-1);
        tail = new DoubleListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void remove(DoubleListNode X)
    {
        X.prev.next = X.next;
        X.next.prev = X.prev;
        X.next = null;
        X.prev = null;
    }
    public void AddToTail(DoubleListNode X)
    {
        X.next = tail;
        tail.prev.next = X;
        X.prev = tail.prev;
        tail.prev = X;
    }
    public int get(int key) {
        if(reference.containsKey(key))
        {
            DoubleListNode temp = reference.get(key);
            remove(temp);
            AddToTail(temp);
            return temp.val;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(reference.containsKey(key))
        {
            DoubleListNode X = reference.get(key);
            remove(X);
            DoubleListNode newNode = new DoubleListNode(key,value);
            AddToTail(newNode);
            reference.put(key,newNode);
        }
        else
        {
            if(reference.size() == maximum_capacity)
            {
                DoubleListNode X = head.next;
                remove(X);
                reference.remove(X.key);
            }
            DoubleListNode newNode = new DoubleListNode(key,value);
            AddToTail(newNode);
            reference.put(key,newNode);
        }
    }
}
public class LRUCache
{
    public static void main(String[] args) {
        Solution s = new Solution(1);
        s.set(2, 1);
        s.set(2, 2);
        System.out.println(s.get(2));
        s.set(1, 1);
        s.set(4, 1);
        System.out.println(s.get(2));
    }
}
