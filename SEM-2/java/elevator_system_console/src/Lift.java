import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class Lift {
    float maxWeight;
    int currentFloor = 2;

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

    public Lift(float maxWeight, Queue<Person>[] upQ, Queue<Person>[] downQ) {
        this.maxWeight = maxWeight;
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
        if (floor < 0 || floor >= ESystem.floorCount) return false;
        return direction == Direction.UP ? !ESystem.upQ[floor].isEmpty() : !ESystem.downQ[floor].isEmpty();
    }
    private Thread getLiftThread() {
        return new Thread(() -> {
            while (true) {
                synchronized (ESystem.class) {
                    while (!ESystem.isPeopleAvailable) {
                        try {
                            ESystem.class.wait(); // Corrected from `wait()` to `ESystem.class.wait()`
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }
                if (direction == Direction.UP) {
                    while (currentFloor <= maxUpFloor) {
                        System.out.println("MOVING TO FLOOR : " + currentFloor);
                        if (isPeopleAvailableAt(currentFloor) || !ESystem.outQ[currentFloor].isEmpty()) {
                            state = State.DOOR_OPEN;
                            movePeopleFromLiftToFloor();
                            ESystem.sleep(2500);
                            movePeopleFromQueueToLift();
                            state = State.DOOR_CLOSE;
                            ESystem.sleep(2500);
                            state = State.MOVING;
                        }
                        if (currentFloor == maxUpFloor || currentFloor == ESystem.floorCount - 1) {
                            ESystem.checkPeopleAvailable();
                            if (!ESystem.isPeopleAvailable) {
                                direction = Direction.IDLE;
                            } else {
                                direction = Direction.DOWN;
                            }
                            break;
                        }
                        currentFloor++;
                        ESystem.sleep(2500);
                    }
                }
                else if (direction == Direction.DOWN) {
                    while (currentFloor >= minDownFloor) {
                        System.out.println("MOVING TO FLOOR : " + currentFloor);
                        if (isPeopleAvailableAt(currentFloor) || !ESystem.outQ[currentFloor].isEmpty()) {
                            state = State.DOOR_OPEN;
                            movePeopleFromLiftToFloor();
                            ESystem.sleep(2500);
                            movePeopleFromQueueToLift();
                            state = State.DOOR_CLOSE;
                            ESystem.sleep(2500);
                            state = State.MOVING;
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
                        ESystem.sleep(2500);
                    }
                }
                else {
                    ESystem.sleep(2500); // Wait a bit before re-checking if IDLE
                }
            }
        });
    }
}
