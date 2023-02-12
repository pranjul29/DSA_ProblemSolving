package Threads.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
    private List<Integer> arrayToSort;
    private ExecutorService executorService;
    public Sorter(List<Integer> arrayToSort, ExecutorService executorService)
    {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception
    {
        if(arrayToSort.size() <= 1)
            return arrayToSort;

        int mid = arrayToSort.size()/2;
        
        List<Integer> leftArrayToSort = new ArrayList<>();
        for(int i = 0;i<mid;i++)
            leftArrayToSort.add(arrayToSort.get(i));
        
        List<Integer> rightArrayToSort = new ArrayList<>();
        for(int i = mid;i<arrayToSort.size();i++)
            rightArrayToSort.add(arrayToSort.get(i));
        
        ExecutorService executor = executorService;

        Future<List<Integer>> sortedLeftArrayFuture = executor.submit(new Sorter(leftArrayToSort, executor)); // Non Blocking
        Future<List<Integer>> sortedRightArrayFuture = executor.submit(new Sorter(rightArrayToSort, executor));

        List<Integer> sortedArray = new ArrayList<>();

        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get(); // Blocking for the Results
        List<Integer> sortedRightArray = sortedRightArrayFuture.get(); // Blocking for the Results

        int left = 0;
        int right = 0;

        while(left < sortedLeftArray.size() && right < sortedRightArray.size())
        {
            if(sortedLeftArray.get(left) < sortedRightArray.get(right))
            {
                sortedArray.add(sortedLeftArray.get(left));
                left++;
            }
            else
            {
                sortedArray.add(sortedRightArray.get(right));
                right++;
            }
        }

        while(left < sortedLeftArray.size())
        {
            sortedArray.add(sortedLeftArray.get(left));
            left++;
        }
        while(right < sortedRightArray.size())
        {
            sortedArray.add(sortedRightArray.get(right));
            right++;
        }

        return sortedArray;
    }
}
