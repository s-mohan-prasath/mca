

public class Main {
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        try {
            runner r1 = new runner("Thread1");
            runner r2 = new runner("Thread2");
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            t1.start();
            t2.start();
            Thread.sleep(1000);
            t1.interrupt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                System.out.println("Interrupted while sleeping for "+i+" seconds");
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