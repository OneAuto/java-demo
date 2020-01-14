package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        C3p0Utils c=new C3p0Utils();
        Connection conn=c.getConnection();
        try {
            PreparedStatement ps =conn.prepareStatement("select * from product_");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           c.close();
        }
    }
}
