import java.lang.*;

class ThreadDemo implements Runnable {
    Thread t;
    ThreadDemo( String str ) {
        t = new Thread(this, str);
        t.start();
    }

    public void run() {
        for(int i=0; i < 5; i++) {
            if(i % 5 == 0)
            {
                System.out.println(Thread.currentThread().getName() + " yielding control... ");

                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

//    public static void main(String[] args) {
//        new ThreadDemo("Thread 1");
//        new ThreadDemo("Thread 4");
 //       new ThreadDemo("Thread 3");
 //   }
}

class YieldExample
{
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

        producer.start();
        consumer.start();

    }
}

class Producer extends Thread {
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.println("I am producer  : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread {
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed item " + i);
            Thread.yield();
        }
    }
}

