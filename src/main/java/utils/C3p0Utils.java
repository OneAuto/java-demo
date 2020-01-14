package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(C3p0Utils.class);
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
    private Connection conn=null;

    public  Connection getConnection(){
        try {
            conn=dataSource.getConnection();
            LOG.info("Get Connection successfu!");
            return conn;
        } catch (SQLException e) {
            LOG.error("Exception in C3p0Utils:{}",e);
            return null;
        }
    }

    public void close()  {
        try {

            conn.close();
        } catch (SQLException e) {
            LOG.error("Exception in C3p0Utils:{}",e);
        }
    }

}
