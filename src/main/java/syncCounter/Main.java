package syncCounter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 Метод main, где можно посмотреть, как работает синхронизация по методу add.
 **/
public class Main {
    static AtomicInteger counter = new AtomicInteger(0);
    static volatile boolean finish = false;
    static volatile boolean finish1 = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 200_000; i++) {
                counter.addAndGet(1);
            }
            finish = true;
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 200_000; i++) {
                counter.addAndGet(1);
            }
            finish1 = true;
        }).start();

        while (!finish || !finish1);

        System.out.println(counter);

    }
}
