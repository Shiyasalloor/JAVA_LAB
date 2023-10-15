public class ThreadSynchronizationExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(new MyThread(sharedResource, "Thread 1"));
        Thread thread2 = new Thread(new MyThread(sharedResource, "Thread 2"));

        thread1.start();
        thread2.start();
    }
}

class SharedResource {
    private boolean flag = false;

    public synchronized void printEven(int number) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(number);
        flag = true;
        notify();
    }

    public synchronized void printOdd(int number) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(number);
        flag = false;
        notify();
    }
}

class MyThread implements Runnable {
    private final SharedResource sharedResource;
    private final String threadName;
    private static int count = 1;

    public MyThread(SharedResource sharedResource, String threadName) {
        this.sharedResource = sharedResource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (count <= 10) {
            if (threadName.equals("Thread 1")) {
                sharedResource.printEven(count);
            } else if (threadName.equals("Thread 2")) {
                sharedResource.printOdd(count);
            }
            count++;
        }
    }
}
