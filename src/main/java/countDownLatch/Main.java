package countDownLatch;

import java.util.concurrent.CountDownLatch;

/** countDownLatch - самоблокировка с обратным отсчетом событий которые должны произойти.
 *
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(5);

        System.out.println("Начали");

        new Thread(()-> {
            for(int i = 0; i<5; i++) {
                System.out.println(i);
                count.countDown();
            }
       }).start();
        count.await();
        System.out.println("Закончили");
    }

}
