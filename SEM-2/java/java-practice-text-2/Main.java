import java.io.*;

public class Main{
    public static void main(String[] args){
        problem5();
    }
    public static void problem3(){
        String line;
        try{
            FileReader fr = new FileReader("problem3_in.txt");
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter("problem3_out.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void problem5(){
        try{
            BOOK[] books = {new BOOK("Paunlo colo","Alchemist",100.0f,1),new BOOK("The Monk who sold his ferrari","Robin Sharma",100.0f,1),new BOOK("James Clear","Atomic Habits",200.0f,2)};
            FileOutputStream fos = new FileOutputStream("problem4.ser");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(BOOK o : books){
                oos.writeObject(o);
            }
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("problem4.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            BOOK book;
           while ((book= (BOOK) ois.readObject())!=null){
               System.out.println(book);
               System.out.println();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class BOOK implements Serializable{
    String authorName;
    String bookTitle;
    double bookPrice;
    int bookID;
    public BOOK(String authorName,String bookTitle,double bookPrice,int bookID){
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.bookID = bookID;
    }
    @Override
    public String toString() {
        return "Author Name : "+authorName+"\nBook Title : "+bookTitle+"\nBook Price : "+bookPrice+"\nBook Id : "+bookID;
    }
}