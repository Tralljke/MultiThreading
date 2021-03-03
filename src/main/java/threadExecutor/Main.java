package threadExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int NTHREDS = 17;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = Executors.newFixedThreadPool(NTHREDS);

        Counter counter = new Counter();
        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }
        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println("Executed by" + (System.nanoTime() - start) / (1000_000_000) + " s" + "value : " + value);

        threadPool.shutdown();

    }


    public static class Counter {

        public Double count(double a) {
            for (int i = 0; i < 1000000; i++) {
                a = a + Math.tan(a);
            }

            return a;
        }
    }
}
