package annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Create by Ant on 2020/2/18 7:51 PM
 * mac
 */


/**
 * Retention.SOURCE 注解只在源代码中
 * Retention.CLASS 编译成class文件后依旧存在，运行后便后失效
 * Retention.RUNTIME 运行后依旧存在
 * Document 表示javadoc命令生成问答API后依旧有注解说明
 */
@Target({METHOD,TYPE}) //表示这个注解接口只能使用在接口跟类和方法上
@Retention(RetentionPolicy.RUNTIME)  //retention 表示生命周期，表示一个运行时注解
@Inherited  //遗传，表示该注解接口可以被继承
@Documented //文档注视
public @interface JDBCConfig {
    String ip();
    int port()  default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}
