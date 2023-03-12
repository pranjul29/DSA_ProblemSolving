import java.util.*;
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        int add = 1;
        for(int i = digits.length-1;i>=0;i--)
        {
            int curr = digits[i] + carry + add;
            add = 0;
            result.add(0,curr%10);
            carry = curr/10;
        }
        if(carry>0)
            result.add(0,carry);
        int[] result_arr = new int[result.size()];
        int counter = 0;
        for(int i : result)
        {
            result_arr[counter] = i;
            counter++;
        }
        return result_arr;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(plusOne(digits));
    }
}
