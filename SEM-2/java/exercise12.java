import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class exercise12 {
    static String[] strArr = new String[] { "a", "b", "c", "d", "e" };
    static Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5, 6 };
    static Float[] floatArr = new Float[] { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };

    public static void main(String[] args) {
        twoF();
    }

    public static void oneA() {
        Swapper<String> swapper1 = new Swapper<>(strArr);
        swapper1.swap();
        System.out.println(swapper1);

        Swapper<Integer> swapper2 = new Swapper<>(intArr);
        swapper2.swap();
        System.out.println(swapper2);

        Swapper<Float> swapper3 = new Swapper<>(floatArr);
        swapper3.swap();
        System.out.println(swapper3);
    }

    public static void oneB() {
        Analyzer<Integer> analyse1 = new Analyzer<>(intArr);
        Analyzer<String> analyse2 = new Analyzer<>(strArr);
        Analyzer<Float> analyse3 = new Analyzer<>(floatArr);
        analyse1.analyse();
        analyse2.analyse();
        analyse3.analyse();
    }

    public static void twoA() {
        Students rolls = new Students();
        rolls.add("24mx101");
        rolls.add("24mx102");
        rolls.add("24mx103");
        rolls.add("24mx104");
        rolls.add("24mx105");
        rolls.add("24mx106");

        System.out.println(rolls.find("24mx115"));
        System.out.println(rolls.find("24mx102"));
    }

    public static void twoB() {
        ArrayList<String> EmpNameGender = new ArrayList<>();
        EmpNameGender.add("Abhishek - Male");
        EmpNameGender.add("Abhinesh - Male");
        EmpNameGender.add("Aashika - FeMale");
        EmpNameGender.add("Ulaganayadi - FeMale");
        EmpNameGender.add("Aadhi - Male");

        for (int i = 0; i < EmpNameGender.size(); i++) {
            String[] arr = EmpNameGender.get(i).split(" - ");
            String name, gender, newName;
            name = arr[0];
            gender = arr[1];
            newName = (gender.equals("Male")) ? "Mr. " + name : "Ms. " + name;
            EmpNameGender.set(i, newName);
        }
        System.out.println(EmpNameGender);
    }

    public static void twoC() {
        ArrayList<Integer> ratings = new ArrayList<>();
        ratings.add(5);
        ratings.add(4);
        ratings.add(4);
        ratings.add(5);
        ratings.add(1);
        ratings.add(1);
        ratings.add(5);
        ratings.add(4);
        ratings.add(4);
        ratings.add(5);
        ratings.add(4);
        ratings.add(4);
        ratings.add(4);
        ratings.add(1);
        ratings.add(1);
        ratings.add(1);
        ratings.add(1);
        ratings.add(1);
        ratings.add(2);
        int[] freq = new int[6];
        for (int i = 0; i < ratings.size(); i++) {
            freq[ratings.get(i)]++;
        }
        int num = 0, denom = 0;
        for (int i = 1; i < 6; i++) {
            if (freq[i] != 0) {
                num += freq[i] * i;
                denom += i;
            }
        }
        System.out.println("Frequency of rating (1) : " + freq[1]);
        System.out.println("Frequency of rating (2) : " + freq[2]);
        System.out.println("Frequency of rating (3) : " + freq[3]);
        System.out.println("Frequency of rating (4) : " + freq[4]);
        System.out.println("Frequency of rating (5) : " + freq[5]);
        if (denom != 0)
            System.out.println("Average of the Application is " + (float) num / denom);
    }

    public static void twoD() {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("JAVA Programming");
        titles.add("C Programming");
        titles.add("C++ Programming");
        titles.add("Programming in C");
        titles.add("Oops Using JAVA");

        String keyword = "JAVA";
        int resultCount = 0;
        System.out.println("books with the given keyword");
        for (int i = 0; i < titles.size(); i++) {
            String temp = titles.get(i);
            if (temp.contains(keyword)) {
                System.out.println(temp);
                resultCount++;
            }
        }
        System.out.println("Results : " + resultCount);
    }

    public static void twoE() {
        try (Scanner scan = new Scanner(System.in)) {
            ArrayList<String> contactBook = new ArrayList<>();
            String contactRecord, phoneNo;
            int action = 1, found = 0;
            while (action != 0) {
                System.out.printf(
                        "Press 1 : Add Contact\nPress 2: Edit Contact\nPress 3: Delete Contact\nPress 4 : View Contacts\nPress 0: Exit\nENTER : ");
                action = scan.nextInt();
                switch (action) {
                    case 1 -> {
                        System.out.println("Enter contact Record to insert : ");
                        scan.nextLine();
                        contactRecord = scan.nextLine();
                        contactBook.add(contactRecord);
                    }
                    case 2 -> {
                        System.out.println("Enter contact number : ");
                        phoneNo = scan.next();
                        for (int i = 0; i < contactBook.size(); i++) {
                            String[] arr = contactBook.get(i).split(" ");
                            found = 0;
                            if (arr[arr.length - 1].equals(phoneNo)) {
                                System.out.println("Enter contact Record to edit : ");
                                scan.nextLine();
                                contactRecord = scan.nextLine();
                                contactBook.set(i, contactRecord);
                                found = 1;
                                break;
                            }
                        }
                        if (found == 0) {
                            System.out.println("Record not found");
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter contact number : ");
                        phoneNo = scan.next();
                        found = 0;
                        for (int i = 0; i < contactBook.size(); i++) {
                            String[] arr = contactBook.get(i).split(" ");
                            if (arr[arr.length - 1].equals(phoneNo)) {
                                contactBook.remove(i);
                                found = 1;
                                break;
                            }
                        }
                        if (found == 0) {
                            System.out.println("Record not found");
                        }
                    }
                    case 4 -> {
                        System.out.println(contactBook);
                    }
                    case 0 -> {
                        break;
                    }
                    default -> System.out.println("Invalid Entry");
                }
            }
        }
    }

    public static void twoF() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(90);
        scores.add(77);
        scores.add(100);
        scores.add(16);
        scores.add(50);
        scores.add(45);
        scores.add(90);
        scores.add(40);
        scores.add(40);
        scores.add(89);
        scores.add(10);
        scores.add(25);

        int[] freq = new int[4];
        int sum = 0;
        for (int x : scores) {
            if (x < 50)
                freq[0]++;
            else if (x <= 60)
                freq[1]++;
            else if (x <= 70)
                freq[2]++;
            else
                freq[3]++;
            sum += x;
        }
        System.out.println("AVERAGE SCORE : " + (float) (sum) / scores.size());
        System.out.println("FREQUENCY : ");
        System.out.printf("Less than 50\t:%d\n50<=score<=60\t:%d\n60<score<=70\t:%d\n70<score<=100\t:%d\n", freq[0],
                freq[1], freq[2], freq[3]);
    }

}

