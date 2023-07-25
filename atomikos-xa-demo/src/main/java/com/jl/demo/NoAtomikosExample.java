package com.jl.demo;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author jerry chan
 * @date 2023/7/21 16:50
 */
public class NoAtomikosExample {

    public static DataSource createDataSource(Integer port, String dbName) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:" + port + "/" + dbName);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");

        return mysqlDataSource;
    }

    public static void main(String[] args) throws SQLException {
        DataSource ds1 = createDataSource(3306, "xa_test");
        DataSource ds2 = createDataSource(3308, "xa_test_2");

        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        // 执行db1上的sql
        conn1 = ds1.getConnection();
        conn1.setAutoCommit(false);
        ps1 = conn1.prepareStatement("INSERT into user(name) VALUES (?)");
        ps1.setString(1, "2321312132");
        ps1.executeUpdate();

        // 模拟异常 ，直接进入catch代码块，2个都不会提交
//        int i=1/0;

        // 执行db2上的sql
        conn2 = ds2.getConnection();
        conn2.setAutoCommit(false);
        ps2 = conn2.prepareStatement("INSERT into user(name) VALUES (?)");
        ps2.setString(1, "weixiaobaofanren");
        ps2.executeUpdate();

        conn1.rollback();
        conn2.commit();
    }
}
