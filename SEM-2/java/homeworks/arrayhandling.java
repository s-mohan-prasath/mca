import java.util.*;

public class arrayhandling {
    public static void main(String[] args) {
        System.out.println();
        prob6();
    }

    public static void getArray(int n, int[] arr, Scanner scan) {
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Array Element at index " + i + " : ");
            arr[i] = scan.nextInt();
        }
    }

    public static int getArrayLen(Scanner scan) {
        System.out.print("Enter the length of Array : ");
        int len = scan.nextInt();
        return len;
    }

    public static void prob1() {
        try (Scanner scan1 = new Scanner(System.in)) {
            int len = getArrayLen(scan1);
            int[] arr = new int[len];
            System.out.println(len);
            getArray(len, arr, scan1);
            System.out.print("Enter the value of p : ");
            int p = scan1.nextInt();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < p; j++) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.printf("element at index=%d in the array is %d", p, arr[p - 1]);
        }
    }

    public static void prob2() {
        Scanner scan = new Scanner(System.in);
        int len = getArrayLen(scan);
        int[] arr1, arr2, sumArr;
        arr1 = new int[len];
        arr2 = new int[len];
        sumArr = new int[len];
        System.out.println("Enter Array1 elements : ");
        getArray(len, arr1, scan);
        System.out.println("Enter Array2 elements : ");
        getArray(len, arr2, scan);
        for (int i = 0; i < len; i++) {
            sumArr[i] = arr1[i] + arr2[i];
        }
        System.out.println(Arrays.toString(sumArr));
    }

    public static void prob3() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter length of the diagonal matrix : ");
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("Enter element i = %d and j = %d : ", i, j);
                    arr[i][j] = scan.nextInt();
                }
            }
            scan.close();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][i] + arr[n - i - 1][n - i - 1];
            }
            System.out.println("Sum of diagonal elements is " + sum);
        }
    }

    public static void prob4() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the value of n : ");
            int n = scan.nextInt();
            int sum = 0;
            int seriesSum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
                seriesSum += sum;
            }
            System.out.println("The Sum of Series up to Value " + n + " = " + seriesSum);
        }
    }

    public static void prob5() {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int len = getArrayLen(scan);
        int[] arr = new int[len];
        getArray(len, arr, scan);
        ArrayList<Integer> dupRemoved = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (hmap.containsKey(arr[i])) {
                hmap.replace(arr[i], hmap.get(arr[i]) + 1);
            } else {
                hmap.put(arr[i], 1);
                dupRemoved.add(arr[i]);
            }
        }
        StringBuilder s = new StringBuilder();
        int count = 0;
        for (int a : dupRemoved) {
            if (hmap.get(a) > 1) {
                count++;
                s.append(" ");
                s.append(a);
            }
        }
        System.out.printf("Total Repeated elements = %d\nRepeated elements are : %s", count, s.toString());
    }

    public static void prob6() {
        Scanner scan = new Scanner(System.in);
        int len = getArrayLen(scan);
        int[] arr = new int[len];

        getArray(len, arr, scan);
        StringBuilder primes = new StringBuilder();
        StringBuilder composites = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                composites.append(1);
                continue;
            }
            int j;
            for (j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    composites.append(" ");
                    composites.append(arr[i]);
                    break;
                }
            }
            if (j > Math.sqrt(arr[i])) {
                primes.append(" ");
                primes.append(arr[i]);
            }
        }
        System.out.println("Elements of Prime Array :" + primes.toString());
        System.out.println("Elements of Composite Array :" + composites.toString());
    }
}
