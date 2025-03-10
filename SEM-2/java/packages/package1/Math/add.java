package Math;

public class add {
    private int operand1, operand2;

    public add() {
        // Scanner scan = new Scanner;
        // System.out.print("Enter operand 1 : ");
        // this.operand1 = scan.nextInt();
        // System.out.print("Enter operand 2 : ");
        // this.operand2 = scan.nextInt();
    }

    public add(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int getSum(int x, int y) {
        return x + y;
    }
}