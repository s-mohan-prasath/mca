import java.util.*;

public class ps4 {
    // 1. Method to check if a number is perfect and display proper divisors
    public static void checkPerfectNumber(int num) {
        int sum = 0;
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
                divisors.add(i);
            }
        }

        System.out.println("Proper divisors: " + divisors);
        if (sum == num) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }
    }

    // 2. Method to compute the average of an array
    public static double computeAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    // 3. Method to compute the average of three integers
    public static double averageOf3(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // 4. Method to compute the 10-digit ISBN number
    public static void checkSum(int num) {
        String strNum = String.format("%09d", num); // Ensure 9 digits
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += (i + 2) * (strNum.charAt(8 - i) - '0');
        }

        int checksum = (11 - (sum % 11)) % 11;
        char lastDigit = (checksum == 10) ? 'X' : (char) (checksum + '0');

        System.out.println("10-digit ISBN: " + strNum + lastDigit);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 1. Perfect number check
            System.out.print("Enter a number to check if it's perfect: ");
            int num = sc.nextInt();
            checkPerfectNumber(num);
            
            // 2. Compute average of an array
            int[] arr = { 1, -2, 4, -4, 9, -6, 16, -8, 25, -10 };
            System.out.println("Average of array: " + computeAverage(arr));
            
            // 3. Compute average of three numbers
            System.out.println("Average of (4, 7, 13): " + averageOf3(4, 7, 13));
            
            // 4. Compute checksum for ISBN
            System.out.print("Enter a 9-digit integer for ISBN: ");
            int isbnNum = sc.nextInt();
            checkSum(isbnNum);
        }
    }
}
