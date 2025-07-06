import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ESystem {
    public static int floorCount = 5;
    public static Queue<Person>[] upQ, downQ,outQ;
    private static Lift lift;
    public static boolean isPeopleAvailable;

    public ESystem() {
        upQ = new Queue[floorCount];
        downQ = new Queue[floorCount];
        outQ = new Queue[floorCount];

        for (int i = 0; i < floorCount; i++) {
            upQ[i] = new LinkedList<>();
            downQ[i] = new LinkedList<>();
            outQ[i] = new LinkedList<>();
        }

        lift = new Lift(500, upQ, downQ);

        Scanner scan = new Scanner(System.in);
        Queue<Person> inQ = new LinkedList<>();

        while (true) {
            System.out.println("ENTER PEOPLE INTO THE SYSTEM [format: name_start_end_weight], 'q' to start simulation:");
            String line;
            while (!(line = scan.nextLine()).equals("q")) {
                try {
                    String[] arr = line.split("_");
                    Person p = new Person(arr[0],
                            Integer.parseInt(arr[1]),
                            Integer.parseInt(arr[2]),
                            Float.parseFloat(arr[3]));
                    inQ.offer(p);
                } catch (Exception e) {
                    System.out.println("Invalid input format. Try again.");
                }
            }
            while (!inQ.isEmpty()) {
                addPeopleToQueue(inQ.poll());
            }

            synchronized (ESystem.class) {
                isPeopleAvailable = true;
                ESystem.class.notifyAll(); // Wake up lift thread
            }
        }
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized static void addPeopleToQueue(Person p) {
        if (lift.direction == Lift.Direction.UP) {
            if (p.getStartFloor() >= lift.currentFloor && p.getEndFloor() > lift.currentFloor) {
                upQ[p.getStartFloor()].offer(p);
            } else {
                downQ[p.getStartFloor()].offer(p);
            }
        } else if (lift.direction == Lift.Direction.DOWN) {
            if (p.getStartFloor() <= lift.currentFloor && p.getEndFloor() < lift.currentFloor) {
                downQ[p.getStartFloor()].offer(p);
            } else {
                upQ[p.getStartFloor()].offer(p);
            }
        } else {
            // Lift is IDLE: decide direction based on position
            if (p.getStartFloor() < lift.currentFloor) {
                lift.direction = Lift.Direction.DOWN;
                downQ[p.getStartFloor()].offer(p);
            } else {
                lift.direction = Lift.Direction.UP;
                upQ[p.getStartFloor()].offer(p);
            }
        }
        lift.maxUpFloor = max(lift.maxUpFloor, p.getStartFloor(), p.getEndFloor());
        lift.minDownFloor = min(lift.minDownFloor, p.getStartFloor(), p.getEndFloor());
    }

    public synchronized static void checkPeopleAvailable() {
        boolean availability = false;
        for (Queue<Person> q : upQ) {
            if (!q.isEmpty()) {
                availability = true;
                break;
            }
        }
        if (!availability) {
            for (Queue<Person> q : downQ) {
                if (!q.isEmpty()) {
                    availability = true;
                    break;
                }
            }
        }
        if(!availability) {
            for (Queue<Person> q : outQ) {
                if (!q.isEmpty()) {
                    availability = true;
                    break;
                }
            }
        }
        synchronized (ESystem.class) {
            isPeopleAvailable = availability;
        }
    }

    // --- Utility Functions ---
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void makePeopleAvailable() {
        isPeopleAvailable = true;
    }

    public static void makePeopleNotAvailable() {
        isPeopleAvailable = false;
    }
}
