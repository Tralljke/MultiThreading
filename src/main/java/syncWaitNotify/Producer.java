package syncWaitNotify;

public class Producer implements Runnable {
    Jar jar;

    Producer(Jar jar) {
        this.jar = jar;
    }

    @Override
    public void run() {
        while (true) {
            jar.put();
        }
    }
}
