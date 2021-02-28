package testApp;

public class Test {
    int counter = 0;

    synchronized void get() throws InterruptedException {
        while(counter>6) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(150);
        System.out.println("положили 1");
        counter++;
        notify();
    }

    synchronized void put() throws InterruptedException {
        while (counter<1) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        Thread.sleep(100);
        System.out.println("забрали 1");
        counter--;
        notify();
    }

}
