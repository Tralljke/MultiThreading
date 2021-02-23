package reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int counter = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();


        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        counter = 1;
                        for (int i = 1; i < 5; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + counter);
                            counter++;
                            Thread.sleep(300);
                        }
                    } catch (InterruptedException e) {
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
