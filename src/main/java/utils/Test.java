package utils;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection conn=C3p0Utils.getConnection();
    }
}
