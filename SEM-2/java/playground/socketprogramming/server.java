import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) {
        try (ServerSocket ss = new ServerSocket(5000)) {
            System.out.println("Waiting for client...");
            try (Socket s = ss.accept()) {
                System.out.println("Client connected");
                BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

                String str;
                while ((str = bf.readLine()) != null) {
                    System.out.println("Client Message: " + str);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
