package Unit;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-04
 * Time: 10:44
 */
//JDBC工具类，放置JDBC较经常使用的参数和操作
public class JDBCUnit {

    //将需要使用到的参数信息放置在properties配置文件中
    //将配置文件中的信息封装到ResourceBundle对象中，需要用的使用的时候在通过getString()方法取出
    private static ResourceBundle bundle = ResourceBundle.getBundle("config.jdbc");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");
    private static String driver = bundle.getString("driver");

    static {
        //注册驱动,由于导入的jar包为8+版本，在jar包中自动帮我们完成了注册驱动，所以有无注册驱动影响不大
        //但是为了保证兼容性，还是强烈建议加上去
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //获取驱动
    public static Connection getConnection() throws SQLException {

        //获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    //释放连接
    public static void close(Connection conn, PreparedStatement stat, ResultSet set){

        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (stat != null) {
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
