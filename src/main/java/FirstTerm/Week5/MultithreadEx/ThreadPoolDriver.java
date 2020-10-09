package FirstTerm.Week5.MultithreadEx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDriver {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread();
            executor.execute(worker);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        System.out.println("Finishing all threads");
    }
}
