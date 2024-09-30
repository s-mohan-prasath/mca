import java.util.ArrayList;

public class problems4 {
    public problems4() {

    }

    public void prob1(ArrayList<Integer> arr) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        int n = arr.size();
        int m = 0;
        while (m < n) {
            int i = 2;
            int x = arr.get(m);
            while (i < n) {
                if (x % i == 0) {
                    output.add(x);
                    break;
                }
                i++;
            }
            m++;
        }
        System.out.println(output.toString());
    }

    public void prob2(int len, int k, int[] arr) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        int i;
        for (i = k; i < len; i++) {
            output.add(arr[i]);
        }
        for (i = 0; i < k; i++) {
            output.add(arr[i]);
        }
        System.out.println(output.toString());
    }

    public void prob3(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            if (n == 0) {
                System.out.println(-1);
            } else if (n == 1) {
                System.out.println(0);
            } else {
                if (arr[0] > arr[1])
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            return;
        } else {
            int i = 1;
            while (i < n - 1) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    System.out.println(i);
                    return;
                }
                i++;
            }
            System.out.println(-1);
        }
    }

    public void prob4(int[] arr, int k) {
    }

    public void prob5(int[] arr) {
        int zeros, ones, twos, len, i;
        zeros = 0;
        ones = 0;
        twos = 0;
        len = arr.length;
        for (i = 0; i < len; i++) {
            if (arr[i] == 0)
                zeros++;
            else if (arr[i] == 1)
                ones++;
            else
                twos++;
        }
        for (i = 0; i < len; i++) {
            if (zeros != 0) {
                arr[i] = 0;
                zeros--;
            } else if (ones != 0) {
                arr[i] = 1;
                ones--;
            } else {
                arr[i] = 2;
                twos--;
            }
        }
        printArray(arr);
    }

    public void prob6(int[] arr) {
        int len, i, positives = 0, pi, ni, ele;
        len = arr.length;
        ArrayList<Integer> custom = new ArrayList<>();
        i = 0;
        while (i < len) {
            custom.add(0);
            if (arr[i] >= 0) {
                positives++;
            }
            i++;
        }
        pi = 0;
        ni = positives;
        i = 0;
        while (i < len) {
            ele = arr[i];
            if (ele >= 0) {
                custom.set(pi, ele);
                pi++;
            } else {
                custom.set(ni, ele);
                ni++;
            }
            i++;
        }
        i = 0;
        while (i < len) {
            arr[i] = custom.get(i);
            i++;
        }
        printArray(arr);
    }

    public void prob7(String str) {
        int len, i, count;
        len = str.length();

        count = 0;
        i = 0;
        while (i < len) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            i++;
        }
        System.out.printf("Number of Vowels in the String is %d", count);
    }

    public void prob7ii(String str) {
        int len;
        String reverseStr, newStr;
        reverseStr = new String("");
        newStr = new String(str);
        len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (Exception e) {
            System.out.println("Length of the String is " + len);
        } finally {
            len = len - 1;
            while (len >= 0) {
                reverseStr += str.substring(len, len + 1);
                len--;
            }
            System.out.println("Reverse String is " + reverseStr);
            System.out.println("New String is " + newStr);
        }
    }

    public void prob8(String str) {
        int len;
        String output = new String("");
        len = str.length();
        int i = 0;
        while (i < len) {
            char c = str.charAt(i);
            int ascii = (int) c;
            if (ascii >= 97 && ascii <= 122) {
                ascii -= 32;
            }
            output += Character.toString((char) ascii);
            i++;
        }
        System.out.println("Output : " + output);
    }

    public void prob9(String str) {
        int len, i;
        String ele, space = " ";
        String output = "";
        boolean alreadyHaveSpace = false;
        len = str.length();
        i = 0;
        while (i < len) {
            ele = str.substring(i, i + 1);
            if (ele.equals(space)) {
                alreadyHaveSpace = true;
            } else if (alreadyHaveSpace) {
                alreadyHaveSpace = false;
                output += " " + ele;
            } else {
                output += ele;
            }
            i++;
        }
        if (str.substring(len - 1).equals(space)) {
            output += " ";
        }
        System.out.println(output);
    }

    public void prob10(int w, String str) {
        int len, i;
        String sub;
        len = str.length();

        i = 0;
        while (i + w < len) {
            sub = str.substring(i, i + w);
            System.out.println(sub);
            i += w;
        }
        if (len % w != 0) {
            sub = str.substring(i);
            System.out.println(sub);
        }
    }

    public void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}