/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/24899/homework/problems/12780/?navref=cl_pb_nv_tb
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise. 
*/
// public class Main {
//     public static void main(String[] args) {
        
//     }
    
//     // This is the interface that allows for creating nested lists.
//     // You should not implement it, or speculate about its implementation.
//     class NestedInteger {
        
//         NestedInteger(int x) {
//         }
        
//         // Return true if this NestedInteger holds a single integer, rather than a nested list.
//         boolean isInteger() {
//         }

//         // Return the single integer that this NestedInteger holds, if it holds a single integer.
//         // The result is 1e9 if this NestedInteger holds a nested list.
//         int getInteger() {
            
//         }

//         // Return the nested list that this NestedInteger holds, if it holds a nested list.
//         // The result is an empty ArrayList if this NestedInteger holds a single integer.
//         ArrayList<NestedInteger> getList() {
            
//         }
//     }
import java.util.*;
class NestedIterator {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int c = 0;
    int size = 0;
        NestedIterator(ArrayList<NestedInteger> nestedList) {
            findList(nestedList);
            size = ans.size();
        }

        void findList(ArrayList<NestedInteger> nestedList)
        {
            for(int i = 0;i<nestedList.size();i++)
            {
                if(nestedList.get(i).isInteger())
                {
                    ans.add(nestedList.get(i).getInteger());
                }
                else
                {
                    findList(nestedList.get(i).getList());
                }
            }
        }

        int next() {
            int temp = ans.get(c);
            c++;
            return temp;
        }

        boolean hasNext() {
            if(c == size)
                return false;
            else
                return true;
        }
    }