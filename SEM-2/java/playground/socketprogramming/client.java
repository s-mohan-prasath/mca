
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String args[]) throws IOException, Exception {
        try (Socket s = new Socket("localhost", 5000)) {
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            try (Scanner scan = new Scanner(System.in)) {
                int x = 1;
                String str;
                while (x != 0) {
                    System.out.printf("Press 1 : Send Message\nPress 0 : Exit\nENTER : ");
                    x = scan.nextInt();
                    switch (x) {
                        case 1 -> {
                            System.out.print("\nEnter message : ");
                            scan.nextLine();
                            str = scan.nextLine();
                            pr.println(str);
                            pr.flush();
                        }
                        case 0 -> {
                            return;
                        }
                        default -> throw new AssertionError();
                    }
                }
            }

        }
    }
}