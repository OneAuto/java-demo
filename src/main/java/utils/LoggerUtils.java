package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
    public static Logger getLoggerEntity(Class clazz){
        return LoggerFactory.getLogger(clazz);
    }
}
