package join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
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
    }
}


