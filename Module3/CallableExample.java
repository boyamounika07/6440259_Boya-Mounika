import java.util.*;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            final int id = i;
            tasks.add(() -> {
                Thread.sleep(500); // simulate work
                return "Result from task " + id;
            });
        }

        List<Future<String>> futures = executor.invokeAll(tasks);

        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        executor.shutdown();
    }
}
