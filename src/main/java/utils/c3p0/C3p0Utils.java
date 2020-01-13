package utils.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import utils.LoggerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(C3p0Utils.class);
    private static ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource("mysql5.7");

    public static Connection getConnection(){
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Exception in C3p0Utils:",e);
            return null;
        }
    }


}
