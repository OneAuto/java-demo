package annotation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @Target 表示这个注解能放在什么位置上，是只能放在类上？还是即可以放在方法上，又可以放在属性上。自定义注解@JDBCConfig 这个注解上的@Target是：@Target({METHOD,TYPE})，表示他可以用在方法和类型上（类和接口），但是不能放在属性等其他位置。 可以选择的位置列表如下：
 * ElementType.TYPE：能修饰类、接口或枚举类型
 * ElementType.FIELD：能修饰成员变量
 * ElementType.METHOD：能修饰方法
 * ElementType.PARAMETER：能修饰参数
 * ElementType.CONSTRUCTOR：能修饰构造器
 * ElementType.LOCAL_VARIABLE：能修饰局部变量
 * ElementType.ANNOTATION_TYPE：能修饰注解
 * ElementType.PACKAGE：能修饰包
 */

/**
 * Create by Ant on 2020/2/18 8:00 PM
 * mac
 */
@JDBCConfig(ip = "127.0.0.1",port = 3306,database = "fxdb",encoding = "UTF-8",loginName = "root",password = "itcast")
public class NewDBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        /**
         * 根据反射获取注解对象
         */
        JDBCConfig config=NewDBUtil.class.getAnnotation(JDBCConfig.class);
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", config.ip(), config.port(),config.database(), config.encoding());
        return DriverManager.getConnection(url,config.loginName(),config.password());
    }

    public static void main(String[] args) {
        try (Connection connection=getConnection()){
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

