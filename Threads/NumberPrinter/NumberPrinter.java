package Threads.NumberPrinter;

public class NumberPrinter implements Runnable {
    private int num;
    public NumberPrinter(int num)
    {
        this.num = num;
    }
    @Override
    public void run()
    {
        System.out.println(num + " " + Thread.currentThread().getName());
    }
}
