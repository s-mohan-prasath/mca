package ps6;
class Circle extends TwoDShape {
    double radius;

    public Circle(double radius, String color) {
        this.radius = radius;
        Shapes.count++;
        super.color = color;
        super.area = (double) (3.14 * this.radius * this.radius);
        super.perimeter = (double) (2 * 3.14 * this.radius);
    }

    public void getArea() {
        super.dispArea();
    }

    public void getPerimeter() {
        super.dispPerimeter();
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius of the Shape is " + this.radius);
  