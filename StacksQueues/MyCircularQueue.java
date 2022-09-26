class CircularQueue {
    int[] queue;
    int front;
    int rear;
    int size;
    public CircularQueue(int k) {
        queue = new int[k];
        size = 0;
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(size == queue.length)
            return false;
        if(size == 0)
            front = 0;
        rear++;
        rear = rear%(queue.length);
        queue[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0)
            return false;
        front++;
        front = front%(queue.length);
        size--;
        if(size == 0)
        {
            front = -1;
            rear = -1;
        }
        return true;
    }
    
    public int Front() {
        if(size == 0)
            return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(size == 0)
            return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == queue.length)
            return true;
        return false;
    }
}
public class MyCircularQueue{
    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}
