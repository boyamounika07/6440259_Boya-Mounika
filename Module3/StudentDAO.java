import java.sql.*;

public class StudentDAO {
    private final Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            return ps.executeUpdate() > 0;
        }
    }

    public boolean updateStudentName(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        }
    }

    // Example main to test
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String pass = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            StudentDAO dao = new StudentDAO(conn);
            dao.insertStudent(1, "Alice");
            dao.updateStudentName(1, "Alicia");
            System.out.println("Insert and update done.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
