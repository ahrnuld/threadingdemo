package nl.inholland;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorParallelDemo {
    private int counter = 0;

    private void incrementAndPrint() {
        counter++;
        System.out.println(Thread.currentThread().getName() + ", " + counter);
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            ExecutorParallelDemo scratch = new ExecutorParallelDemo();
            for (int i = 0; i < 10; i++) {
                service.submit(scratch::incrementAndPrint);
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
