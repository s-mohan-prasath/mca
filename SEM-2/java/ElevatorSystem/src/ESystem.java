import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class ESystem {
    public static int TOTAL_FLOORS = 4;
    public static Queue<Person>[] upQ, downQ,outQ;
    public static boolean isPeopleAvailable;

//    UI PARAMS
    private final JFrame frame;
    private final Building building;
    private final ControlPanel controlPanel;
    public Floor[] floors;
    static Lift lift;
    Timer elevatorTimer;

//    UI GLOBAL CONSTANTS

    public static int WINDOW_WIDTH;
    public static int WINDOW_HEIGHT;

    public static final int ELEVATOR_WIDTH = 80;
    public static final int ELEVATOR_HEIGHT = 80;
    public static float ELEVATOR_DOOR_SPEED = 0.0f;

    public static final int FLOOR_WIDTH = 600;
    public static final int FLOOR_HEIGHT = 150;
    public static int[] waitings = new int[TOTAL_FLOORS];

    public ESystem() throws InterruptedException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        WINDOW_WIDTH=dimension.width;
        WINDOW_HEIGHT=dimension.height;

        frame = new JFrame("Escalator System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ESystem.WINDOW_WIDTH, ESystem.WINDOW_HEIGHT);
        frame.setLayout(new BorderLayout());

        floors = new Floor[TOTAL_FLOORS];
        lift = new Lift(this);
        building = new Building(floors);
        controlPanel = new ControlPanel(this);

        building.add(lift,JLayeredPane.PALETTE_LAYER);

        frame.add(building,BorderLayout.WEST);
        frame.add(controlPanel,BorderLayout.EAST);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);

        upQ = new Queue[TOTAL_FLOORS];
        downQ = new Queue[TOTAL_FLOORS];
        outQ = new Queue[TOTAL_FLOORS];


        for (int i = 0; i < TOTAL_FLOORS; i++) {
            upQ[i] = new LinkedList<>();
            downQ[i] = new LinkedList<>();
            outQ[i] = new LinkedList<>();
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
        }
        else if (lift.direction == Lift.Direction.DOWN) {
            if (p.getStartFloor() <= lift.currentFloor && p.getEndFloor() < lift.currentFloor) {
                downQ[p.getStartFloor()].offer(p);
            } else {
                upQ[p.getStartFloor()].offer(p);
            }
        }
        else {
            // Lift is IDLE: decide direction based on position
            if (p.getStartFloor() < lift.currentFloor) {
                lift.direction = Lift.Direction.DOWN;
                downQ[p.getStartFloor()].offer(p);
            } else {
                lift.direction = Lift.Direction.UP;
                upQ[p.getStartFloor()].offer(p);
            }
        }
        lift.maxUpFloor = Utils.MAX(lift.maxUpFloor, p.getStartFloor(), p.getEndFloor());
        lift.minDownFloor = Utils.MIN(lift.minDownFloor, p.getStartFloor(), p.getEndFloor());
        isPeopleAvailable = true;
        ESystem.class.notifyAll(); // Wake up lift thread
    }
    public static int getYForFloor(int floor) {
        return (TOTAL_FLOORS - floor) * FLOOR_HEIGHT; // floor 0 is bottom, 4 is top
    }
    public static int getFloorFromY(int y) {
        return TOTAL_FLOORS - (y / FLOOR_HEIGHT);
    }
    public static synchronized void checkPeopleAvailable() {
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
        if (!availability) {
            for (Queue<Person> q : outQ) {
                if (!q.isEmpty()) {
                    availability = true;
                    break;
                }
            }
        }

        isPeopleAvailable = availability; // no need to sync if already in sync block
    }
}
