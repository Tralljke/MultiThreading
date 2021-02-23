package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 Метод main, где можно посмотреть, как работает BlockingQueue.
 Несколько потоков кладут в очередь данные, Один поток их забирает.
 **/

public class Main {

    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(32);

        for (int i = 0; i < 7; i++) {
            final int threadNumber = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int counter = 0;
                    while (true) {
                        try {
                            queue.put("elem-" + threadNumber + "/" + ++counter);
                            System.out.println(Thread.currentThread().getName() + " put: " + counter);
                        } catch (InterruptedException ignore) { }
                    }
                }
            }).start();
        }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(300);
                            String data = queue.take();
                            System.out.println(Thread.currentThread().getName() + " take: " + data);
                            System.out.println("Элементов в очереди " + queue.size());
                        } catch (InterruptedException ignore) {
                        }
                    }
                }
            }).start();
        }

}
