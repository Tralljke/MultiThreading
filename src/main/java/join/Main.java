package join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       /* for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("HALO " + finalI);
                System.out.println("Nope");
                System.out.println("HOPE0");
                int s = 0;
                s++;
                System.out.println(s);
            }).start();
        }
        */
        Thread thirdThread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " started");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });
        thirdThread.setName("Thread №3");

        Thread secondThread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " started");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });
        secondThread.setName("Thread №2");



        Thread firstThread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " started");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });
        firstThread.setName("Thread №1");


        firstThread.start();
        firstThread.join();
        secondThread.start();
        secondThread.join();
        thirdThread.start();
        thirdThread.join();

    }
}


