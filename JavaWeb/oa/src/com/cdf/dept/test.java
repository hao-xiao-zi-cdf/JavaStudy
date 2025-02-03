package com.cdf.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-03
 * Time: 18:00
 */
public class test {
    public static void main(String[] args) {
        try {
            Connection conn = JDBCUnit.getConnection();
            String sql = "select deptname from dept";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while(set.next()){
                System.out.println(set.getString("deptname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
