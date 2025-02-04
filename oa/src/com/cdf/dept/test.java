package com.cdf.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-04
 * Time: 11:33
 */
public class test {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        conn = JDBCUnit.getConnection();
        String sql = "select * from dept";
        stat = conn.prepareStatement(sql);
        set = stat.executeQuery();
        while(set.next()){
            String deptno = set.getString("deptno");
            String deptname = set.getString("deptname");
            System.out.println(deptname + deptno);
        }
    }
}
