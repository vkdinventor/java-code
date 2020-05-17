package thread;

/**
 * https://www.baeldung.com/java-even-odd-numbers-with-2-threads
 * // Using wait and notify
 */
public class EvenOddThreadExample {

    public static void main(String[] args) throws Exception {

        Producer producer = new Producer(10);
        Thread threadEven = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer.evenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer.oddProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadEven.start();
        threadOdd.start();

    }
}


class Producer {

    int even = 0;
    int odd = 1;
    int limit = 0;
    boolean isOdd = false;

    public Producer(int limit) {
        this.limit = limit;
    }

    public void evenProducer() throws InterruptedException {
        while (even <= limit) {
            synchronized (this) {
                if (isOdd){
                    wait();
                }
                System.out.println("Even: " + even);
                even += 2;
                isOdd = true;
                notify();
            }
        }
    }

    public void oddProducer() throws InterruptedException{
        Thread.sleep(1000);
        while (odd <= limit) {
            synchronized (this) {
                /* this also works. It is recommended to use while to avoid spurious wake up
                while(!isOdd){
                    wait();
                }
                */
                if (!isOdd){
                    wait();
                }
                System.out.println("Odd : " + odd);
                odd += 2;
                isOdd = false;
                notify();
            }
        }
    }
}
