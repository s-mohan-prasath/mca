import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudManagementSystem {
    private Connection createConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");
        }catch(Exception e){
            System.out.println("Error : "+e.toString());
            return null;
        }
    }
    public void insertStudent(){
        try{
            Connection con = createConnection();
            if(con!=null){
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Name : ");
                String name = scan.next();
                System.out.print("Enter Roll No : ");
                int rollNo = scan.nextInt();
                String query = "insert into students (roll_no, name) values (?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1,rollNo);
                stmt.setString(2,name);

                int rowsInserted = stmt.executeUpdate();
                if(rowsInserted>0) System.out.println("Student record inserted successfully!");
                else{
                    System.out.println("Error inserting student record!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudent(){
        try{
            Connection con = createConnection();
            if(con!=null){
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Roll No : ");
                int rollNo = scan.nextInt();
                String query = "DELETE FROM students where roll_no = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setInt(1,rollNo);

                int rowsDeleted = stmt.executeUpdate();
                if(rowsDeleted>0) System.out.println("Student record deleted successfully!");
                else{
                    System.out.println("Error deleting student record!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
