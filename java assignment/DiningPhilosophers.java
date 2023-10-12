import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private Semaphore leftChopstick;
    private Semaphore rightChopstick;
    private int id;

    public Philosopher(Semaphore leftChopstick, Semaphore rightChopstick, int id) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        leftChopstick.acquire();
        rightChopstick.acquire();

        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));

        rightChopstick.release();
        leftChopstick.release();
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Semaphore[] chopsticks = new Semaphore[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            Semaphore leftChopstick = chopsticks[i];
            Semaphore rightChopstick = chopsticks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick, i);
            philosophers[i].start();
        }
    }
}
