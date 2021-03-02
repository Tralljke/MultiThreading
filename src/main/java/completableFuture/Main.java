package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();
        CompletableFuture<Integer> futureCount = createCompletableFuture();
        System.out.println("Took " + (System.currentTimeMillis() - started) + " milliseconds" );
        try {
            int count = futureCount.get();
            System.out.println("CompletableFuture took " + (System.currentTimeMillis() - started) + " milliseconds" );

            System.out.println("Result " + count);
        } catch (InterruptedException | ExecutionException ex) {
        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                        Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                    return 42;
                });
    }


}
