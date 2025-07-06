import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class Lift extends JPanel {
    ESystem system;
    float maxWeight;
    int currentFloor = 0;
    enum Direction {
        UP, DOWN, IDLE
    }

    enum State {
        DOOR_OPEN, DOOR_CLOSE, PEOPLE_LIFT_INT, PEOPLE_LIFT_OUT, MOVING
    }

    Direction direction = Direction.IDLE;
    State state;

    int maxUpFloor=2, minDownFloor=2;
    HashSet<Person> people;

//    UI PARAMS

    private final int X = ESystem.FLOOR_WIDTH -ESystem.ELEVATOR_WIDTH-5,
            Y=ESystem.TOTAL_FLOORS*ESystem.FLOOR_HEIGHT-ESystem.ELEVATOR_HEIGHT-1;

    public Lift(ESystem system) throws InterruptedException {
        setOpaque(true);
        setBackground(new Color(120, 120, 255));
        setSize(ESystem.ELEVATOR_WIDTH, ESystem.ELEVATOR_HEIGHT);
        setBounds(X,Y, ESystem.ELEVATOR_WIDTH, ESystem.ELEVATOR_HEIGHT);

        this.people = new HashSet<>();
        getLiftThread().start();
    }
    private void movePeopleFromQueueToLift() {
        Queue<Person> queue = (direction == Direction.UP) ? ESystem.upQ[currentFloor] : ESystem.downQ[currentFloor];
        synchronized (ESystem.class) {
            while (!queue.isEmpty()) {
                Person p = queue.poll();
                if (p == null) continue;

                p.updateState(Person.State.MOVING_INSIDE_LIFT);
                System.out.println(p + " is moving INSIDE Lift");

                people.add(p);
                ESystem.outQ[p.getEndFloor()].add(p);

                p.updateState(Person.State.INSIDE_LIFT);
                System.out.println(p + " is INSIDE Lift");
                ESystem.sleep(1000); // Optional delay
            }
        }
    }
    private void movePeopleFromLiftToFloor() {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getEndFloor() == currentFloor) {
                p.updateState(Person.State.MOVING_OUTSIDE_LIFT);
                System.out.println(p + " is moving OUTSIDE Lift");
                iterator.remove(); // Safe removal

                p.updateState(Person.State.WALKING_AWAY_FROM_LIFT);
                System.out.println(p + " is moving AWAY FROM Lift");
            }
            ESystem.sleep(1000);
        }
        synchronized (ESystem.class) {
            ESystem.outQ[currentFloor].clear();
        }
    }
    private boolean isPeopleAvailableAt(int floor) {
        if (floor < 0 || floor >= ESystem.TOTAL_FLOORS) return false;
        return direction == Direction.UP ? !ESystem.upQ[floor].isEmpty() : !ESystem.downQ[floor].isEmpty();
    }
    private void smoothMoveTo(int targetY) {
        int currentY = getY();
        int delta = targetY - currentY;
        int steps = 200;
        int delay = 10; // milliseconds per step
        double stepY = delta / (double) steps;

        Timer timer = new Timer(delay, null);
        final int[] stepCount = {0};
        final double[] currentPos = {currentY};

        timer.addActionListener(e -> {
            if (stepCount[0] < steps) {
                currentPos[0] += stepY;
                setLocation(getX(), (int) currentPos[0]);
                stepCount[0]++;
            } else {
                ((Timer) e.getSource()).stop();
                setLocation(getX(), targetY); // Final adjustment
                synchronized (this) {
                    this.notify(); // Notify the lift thread to continue
                }
            }
        });
        timer.start();

        // Wait until the timer completes before continuing the lift logic
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private Thread getLiftThread() {
        return new Thread(() -> {
            while (true) {
                synchronized (ESystem.class) {
                    while (!ESystem.isPeopleAvailable) {
                        try {
                            ESystem.class.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                if (direction == Direction.UP) {
                    while (currentFloor <= maxUpFloor) {
                        System.out.println("MOVING TO FLOOR : " + currentFloor);
                        int newY = ESystem.getYForFloor(currentFloor) - ESystem.ELEVATOR_HEIGHT;
                        smoothMoveTo(newY);
                        if (isPeopleAvailableAt(currentFloor) || !ESystem.outQ[currentFloor].isEmpty()) {
                            ESystem.sleep(1000);
                            updateState(State.DOOR_OPEN);
                            movePeopleFromLiftToFloor();
                            ESystem.sleep(1000);
                            movePeopleFromQueueToLift();
                            ESystem.sleep(1000);
                            synchronized (ESystem.class) {
                                while(ESystem.waitings[currentFloor]!=0){
                                    try {
                                        ESystem.class.wait();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                            ESystem.sleep(1000);
                            updateState(State.DOOR_CLOSE);
                            updateState(State.MOVING);
                        }
                        if (currentFloor == maxUpFloor || currentFloor == ESystem.TOTAL_FLOORS - 1) {
                            ESystem.checkPeopleAvailable();
                            if (!ESystem.isPeopleAvailable) {
                                direction = Direction.IDLE;
                            } else {
                                direction = Direction.DOWN;
                            }
                            break;
                        }
                        currentFloor++;
                    }
                }
                else if (direction == Direction.DOWN) {
                    while (currentFloor >= minDownFloor) {
                        System.out.println("MOVING TO FLOOR : " + currentFloor);
                        int newY = ESystem.getYForFloor(currentFloor) - ESystem.ELEVATOR_HEIGHT;
                        smoothMoveTo(newY);
                        if (isPeopleAvailableAt(currentFloor) || !ESystem.outQ[currentFloor].isEmpty()) {
                            ESystem.sleep(1000);
                            updateState(State.DOOR_OPEN);
                            movePeopleFromLiftToFloor();
                            ESystem.sleep(1000);
                            movePeopleFromQueueToLift();
                            synchronized (ESystem.class) {
                                while(ESystem.waitings[currentFloor]!=0){
                                    try {
                                        ESystem.class.wait();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                            ESystem.sleep(1000);
                            updateState(State.DOOR_CLOSE);
                            updateState(State.MOVING);
                        }
                        if (currentFloor == minDownFloor || currentFloor == 0) {
                            ESystem.checkPeopleAvailable();
                            if (!ESystem.isPeopleAvailable) {
                                direction = Direction.IDLE;
                            } else {
                                direction = Direction.UP;
                            }
                            break;
                        }

                        currentFloor--;
                    }
                }
                else {
                    ESystem.sleep(1500); // Wait a bit before re-checking if IDLE
                }
            }
        });
    }
    public void updateState(State newState) {
        System.out.println("Coming");
        this.state = newState;
        switch (newState) {
            case MOVING -> {

            }
            case  DOOR_OPEN -> {
                System.out.println("DOOR OPEN");
                handleDoorOpen();
            }
            case DOOR_CLOSE -> {
                handleDoorClose();
            }
            case PEOPLE_LIFT_INT -> {

            }
            case PEOPLE_LIFT_OUT -> {

            }
            default -> {

            }
        }
    }
    private Timer doorOpenTimer, doorCloseTimer;
    public void handleDoorClose() {
        if (doorCloseTimer != null && doorCloseTimer.isRunning()) return; // fix: check close timer

        doorCloseTimer = new Timer(10, null);
        doorCloseTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ESystem.ELEVATOR_DOOR_SPEED -= 0.02f;
                if (ESystem.ELEVATOR_DOOR_SPEED <= 0.0f) {
                    ESystem.ELEVATOR_DOOR_SPEED = 0.0f;
                    doorCloseTimer.stop();
                    doorCloseTimer = null; // cleanup
                    // Optionally go to MOVING state here
                }
                ESystem.lift.getParent().repaint(); // This is your BuildingPanel
            }
        });
        doorCloseTimer.start();
    }
    private void handleDoorOpen() {
        if (doorOpenTimer != null && doorOpenTimer.isRunning()) return;

        doorOpenTimer = new Timer(20, null);
        doorOpenTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ESystem.ELEVATOR_DOOR_SPEED += 0.02f;

                if (ESystem.ELEVATOR_DOOR_SPEED >= 1.0f) {
                    ESystem.ELEVATOR_DOOR_SPEED = 1.0f;
                    doorOpenTimer.stop();
                }
                SwingUtilities.invokeLater(() -> {
                    ESystem.lift.revalidate();
                    ESystem.lift.repaint();
                });

            }
        });

        doorOpenTimer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw elevator shadow
        g2d.setColor(new Color(0, 0, 0, 40));
        g2d.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 15, 15);
        // Draw elevator body with gradient
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(120, 120, 255),
                0, getHeight(), new Color(80, 80, 200)
        );
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 15, 15);
        // Animate door opening (center-out sliding effect)
        int maxDoorSlide = (getWidth() - 14) / 2; // full width door slide
        int openOffset = (int)(maxDoorSlide * ESystem.ELEVATOR_DOOR_SPEED);

        int doorWidth = maxDoorSlide;
        int doorHeight = getHeight() - 14;
        int centerX = getWidth() / 2;
        int topY = 5;

// Left door slides left
        int leftDoorX = centerX - doorWidth - openOffset;
// Right door slides right
        int rightDoorX = centerX + openOffset;

// Draw doors
        g2d.setColor(new Color(200, 200, 255));
        g2d.fillRoundRect(leftDoorX, topY, doorWidth, doorHeight, 10, 10);
        g2d.fillRoundRect(rightDoorX, topY, doorWidth, doorHeight, 10, 10);

// Door outlines
        g2d.setColor(new Color(180, 180, 255));
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.drawRoundRect(leftDoorX, topY, doorWidth, doorHeight, 10, 10);
        g2d.drawRoundRect(rightDoorX, topY, doorWidth, doorHeight, 10, 10);
// Draw floor indicator (top = 4, bottom = 0)
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        int yPos = getY();
        int floorNum = ESystem.TOTAL_FLOORS - 1 - (yPos / ESystem.FLOOR_HEIGHT);
        if (floorNum < 0) floorNum = 0;
        if (floorNum > ESystem.TOTAL_FLOORS - 1) floorNum = ESystem.TOTAL_FLOORS - 1;
        String floorText = String.valueOf(floorNum);
        FontMetrics fm = g2d.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(floorText)) / 2;
        int textY = (getHeight() + fm.getAscent()) / 2;
        g2d.drawString(floorText, textX, textY);
    }
}
