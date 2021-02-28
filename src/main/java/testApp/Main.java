package testApp;



public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()-> {
            while (true) {
                try {
                    test.put();
                    System.out.println(test.counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    test.get();
                    System.out.println(test.counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
