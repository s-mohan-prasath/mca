public class nine_five_2025 {
    public static void main(String[] args) {
        Fib fib = new Fib(10);
        Fact fact = new Fact(10);
        fib.start();
        fact.start();
    }
}

class Fact extends Thread {
    int n;

    public Fact(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if (n == 0 || n == 1)
            System.out.println(1);
        else {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
        }
    }
}

class Fib extends Thread {
    int n;

    public Fib(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if (n < 1)
            return;
        int x1 = 0;
        int x2 = 1;
        if (n == 1)
            System.out.println(x1);
        else if (n == 2)
            System.out.println(x2);
        else {
            int temp = 0;
            for (int i = 3; i <= n; i++) {
                temp = x1 + x2;
                x1 = x2;
                x2 = temp;
            }
            System.out.println(temp);
        }
    }
}