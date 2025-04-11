package ps6;
class Cuboid extends ThreeDShape {
    double radius;

    public Cuboid(double radius, String color) {
        this.radius = radius;
        super.color = color;
        super.volume = (double) (4 / 3 * 3.14 * this.radius * this.radius * this.radius);
        Shapes.count++;
    }

    public void getVolume() {
        super.dispVolume();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius of the Shape is " + this.radius);
    }
}