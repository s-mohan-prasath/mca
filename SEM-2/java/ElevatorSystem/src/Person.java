import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Person extends JPanel {
    private final String name = "";
    private final int startFloor;
    private final int endFloor;
    private final float weight = 50;
    private State state;

    public enum State {
        IDLE,
        WALKING_TOWARDS_LIFT,
        WALKING_AWAY_FROM_LIFT,
        INSIDE_LIFT,
        MOVING_OUTSIDE_LIFT,
        MOVING_INSIDE_LIFT
    }

    // UI Constants
    public static final int PERSON_WIDTH = 24;
    public static final int PERSON_HEIGHT = 44;
    private final int START_X = 50;
    private int START_Y;

    private int X;
    private int Y;

    private Timer moveTimer;

    private int targetX;
    private int targetY;
    private boolean moveHorizontally = false;
    private boolean moveVertically = false;

    private final int WALK_SPEED = 2;
    private float elevatorSpeed = 1.5f;  // pixels per frame
    private Runnable onMovementComplete;

    // Animation parameters
    private double bounceOffset = 0;
    private double stepAngle = 0;

    public Person(int startFloor, int endFloor) {
        this.startFloor = startFloor;
        this.endFloor = endFloor;
        this.state = State.IDLE;
        this.X = START_X;
        this.START_Y = getStartY(startFloor);
        this.Y = START_Y;

        setPreferredSize(new Dimension(PERSON_WIDTH + 20, PERSON_HEIGHT + 20));
        setSize(getPreferredSize());
        setOpaque(false);
        setLocation(START_X, START_Y);

        setVisible(true);
        moveTimer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stepAngle += 0.2;
                if (stepAngle >= 360) stepAngle = 0;
                bounceOffset = Math.abs(Math.sin(stepAngle * 2)) * 2;

                boolean reachedX = true;
                boolean reachedY = true;

                if (moveHorizontally) {
                    if (X < targetX) {
                        X += WALK_SPEED;
                        if (X >= targetX) X = targetX;
                        else reachedX = false;
                    } else if (X > targetX) {
                        X -= WALK_SPEED;
                        if (X <= targetX) X = targetX;
                        else reachedX = false;
                    }
                }

                if (moveVertically) {
                    if (Y < targetY) {
                        Y += elevatorSpeed;
                        if (Y >= targetY) Y = targetY;
                        else reachedY = false;
                    } else if (Y > targetY) {
                        Y -= elevatorSpeed;
                        if (Y <= targetY) Y = targetY;
                        else reachedY = false;
                    }
                }

                if (reachedX && reachedY) {
                    stopMoving();
                    if (onMovementComplete != null) onMovementComplete.run();
                }

                repaint();
            }
        });
        updateState(State.WALKING_TOWARDS_LIFT);
    }
    public void updateState(State newState) {
        if (this.state == newState) return; // Skip if already in this state
        this.state = newState;
        switch (newState) {
            case IDLE:
                stopMoving();
                break;

            case WALKING_TOWARDS_LIFT:
                handleMovementToLift(true);
                break;

            case MOVING_OUTSIDE_LIFT:
                this.Y = ESystem.getYForFloor(endFloor);
                setLocation(getX(), Y);
                repaint();
                setVisible(true);
                handleMovementToLift(false);
                break;

            case WALKING_AWAY_FROM_LIFT:
                moveTo(START_X, Y, null);
                break;

            case MOVING_INSIDE_LIFT:
                incrementStartFloorWaitings();
                moveTo(ESystem.FLOOR_WIDTH - ESystem.ELEVATOR_WIDTH / 2, Y, () -> {
                    setVisible(false);
                    decrementStartFloorWaitings();
                });
                break;

            case INSIDE_LIFT:
                // Optional: Add visual feedback
                break;
        }
    }
    private void handleMovementToLift(boolean isStartFloor) {
        if (isStartFloor) {
            incrementStartFloorWaitings();
        } else {
            incrementEndFloorWaitings();
        }

        int targetX = ESystem.FLOOR_WIDTH - ESystem.ELEVATOR_WIDTH - 100;
        moveTo(targetX, Y, () -> {
            if (isStartFloor) {
                decrementStartFloorWaitings();
            } else {
                decrementEndFloorWaitings();
            }
        });
    }
    private void incrementStartFloorWaitings(){
        synchronized (ESystem.class) {
            ESystem.waitings[startFloor]++;
            ESystem.class.notifyAll();
        }
    }
    private void incrementEndFloorWaitings(){
        synchronized (ESystem.class) {
            ESystem.waitings[endFloor]++;
            ESystem.class.notifyAll();
        }
    }
    private void decrementStartFloorWaitings(){
        synchronized (ESystem.class) {
            ESystem.waitings[startFloor]--;
            ESystem.class.notifyAll();
        }
    }
    private void decrementEndFloorWaitings(){
        synchronized (ESystem.class) {
            ESystem.waitings[endFloor]--;
            ESystem.class.notifyAll();
        }
    }
    public void moveTo(int destX, int destY, Runnable onComplete) {
        this.targetX = destX;
        this.targetY = destY;
        this.moveHorizontally = (X != destX);
        this.moveVertically = (Y != destY);
        this.onMovementComplete = onComplete;
        moveTimer.start();
    }
    public void stopMoving() {
        moveTimer.stop();
        moveHorizontally = false;
        moveVertically = false;
        repaint();
    }
    public int getStartFloor() {
        return startFloor;
    }
    public int getEndFloor() {
        return endFloor;
    }
    private int getStartY(int floorIndex) {
        return ESystem.getYForFloor(floorIndex) - PERSON_HEIGHT;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setStroke(new BasicStroke(2.0f));

        g2d.setColor(Color.BLACK);
        drawWalkingPerson(g2d, X, Y - (int) bounceOffset);
    }
    private void drawWalkingPerson(Graphics2D g, int x, int y) {
        double armAngle = Math.sin(stepAngle) * 0.5;
        double legAngle = Math.sin(stepAngle) * 0.7;
        double headTilt = Math.sin(stepAngle * 2) * 0.1;
        double bodyLean = Math.sin(stepAngle) * 0.1;

        g.rotate(headTilt, x, y - 15);
        g.drawOval(x - 4, y - 19, 8, 8);
        g.rotate(-headTilt, x, y - 15);

        g.rotate(bodyLean, x, y);
        g.drawLine(x, y - 11, x, y + 5);
        g.rotate(-bodyLean, x, y);

        g.rotate(armAngle, x, y - 5);
        g.drawLine(x, y - 5, x - 10, y - 2);
        g.rotate(-armAngle, x, y - 5);

        g.rotate(-armAngle, x, y - 5);
        g.drawLine(x, y - 5, x + 10, y - 2);
        g.rotate(armAngle, x, y - 5);

        g.rotate(legAngle, x, y + 5);
        g.drawLine(x, y + 5, x - 8, y + 20);
        g.rotate(-legAngle, x, y + 5);

        g.rotate(-legAngle, x, y + 5);
        g.drawLine(x, y + 5, x + 8, y + 20);
        g.rotate(legAngle, x, y + 5);
    }
    @Override
    public String toString() {
        return "[" + ("a"+startFloor+endFloor) + " | " + startFloor + "→" + endFloor + "]";
    }
}
