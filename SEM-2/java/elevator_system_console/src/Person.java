public class Person {
    private final String name;
    private final int startFloor;
    private final int endFloor;
    private final float weight;
    private State state;

    public enum State {
        IDLE,
        WALKING_TOWARDS_LIFT,
        WALKING_AWAY_FROM_LIFT,
        INSIDE_LIFT,
        MOVING_OUTSIDE_LIFT,
        MOVING_INSIDE_LIFT
    }

    public Person(String name, int startFloor, int endFloor, float weight) {
        this.name = name;
        this.startFloor = startFloor;
        this.endFloor = endFloor;
        this.weight = weight;
        this.state = State.IDLE;
    }

    public void updateState(State newState) {
        this.state = newState;
    }

    public State getState() {
        return state;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "[" + name + " | " + startFloor + "→" + endFloor + "]";
    }
}
