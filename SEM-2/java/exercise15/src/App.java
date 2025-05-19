import java.awt.*;
import java.sql.*;

public class App extends Frame {
    Connection connection;
    Label l1,l2,l3;
    TextField t1,t2,t3;
    Button b1,b2;
    TextArea area;
    String s1,s2,s3;
    public App() throws SQLException {

        requireConnection();

        l1 = new Label("Book Copyright Year : ");
        t1 = new TextField(10);
        l2 = new Label("Author ISBN : ");
        t2 = new TextField(10);
        l3 = new Label("Title : ");
        t3 = new TextField(10);
        b1 = new Button("Clear");
        b2 = new Button("Show Books");
        area = new TextArea(30,10);
        setLayout(new GridLayout(0,2));
        setSize(500,500);

        addListener();

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(area);

        setVisible(true);
    }
    private void addListener() {
        b1.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });
        b2.addActionListener(e -> {
            s1 = t1.getText();
            s2= t2.getText();
            s3 = t3.getText();
            String output = "";
                try {
            if(!s1.isEmpty()){
                int yr = Integer.parseInt(s1);
                    output = qn1(yr);
            }else if(!s2.isEmpty()){
                output = qn2(s2);
            }else{
                output = qn3(s3);
            }
                    if(output.isEmpty()){
                        output = "No Result";
                    }
                    area.setText(output);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        });
    }
    private void requireConnection() throws SQLException {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_book_management","user1","User1@12345");
        }catch (SQLException e){
            connection = null;
        }
    }
    private String qn1(int year) throws SQLException {
        if(connection==null)return "connection error occured";
        PreparedStatement pstmt = connection.prepareStatement("select * from titles where copyright_year = ?");
        pstmt.setInt(1, year);
        ResultSet rs = pstmt.executeQuery();
        StringBuilder str = new StringBuilder();
        while(rs.next()){
            str.append("ISBN : "+rs.getString("isbn")+"\nTITLE : "+rs.getString("title")+"\n");
        }
        rs.close();
        return str.toString();
    }
    private String qn2(String isbn) throws SQLException {
        if(connection == null)return "connection error occured";
        PreparedStatement pstmt = connection.prepareStatement("select * from titles where isbn = ?");
        pstmt.setString(1, isbn);
        ResultSet rs = pstmt.executeQuery();
        StringBuilder str = new StringBuilder();
        while(rs.next()){
            str.append("ISBN : "+rs.getString("isbn")+"\nTITLE : "+rs.getString("title")+"\n"+"Edition Number : "+rs.getString("edition_number")+"\n"+"Copyright Year : "+rs.getString("copyright_year")+"\n");
        }
        rs.close();
        return str.toString();
    }
    private String qn3(String title) throws SQLException {
        if(connection == null)return "connection error occured";
        PreparedStatement pstmt = connection.prepareStatement("select * from titles where title = ?");
        pstmt.setString(1, title);
        ResultSet rs = pstmt.executeQuery();
        StringBuilder str = new StringBuilder();
        while(rs.next()){
            str.append("ISBN : "+rs.getString("isbn")+"\nTITLE : "+rs.getString("title")+"\n"+"Edition Number : "+rs.getString("edition_number")+"\n"+"Copyright Year : "+rs.getString("copyright_year")+"\n");
        }
        rs.close();
        return str.toString();
    }
}
