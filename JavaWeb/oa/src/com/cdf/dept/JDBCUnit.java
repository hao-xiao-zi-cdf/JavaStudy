package com.cdf.dept;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-02
 * Time: 20:04
 */
public class JDBCUnit {

    //加载properties属性文件对象，将里面的配置信息封装到ResourceBundle对象中
    //通过getString()方法从res对象中获取对应的配置信息
    private static ResourceBundle res = ResourceBundle.getBundle("config.jdbc");
    private static String url = res.getString("url");
    private static String user = res.getString("user");
    private static String password = res.getString("password");

    public static Connection getConnection() throws SQLException {

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static void close(Connection conn, PreparedStatement stat, ResultSet set) {

        //释放资源
        if(set != null){
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
