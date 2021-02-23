package syncCounter;
/**
 Метод main, где можно посмотреть, как работает синхронизация по методу add.
 **/
public class Main {
    static int counter = 0;
    static volatile boolean finish = false;
    static volatile boolean finish1 = false;

    public synchronized static void add() {
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200_000; i++) {
                    add();
                }
                finish = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200_000; i++) {
                    add();
                }
                finish1 = true;
            }
        }).start();

        while (!finish || !finish1);

        System.out.println(counter);

    }
}
