package ps6;
class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Circle c1 = new Circle(10, "red");
        Cuboid cube = new Cuboid(100, "pink");
        c1.displayInfo();
        cube.displayInfo();
    }
}