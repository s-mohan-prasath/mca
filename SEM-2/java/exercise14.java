
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exercise14 {
    public static void main(String[] args) {
        program1();
        program2_and_4();
        program3();
        program5("good");
    }

    private static void program1() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt", true), 1000);
            bw.write("\ngood");
            bw.flush();
        } catch (IOException e) {
        }
    }

    private static void program2_and_4() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("note1.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("note2.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void program5(String searchWord) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("note.txt"));
            String line = null;
            int freq = 0;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (searchWord.equals(arr[i]))
                        freq++;
                }
            }
            System.out.println(searchWord + " appears " + freq + " times in this file");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void program3() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("note.txt"));
            String line = null;
            int freq = 0;
            int lines = 0;
            int words = 0;
            String fullString = "";
            while ((line = br.readLine()) != null) {
                lines++;
                String[] arr = line.split(" ");
                words += arr.length;
                fullString += line;
            }
            int chars = fullString.length();
            int sentences = fullString.split("[.]").length;
            System.out.printf("No of lines : %d\nNo of Words : %d\nNo of Sentences : %d\nNo fo Character : %d\n", lines,
                    words, sentences, chars);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}