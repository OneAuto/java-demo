package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(C3p0Utils.class);
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();


    public  Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Exception in C3p0Utils:",e);
            return null;
        }
    }


}
