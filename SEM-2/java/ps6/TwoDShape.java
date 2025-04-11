package ps6;

class TwoDShape extends Shapes {
    double area, perimeter;

    protected void dispArea() {
        System.out.println("Area of the Shape is " + this.area);
    }

    protected void dispPerimeter() {
        System.out.println("Perimeter of the Shape is " + this.perimeter);
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
        System.out.println("Area of the Shape is " + this.area);
        System.out.println("Perimeter of the Shape is " + this.perimeter);
    }
}
