package interrupt;

public class Main {
    public static void main(String[] args) {
        System.out.println("НАЧАЛО");

        Thread t = new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + " запустился");
            int k = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(k++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " закончился");
        });
        t.start();

        try {
           Thread.sleep(600);
           t.interrupt();
           Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("КОНЕЦ");
    }
}
