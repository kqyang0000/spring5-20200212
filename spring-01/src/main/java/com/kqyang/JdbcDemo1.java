package com.kqyang;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://62.234.136.79:3306/spring5", "root", "asdQWE123*&%3306");
        PreparedStatement ps = conn.prepareStatement("select * from account");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
