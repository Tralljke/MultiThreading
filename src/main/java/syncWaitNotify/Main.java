package syncWaitNotify;

public class Main {
    public static void main(String[] args) {
        Jar jar = new Jar();
        Producer producer = new Producer(jar);
        Consumer consumer = new Consumer(jar);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
