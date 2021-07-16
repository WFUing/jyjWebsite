package jyj.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseUtils {
    public DataBaseUtils() {
    }

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = DataBaseUtils.class.getClassLoader().getResourceAsStream("JdbcDao.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }
}
