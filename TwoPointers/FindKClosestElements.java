import java.util.*;
public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int index_x = 0;
        int minimum = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++)
        {
            if(minimum > Math.abs(arr[i]-x))
            {
                index_x = i;
                minimum = Math.abs(arr[i]-x);
            }
        }
        int first = index_x - 1;
        int second = index_x;
        int count = 0;
        while(count != k)
        {
            //System.out.println("FIRST: "+first+ " SECOND: "+second);
            if(first >= 0 && second<arr.length)
            {
                if(Math.abs(arr[first]-x) > Math.abs(arr[second]-x))
                {
                    result.add(arr[second]);
                    second++;
                }
                else
                {
                    result.add(arr[first]);
                    first--;
                }
            }
            else if(first >= 0)
            {
                result.add(arr[first]);
                first--;
            }
            else
            {
                result.add(arr[second]);
                second++;
            }
            count++;
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,5,5,5,8,9,9};
        int k = 4;
        int x = 0;
        System.out.println(findClosestElements(arr,k,x));
    }
}
