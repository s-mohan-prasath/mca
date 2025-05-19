
import java.math.BigInteger;

public class exercise16 {
    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        System.out.println("factorial of " + n + " is " + fact(n));

        int x1 = 5, y1 = 4, z1 = 3;
        Producer x = new Producer(x1);
        Producer y = new Producer(y1);
        Producer z = new Producer(z1);

        Thread t1 = new Thread(x);
        Thread t2 = new Thread(y);
        Thread t3 = new Thread(z);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        System.out.println("Factorial of " + x1 + " is " + x.getOutput());
        t2.join();
        System.out.println("Factorial of " + y1 + " is " + y.getOutput());
        t3.join();
        System.out.println("Factorial of " + z1 + " is " + z.getOutput());

        BigInteger output = BigInteger.ZERO;
        output = output.add(x.getOutput());
        output = output.add(y.getOutput());
        output = output.add(z.getOutput());
        System.out.println(output);
    }

    // PROGRAM 1
    public static BigInteger fact(int n) {
        BigInteger num = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }
        return num;
    }
}

class Producer implements Runnable {
    int n;
    BigInteger output;

    public Producer(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        output = exercise16.fact(n);
    }

    public BigInteger getOutput() {
        return output;
    }

}