public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        final int count = 100_000;

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // minimal work
                // System.out.println("Virtual thread running");
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Launched and joined " + count + " virtual threads in " + (end - start) + " ms");
    }
}
