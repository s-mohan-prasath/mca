import java.util.Scanner;

class Circle {
    static int count = 0; // Static variable to keep track of object count
    private int radius;
    private double area;

    // Default constructor
    Circle() {
        count++;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter radius: ");
            this.radius = sc.nextInt();
        }
        Carea();
    }

    // Parameterized constructor
    Circle(int n) {
        count++;
        this.radius = n;
        Carea();
    }

    // Private method to calculate area
    private void Carea() {
        this.area = Math.PI * radius * radius;
    }

    // Display method
    void display() {
        System.out.println("Circle Count: " + count);
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
    }
}

class CircleDemo {
    public static void main(String[] args) {
        // Single instance of Circle
        System.out.println("Single Instance:");
        Circle c1 = new Circle();
        c1.display();

        // Array of 5 instances
        System.out.println("\nArray of 5 Instances:");
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Circle " + (i + 1) + " details:");
            circles[i] = new Circle(i + 1); // Assigning different radii
            circles[i].display();
        }
    }
}
