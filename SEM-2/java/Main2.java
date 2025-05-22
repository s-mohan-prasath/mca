
class Main2 {
    static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("Customer");
            synchronized (Main2.class) {
                while (!flag) {
                    System.out.println(Thread.currentThread().getName() + " I am waiting");
                    try {
                        Main2.class.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " : Got! the lock");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (Main2.class) {
                Thread.currentThread().setName("Waiter");
                System.out.println(Thread.currentThread().getName() + "I am gonna signal monitor relase notification in 2 seconds");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                flag = true;
                Main2.class.notify();
            }
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
    }
}