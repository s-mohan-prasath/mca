package Math;

public class product {
    private int operand1, operand2;

    public product() {
        // Scanner scan = new Scanner;
        // System.out.print("Enter operand 1 : ");
        // this.operand1 = scan.nextInt();
        // System.out.print("Enter operand 2 : ");
        // this.operand2 = scan.nextInt();
    }

    public product(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int prod(int x, int y) {
        int sum = 0;
        add obj = new add();
        for (int i = 1; i <= x; i++)
            sum = obj.getSum(sum, y);
        return sum;
    }
}