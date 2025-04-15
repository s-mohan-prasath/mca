import java.io.*;
import java.util.*;

public class filehandling{
    public static void main(String[] args){
        String fileName = "program.txt";
        String text = "My First line of code\nSecond line\nthird line\nfourth line";
        createFile(fileName);
        writeFile(fileName,text,true);
        String[] fileTextArray = readFile(fileName);
        fileStatistics(fileTextArray);
    }
    public static String[] readFile(String fileName){
        System.out.printf("\nFILE READING OPERATION : %s\n\n",fileName);
        try{
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder output = new StringBuilder();
            while((line=bufferedReader.readLine())!=null){
                output.append("__FILE__");
                output.append(line);
                System.out.println(line);
            }
            bufferedReader.close();
            System.out.println(output.toString());
            System.out.println("File read successful");
            String[] x= output.toString().split("__FILE__");
            System.out.println(Arrays.toString(x));
            return x;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            return new String[]{};
        }
    }
    public static void writeFile(String fileName,String text,boolean doAppend){
        System.out.printf("\nFILE WRITING OPERATION : %s\n",fileName);
        try{
            FileWriter writer = new FileWriter(fileName,doAppend);
            writer.write(text);
            writer.close();
            System.out.println("File written successfully");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void createFile(String fileName){
        System.out.printf("\nFILE CREATION OPERATION : %s\n",fileName);
        try{
            File f = new File(fileName);
            if (f.createNewFile()){
                System.out.println("File created : "+f.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void fileStatistics(String[] fileTextArray){
        StringBuilder str = new StringBuilder();
        int lines = 0,words=0,sentences=0,characters=0;
        System.out.println("coming");
        for(String s:fileTextArray){
            System.out.println("coming");
            str.append(" ");
            str.append(s);
            characters+=s.length();
            System.out.println(s);
            lines++;
        }
        String newStr = str.toString();
        words = newStr.split(" ").length;
        sentences = newStr.split(".").length;

        System.out.println("FILE STATISTICS : ");
        System.out.printf("No of Lines : %d\nNo of Words : %d\nNo of Sentences : %d\nNo of Characters : %d\n",lines,words,sentences,characters);
    }
}