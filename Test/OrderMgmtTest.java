
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static junit.framework.Assert.assertEquals;

public class OrderMgmtTest {

    @org.junit.Before
    public void setUp() throws Exception {
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        String sql;
        sql = "CREATE SCHEMA jdbc_order_mgmt";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE jdbc_order_mgmt.PRODUCT " +
                "(p_id INTEGER not NULL, " +
                " p_name VARCHAR(255), " +
                " unit_price INTEGER not NULL," +
                "PRIMARY KEY (p_id)," +
                "status CHAR(5))";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE jdbc_order_mgmt.CUSTOMER " +
                "(cust_id INTEGER not NULL, " +
                " cust_name VARCHAR(255), " +
                " address VARCHAR(255)," +
                "contact INTEGER," +
                "PRIMARY KEY (cust_id))";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE jdbc_order_mgmt.ORDERS" +
                "(order_id INTEGER not NULL," +
                "cust_id INTEGER not NULL, " +
                "p_id INTEGER not NULL, " +
                "date_of_order DATE," +
                "quantity float," +
                "total_bill INTEGER," +
                "PRIMARY KEY (order_id)," +
                "FOREIGN KEY (cust_id) REFERENCES CUSTOMER (cust_id)," +
                "FOREIGN KEY (p_id) REFERENCES PRODUCT (p_id));";

        stmt.executeUpdate(sql);

        sql = "CREATE TABLE jdbc_order_mgmt.PAYMENT" +
                "(pay_id INTEGER not NULL," +
                "order_id INTEGER not NULL," +
                "cust_id INTEGER not NULL, " +
                "date_of_pay DATE," +
                "total_bill INTEGER," +
                "PRIMARY KEY (pay_id)," +
                "FOREIGN KEY (order_id) REFERENCES ORDERS (order_id))";


        stmt.executeUpdate(sql);
       }

    public Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "org.mariadb.jdbc.Driver";
        String userName = "Prajakta";
        String password = "go4pr@j@kt@";
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void InsertInProduct() throws SQLException {
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        String sql;
        sql = "INSERT INTO jdbc_order_mgmt.PRODUCT VALUES ('11','Pen','10','no');";
        int actual = stmt.executeUpdate(sql);
        assertEquals(1, actual);
        closeConnection(conn);
    }
    @Test
    public void DeleteFromProduct() throws SQLException {
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        String sql;
        sql = "INSERT INTO jdbc_order_mgmt.PRODUCT VALUES ('11','pen','10','Y');";
        stmt.executeUpdate(sql);
        sql = "DELETE FROM jdbc_order_mgmt.PRODUCT Where p_id = '11'";
        int actual = stmt.executeUpdate(sql);
        assertEquals(1,actual);
        closeConnection(conn);
    }
    @Test
    public void UpdateProduct() throws SQLException {
        Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        String sql;
        sql = "INSERT INTO jdbc_order_mgmt.PRODUCT VALUES ('11','pen','10','Y');";
        stmt.executeUpdate(sql);
        sql = "UPDATE jdbc_order_mgmt.PRODUCT SET unit_price = '40' Where p_id = '11'";
        int actual = stmt.executeUpdate(sql);
        assertEquals(1,actual);
        closeConnection(conn);
    }
    @org.junit.After
    public void tearDown() throws Exception {
        Connection conn = createConnection();
        java.sql.Statement stmt = conn.createStatement();

        String sql = "DROP SCHEMA jdbc_order_mgmt";
        stmt.executeUpdate(sql);
        closeConnection(conn);
    }
}
