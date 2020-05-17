package thread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceTest {

    public static void main(String[] args){

        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Core size is :"+core);

        Executor exe = Executors.newFixedThreadPool(core);
        Runnable runnable = () -> {
            for (int i=0; i<100; i++) {
                List<Integer> list = IntStream.range(1,1000).boxed().collect(Collectors.toList());
                Collections.shuffle(list);
                Collections.sort(list);
            }
            System.out.println(Thread.currentThread().getName());
        };

        for(int i=0; i < 10000; i++){
            exe.execute(runnable);
        }
    }
}
