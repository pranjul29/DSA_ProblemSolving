/*
Given an integer array nums, handle multiple queries of the following types:

1) Update the value of an element in nums.
2) Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

1) NumArray(int[] nums) Initializes the object with the integer array nums.
2) void update(int index, int val) Updates the value of nums[index] to be val.
3) int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]

Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

Constraints:

1) 1 <= nums.length <= 3 * 10^4
2) -100 <= nums[i] <= 100
3) 0 <= index < nums.length
4) -100 <= val <= 100
5) 0 <= left <= right < nums.length
6) At most 3 * 10^4 calls will be made to update and sumRange.
*/

class NumArray {

    private int[] nums;
    private int len;
    private int[] blocks;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        len = (int)Math.ceil(Math.sqrt(nums.length));
        blocks = new int[len];
        for(int i = 0;i<nums.length;i++)
        {
            blocks[i/len] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        blocks[index/len] +=  (val-nums[index]);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        if(right-left+1 <= len)
        {
            for(int i = left;i<=right;i++)
                sum+=nums[i];
            return sum;
        }
        while(left<right && left%len != 0 )
        {
            sum += nums[left];
            left++;
        }
        while(right>=left && (right+1)%len!=0)
        {
            sum+= nums[right];
            right--;
        }
        for(int i = left;i<right;i=i+len)
        {
            sum += blocks[i/len];
        }
        return sum;   
    }
}

public class RangeSumQueryMutable {
    public static void main(String[] args)
    {
        int[] arr = {1,3,5};
        NumArray obj = new NumArray(arr);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}
