class MessageThread extends Thread {
    private String message;

    MessageThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message + " - " + (i+1));
            try {
                Thread.sleep(500); // 0.5 seconds pause
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new MessageThread("Thread 1 message");
        Thread t2 = new MessageThread("Thread 2 message");

        t1.start();
        t2.start();
    }
}
