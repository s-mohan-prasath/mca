public class Main {
    public static void main(String[] args) {
        thread t = new thread("Chrome");
        t.start();
    }
}

public class thread extends Thread {
    public thread(String A) {
        System.out.println("Thread " + A + " created");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(500);
                System.out.println("Thread is running! (iteration - " + i + ")");
            }
        } catch (InterruptedException ex) {
            System.out.println("Sleeping is failed");
        }
    }
}