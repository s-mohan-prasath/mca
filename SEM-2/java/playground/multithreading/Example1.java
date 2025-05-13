package multithreading;

public class Example1 {
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        t1.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running...");
    }
}