class Students {
    ArrayList<String> arr;

    public Students() {
        arr = new ArrayList<>();
    }

    public void add(String x) {
        arr.add(x);
    }

    public int find(String k) {
        int i;
        int len = arr.size();
        for (i = 0; i < len; i++) {
            if (arr.get(i).equals(k))
                return i;
        }
        return -1;
    }
}

@SuppressWarnings("unused")
class Analyzer<Type extends Comparable<Type>> {
    Type[] arr;
    Type min, max;

    public Analyzer(Type[] arr) {
        this.arr = arr;
    }

    public void analyse() {
        int len = arr.length;
        min = (len > 0) ? this.arr[0] : null;
        max = (len > 0) ? this.arr[0] : null;
        for (int i = 0; i < len; i++) {
            if (min.compareTo(this.arr[i]) > 0)
                min = arr[i];
            if (max.compareTo(arr[i]) < 0)
                max = arr[i];
        }
        System.out.println("Minimum is : " + min);
        System.out.println("Maximum is : " + max);
    }

}

class Swapper<Type> {
    Type[] arr;

    public Swapper(Type[] arr) {
        this.arr = arr;
    }

    public void swap() {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            Type temp = this.arr[i];
            this.arr[i] = this.arr[len - 1 - i];
            this.arr[len - i - 1] = temp;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}