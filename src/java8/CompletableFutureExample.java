package java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {

    public static void main(String[] args) throws Exception{
        CompletableFutureExample test = new CompletableFutureExample();

        Future<String> future =  test.calculateAsyncWithCancellation();
        //future.get();

        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Hello");



        future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World");

        CompletableFuture future3 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));

        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
                    String name = "vikash";
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

    }


    public  Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        //completableFuture.

        return completableFuture;
    }

    public Future<String> calculateAsyncWithCancellation() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return null;
        });

        return completableFuture;
    }
}
