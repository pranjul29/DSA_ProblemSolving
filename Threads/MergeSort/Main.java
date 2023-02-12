package Threads.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        List<Integer> arraytToSort = List.of(4,2,6,1,9,3,4,2);

        ExecutorService executorService = Executors.newCachedThreadPool();
        
        List<Integer> sortedArray = executorService.submit(
            new Sorter(arraytToSort, executorService)
        ).get();

        for(int i : sortedArray)
            System.out.println(i);
        
        executorService.shutdown();
    }
}
