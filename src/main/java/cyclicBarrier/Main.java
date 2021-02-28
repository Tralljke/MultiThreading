package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** CyclicBarrier - позволяет определить объект синхронихации который приостанавливается до тех пор
 * пока определенное колличество потоков исполнения не достигнет некоторой барьерной точки.
 */

public class Main {


    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Thread(()->{
            System.out.println("Барьер достигнут");
        }));
        System.out.println("Начали");

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
