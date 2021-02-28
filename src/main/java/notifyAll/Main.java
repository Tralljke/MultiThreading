package notifyAll;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static Object lock = new Object();
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            new Thread(new MyRunnable(lock, queue), "" + k).start();
            Thread.sleep(100);
        }

        Thread.sleep(100);

        for (int k = 0; k < 10; k++) {
            synchronized (lock) {
                lock.notify();
            }
            System.out.print(" " + queue.take());
        }
        for (int k = 0; k < 10; k++) {
            System.out.print(" " + queue.take());
        }
    }
}
