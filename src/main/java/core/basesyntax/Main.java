package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Callable<String> callable = new MyThread();
            List<Future<String>> futures = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Future<String> future = executorService.submit(callable);
                futures.add(future);
            }
            executorService.shutdown();
            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
