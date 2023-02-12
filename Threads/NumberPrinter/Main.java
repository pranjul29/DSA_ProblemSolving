package Threads.NumberPrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World " + Thread.currentThread().getName());
        for(int i = 1;i<=100;i++)
        {
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }
        
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
