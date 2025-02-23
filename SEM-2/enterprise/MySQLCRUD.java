import java.sql.*;

public class MySQLCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb"; // Change DB name
    private static final String USER = "root"; // Change username
    private static final String PASSWORD = "password"; // Change password

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database.");

            createTable(conn);
            insertData(conn, "John Doe", "john@example.com");
            readData(conn);
            updateData(conn, 1, "Jane Doe", "jane@example.com");
            deleteData(conn, 1);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))";
        conn.createStatement().execute(sql);
        System.out.println("Table created.");
    }

    private static void insertData(Connection conn, String name, String email) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.executeUpdate();
        System.out.println("Data inserted.");
    }

    private static void readData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM users";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
        }
    }

    private static void updateData(Connection conn, int id, String newName, String newEmail) throws SQLException {
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, newName);
        stmt.setString(2, newEmail);
        stmt.setInt(3, id);
        stmt.executeUpdate();
        System.out.println("Data updated.");
    }

    private static void deleteData(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Data deleted.");
    }
}
