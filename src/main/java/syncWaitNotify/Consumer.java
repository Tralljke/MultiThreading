package syncWaitNotify;

public class Consumer implements Runnable {
    Jar jar;

    Consumer(Jar jar) {
        this.jar = jar;
    }

    @Override
    public void run() {
        while(true) {
            jar.get();
        }
    }
}
