
import java.util.*;

public class ps1 {

    public ps1() {
        System.out.println("program1 started");
    }

    public void prob1() {
        String myname = "Mohan Prasath S";
        for (int i = 0; i < 10; i++) {
            System.out.println(myname);
        }
    }

    public void prob2() {
        String[] lines = {
                "Sno\tQualification\tPeriod Of Study\tPlace of Study",
                "1\tMCA\t\t2024-25\t\tCoimbatore",
                "2\tBSc\t\t2021-24\t\tTrichy",
                "3\tPlus Two\t2019-21\t\tTrichy",
                "4\tSSLC\t\t2017-19\t\tTrichy", };
        for (String s : lines) {
            System.out.println(s);
        }
    }

    public void prob3() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Celsius : ");
        int celsius = scan.nextInt();
        float fahrenheit = (float) (9.0 / 5.0) * celsius + 32;
        System.out.println("Fahrenheit is " + fahrenheit);
    }

    public void prob4() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the gender (1 - man, any number - woman) : ");
        int gender = scan.nextInt();
        System.out.print("Enter the Weight : ");
        float weight = scan.nextFloat();
        System.out.print("Enter the Height : ");
        float height = scan.nextFloat();
        float bmi = weight / (height * height);
        if ((bmi >= 27.8 && gender == 1) || (gender != 1 && bmi >= 25)) {
            System.out.printf("BMI : %f You are obese!", bmi);
        } else {
            System.out.printf("BMI : %f You are healthy!", bmi);
        }
    }

    public int prob5(int a, int b) {
        return a + b;
    }

    public int prob6(int hrs) {
        return hrs * 60 * 60;
    }

    public Integer prob7(int[] arr) {
        int len = arr.length;
        if (len >= 1) {
            return arr[0];
        }
        return null;
    }

    public Integer prob8(int side1, int side2) {
        return side1 + side2 - 1;
    }

    public Integer prob9(int num) {
        return num + 1;
    }

    public void secB_prob1() {
        System.out.println("MAXIMUM AND MINIMUM VALUES OF THE PRIMITIVE DATATYPE : ");
        System.out.println("BYTE");
        System.out.println("Max : " + Byte.MAX_VALUE + " Min : " + Byte.MIN_VALUE);
        System.out.println("INTEGER");
        System.out.println("Max : " + Integer.MAX_VALUE + " Min : " + Integer.MIN_VALUE);
        System.out.println("LONG");
        System.out.println("Max : " + Long.MAX_VALUE + " Min : " + Long.MIN_VALUE);
        System.out.println("FLOAT");
        System.out.println("Max : " + Float.MAX_VALUE + " Min : " + Float.MIN_VALUE);
        System.out.println("DOUBLE");
        System.out.println("Max : " + Double.MAX_VALUE + " Min : " + Double.MIN_VALUE);
        System.out.println("CHARACTER");
        System.out.println("Max : " + (int) Character.MAX_VALUE + " Min : " + (int) Character.MIN_VALUE);
    }

    public String secB_prob2(int num, char op) {
        // o for octal, b for binary , d for decimal , h for hexadecimal
        String output = null;
        switch (op) {
            case 'o' ->
                output = Integer.toOctalString(num);
            case 'b' -> output = Integer.toBinaryString(num);
            case 'h' ->
                output = Integer.toHexString(num);
            default -> Integer.toString(num);
        }
        return output;
    }
}
