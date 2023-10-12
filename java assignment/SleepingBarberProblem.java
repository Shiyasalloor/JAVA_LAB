import java.util.concurrent.Semaphore;

class BarberShop {
    private int waitingCustomers = 0;
    private Semaphore barber = new Semaphore(0);
    private Semaphore customer = new Semaphore(0);
    private Semaphore accessSeats = new Semaphore(1);

    public void barber() {
        try {
            while (true) {
                System.out.println("Barber is sleeping.");
                customer.acquire(); 
                accessSeats.acquire();
                waitingCustomers--;
                System.out.println("Barber is cutting hair.");
                accessSeats.release();
                barber.release();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void customer() {
        try {
            accessSeats.acquire();
            if (waitingCustomers < 3) {
                waitingCustomers++;
                System.out.println("Customer arrived and takes a seat.");
                customer.release(); 
                accessSeats.release();
                barber.acquire(); 
            } else {
                System.out.println("Customer arrived but all seats are occupied. Leaving.");
                accessSeats.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class SleepingBarberProblem {
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();

        Thread barberThread = new Thread(barberShop::barber);
        Thread customerThread = new Thread(() -> {
            while (true) {
                barberShop.customer();
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        barberThread.start();
        customerThread.start();
    }
}
