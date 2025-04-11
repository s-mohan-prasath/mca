package ps6;

class Shapes {
    static int count;
    String color;

    public Shapes() {

    }

    protected void displayInfo() {
        System.out.println("Color of the Shape is " + this.color);
        System.out.println("Number of Shape created " + Shapes.count);
    }
}
