
public class Main {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) throws InterruptedException {
        Bank.main(args);
    }
}

class Bank {
    static int balance = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            increment();
        });

        Thread t2 = new Thread(() -> {
            decrement();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(balance);
    }

    public static void increment() {
        synchronized (Bank.class) {
            balance++;
        }
    }

    public static synchronized void decrement() {
        synchronized (Bank.class) {
            balance--;
        }
    }
}

class runner implements Runnable {
    String name;

    public runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + " - " + i);
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted while sleeping for " + i + " seconds");
            }
        }
    }
}

class RunTask extends Thread implements Runnable {

    @Override
    public void run() {
        System.out.println("Hi");
    }

}