import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
    }
    public static void problem1(){
        ArrayList<BANK> customers = new ArrayList<>();
        updateCustomers(customers);
        Scanner scan = new Scanner(System.in);
        int action = 1;
        double bal;
        while(action!=0){
        System.out.printf("\nPress 1 : view Customers\nPress 2 : All customers that have greater than a particular amount\nPress 3 : View customer by AccountNumber\nENTER : ");
        action = scan.nextInt();
        switch (action){
                case 1 ->{
                    printCustomers(customers,null);
                }case 2 ->{
                    System.out.print("Enter balance : ");
                    bal = scan.nextDouble();
                    printCustomers(customers,bal);
                }case 3 ->{
                    System.out.print("Enter Account Number : ");
                    String acc = scan.next();
                    Boolean found = false;
                    for(BANK c:customers){
                        if(c.getAcc().equals(acc)){
                            System.out.println(c);
                            found = true;
                        }
                    }
                    if ((found)) {
                        System.out.println();
                    } else {
                        System.out.println("No Found");
                    }
            }
                default ->{
                    return;
                }
            }
        }

    }
    public static void updateCustomers(ArrayList<BANK> customers){
        String line;
        try{
            FileReader fr = new FileReader("problem1.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line= br.readLine())!=null){
                String[] data = line.split(" ");
                customers.add(new BANK(data[0],data[1],Double.parseDouble(data[2])));
            }
        }catch (Exception e){
            return;
        }
    }
    public static void printCustomers(ArrayList<BANK> customers,Double minBal){
        for(BANK c:customers){
            if(minBal!=null){
                if(c.getBal()<minBal)continue;
            }
            System.out.println(c.toString());
        }
    }
    public static void problem2(){
        Calculator calc = new Calculator();
        calc.addResult(1);
        calc.addResult(2);
        calc.addResult(3);
        calc.addResult(4);
        System.out.println(calc.operateOn('+'));
        System.out.println(calc.operateOn('/'));
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
    public static void problem4(){
        try{
            Renter[] renters = {new Renter(1,"osigisj","Mohan",true)};
            FileOutputStream fos = new FileOutputStream("problem5.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(Renter o : renters){
                Renter.writeRenter(dos,o);
            }
            dos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("problem5.dat");
            DataInputStream dis = new DataInputStream(fis);
            Renter o;
           while ((o=Renter.readRenter(dis))!=null){
               System.out.println(o);
               System.out.println();
           }

        }catch (Exception e){
            return;
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
            return;
        }
    }
}
class BANK{
    private String nameAccHolder;
    private String accountNumber;
    private double Balance;
    public BANK(String nameAccHolder,String accountNumber,double Balance){
        this.nameAccHolder=nameAccHolder;
        this.accountNumber = accountNumber;
        this.Balance = Balance;
    }
    public double getBal(){
        return Balance;
    }
    public String getAcc(){
        return accountNumber;
    }

    @Override
    public String toString() {
        return nameAccHolder + " "+accountNumber +" "+ Balance;
    }
}
class Calculator{
    Stack<Double> cal;
    public Calculator(){
        cal = new Stack<>();
    }
    void addResult(double result){
        cal.push(result);
    }
    double undoLast(){
        if(!cal.empty()){
            cal.pop();
            if(cal.empty())return 0;
            return cal.peek();
        }
        return 0;
    }
    double undoLast(int n){
        int i = 0;
        double num=0;
        while(i<n){
            num = undoLast();
            i++;
        }
        return num;
    }
    Double operateOn(char c){
        Stack<Double> temp = new Stack<>();
        Double ele = null;
        Double out = cal.empty() ? null : (ele = cal.pop());
        if (out==null)return null;
        temp.push(ele);
        while(out != null && !cal.empty()){
            out = arithmetic(out,(ele=cal.pop()),c);
            temp.push(ele);
        }
        while(!temp.empty())cal.push(temp.pop());
        return out;
    }
    Double arithmetic(double a,double b,char c){
        if(c=='+')return a+b;
        else if(c=='-')return a-b;
        else if(c=='*')return a*b;
        else if(c=='/')return (b==0) ? null : a/b;
        return null;
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
class Renter implements Serializable{
    int renterID;
    String vehicleID;
    String renterName;
    boolean agreementStatus;
    public Renter(int renterID,String vehicleID,String renterName,boolean agreementStatus){
        this.renterName = renterName;
        this.vehicleID = vehicleID;
        this.agreementStatus = agreementStatus;
        this.renterID = renterID;
    }
    public static Renter readRenter(DataInputStream dis){
        try{
            return new Renter(dis.readInt(),dis.readUTF(),dis.readUTF(),dis.readBoolean());
        }catch(Exception e){
            return null;
        }
    }
    public static void writeRenter(DataOutputStream dos,Renter obj){
        try{
            dos.writeInt(obj.renterID);
            dos.writeUTF(obj.vehicleID);
            dos.writeUTF(obj.renterName);
            dos.writeBoolean(obj.agreementStatus);
        }catch(Exception e){
            return;
        }
    }
    @Override
    public String toString() {
        return "Renter Name : "+renterName+"\nVehicle ID : "+vehicleID+"\nAgreement Status : "+agreementStatus+"\nRenter ID : "+renterID;
    }
}