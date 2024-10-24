import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public void initDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data/ventas.db");
            String sql = "CREATE TABLE IF NOT EXISTS ventas (id INTEGER PRIMARY KEY, total_venta REAL, fecha TEXT)";
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guardarVenta(double totalVenta) {
        try {
            String sql = "INSERT INTO ventas (total_venta, fecha) VALUES (?, datetime('now'))";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, totalVenta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
