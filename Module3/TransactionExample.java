import java.sql.*;

public class TransactionExample {
    private final Connection conn;

    public TransactionExample(Connection conn) {
        this.conn = conn;
    }

    public void transfer(int fromAccount, int toAccount, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

                debit.setDouble(1, amount);
                debit.setInt(2, fromAccount);
                int debitResult = debit.executeUpdate();

                credit.setDouble(1, amount);
                credit.setInt(2, toAccount);
                int creditResult = credit.executeUpdate();

                if (debitResult == 1 && creditResult == 1) {
                    conn.commit();
                    System.out.println("Transfer successful");
                } else {
                    conn.rollback();
                    System.out.println("Transfer failed, transaction rolled back");
                }
            }
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String pass = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            TransactionExample te = new TransactionExample(conn);
            te.transfer(1, 2, 100.0);
        }
    }
}
