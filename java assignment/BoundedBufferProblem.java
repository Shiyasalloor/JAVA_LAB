import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BoundedBuffer {
    private BlockingQueue<Integer> buffer;

    public BoundedBuffer(int capacity) {
        buffer = new ArrayBlockingQueue<>(capacity);
    }

    public void produce(int item) throws InterruptedException {
        buffer.put(item);
        System.out.println("Produced: " + item);
    }

    public void consume() throws InterruptedException {
        int item = buffer.take();
        System.out.println("Consumed: " + item);
    }
}

class Producer extends Thread {
    private BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                sleep(1000); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BoundedBufferProblem {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(2);

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
