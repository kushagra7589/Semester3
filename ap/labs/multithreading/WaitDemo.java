import java.util.*;
class Producer implements Runnable 
{
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> sharedQueue, int size)
    {
        this.taskQueue = sharedQueue;
        this.MAX_CAPACITY = size;
    }

    public void run()
    {
        int counter = 0;
        while(true)
        {
            try
            {
                produce(counter++);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }   

    private void produce(int i) throws InterruptedException 
    {
        synchronized(taskQueue)
        {
            while(taskQueue.size() == MAX_CAPACITY)
            {
                System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting, size = " + taskQueue.size());
                taskQueue.wait();
            }
            taskQueue.add(i);
            System.out.println("Produced: " + i);
            taskQueue.notifyAll();
            Thread.sleep(3000);
        }
    }
}

class Consumer implements Runnable
{
    private final List<Integer> taskQueue;

    public Consumer(List<Integer> sharedQueue)
    {
        this.taskQueue = sharedQueue;
    }


    public void run()
    {
        while(true)
        {
            try
            {
                consume();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException
    {
        synchronized(taskQueue)
        {
            while(taskQueue.isEmpty())
            {
                System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting, size =  " + taskQueue.size());
                taskQueue.wait();
            }

            Thread.sleep(1000);
            int i = taskQueue.remove(0);
            System.out.println("Consumed = " + i);
            taskQueue.notifyAll();
        }
    }
}

public class WaitDemo 
{
    public static void main(String[] args)
    {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread tProducer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue), "Consumer");
        tProducer.setPriority(Thread.MIN_PRIORITY);
        tConsumer.setPriority(Thread.MAX_PRIORITY);
        tProducer.start();
        tConsumer.start();
    }
}


        
