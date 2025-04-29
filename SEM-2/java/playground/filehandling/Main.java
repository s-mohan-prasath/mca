import java.io.*;

public class Main{
    public static void main(String[] args){
        oisIoos();
    }
    public static void oisIoos(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.ser"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.ser"));

            Object o = new Object("Mohan",115);
            oos.writeInt(1);
            oos.writeObject(o);

            System.out.println(ois.readInt());
            System.out.println(ois.readObject());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void disIdos(){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("output.bin"));
            DataInputStream dis = new DataInputStream(new FileInputStream("output.bin"));
            for(int i = 0;i<3;i++){
                dos.writeInt(i+1);
                dos.writeUTF("Name - "+(i+1));
            }
            for(int i = 0;i<3;i++){
                System.out.print(dis.readInt());
                System.out.print(dis.readUTF());
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class Object implements Serializable {
    String name;
    int rollno;
    public Object(String name,int rollno){
        this.name = name;
        this.rollno = rollno;
    }
    @Override
    public String toString() {
        return "I am "+name+" of Roll Number : "+rollno;
    }
}