package countDownLatch;

import java.util.concurrent.CountDownLatch;

/** countDownLatch - самоблокировка с обратным отсчетом событий которые должны произойти.
 *
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);

        System.out.println("Начали");

        new Thread(()-> {
            for(int i = 0; i<2; i++) {
                System.out.println(i);
                count.countDown();
            }
       }).start();
        new Thread(()-> {
            for(int i = 0; i<2; i++) {
                System.out.println(i);
                count.countDown();
            }
        }).start();
        new Thread(()-> {
            for(int i = 0; i<2; i++) {
                System.out.println(i);
                count.countDown();
            }
        }).start();
        count.await();
        System.out.println("Закончили");
    }

}
