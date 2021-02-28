package notifyAll;

import java.util.concurrent.BlockingQueue;

public class MyRunnable implements Runnable {
    private final Object lock;
    private final BlockingQueue<String> queue;

    public MyRunnable(Object lock, BlockingQueue<String> queue) {
        this.queue = queue;
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
                queue.put(Thread.currentThread().getName());
            } catch (InterruptedException ignore) {/*NOP*/}
        }
    }
}