package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {

        int duration = (int) (Math.random() * 1000);
        return String.format("Task duration was %s ms, execution finished at %s",
                duration,
                LocalTime.now());
    }
}
