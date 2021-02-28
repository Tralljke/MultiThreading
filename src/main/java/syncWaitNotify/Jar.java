package syncWaitNotify;

public class Jar {

    private int product = 0;

    synchronized void put() {
        while(product>=3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + " положил товар");
        System.out.println(product);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    synchronized void get() {
        while(product<1) { // наличие хотя бы 1 товара
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}
