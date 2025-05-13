
import java.io.*;

public class filehandling {
    public static void main(String[] args) {
        BufferedInputStream bf;
        try {
            bf = new BufferedInputStream(new FileInputStream("input.txt"));
            bf.close();
        } catch (Exception e) {
        } finally {
        }
    }

    public static void byteStream() {
        int c;
        try {
            FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt");

            while ((c = in.read()) != -1) {
                System.out.println(c);
                out.write(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void charStream() {
        int c;
        try {
            FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt");

            while ((c = in.read()) != -1) {
                System.out.println(c);
                out.write(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void bufferedCharacterStream() {
        String l;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("input.txt"), 10000);
            while ((l = bf.readLine()) != null) {
                System.out.println(l);
            }
            bf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void bufferedByteStrea() {
        String l;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("input.txt"), 10000);
            while ((l = bf.readLine()) != null) {
                System.out.println(l);
            }
            bf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}