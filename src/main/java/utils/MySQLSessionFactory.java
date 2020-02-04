package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySQLSessionFactory {
    private static final SessionFactory SF=new Configuration().configure().buildSessionFactory();
    private static Session session = null;

    public static Session getSession(){
        session=SF.openSession();
        return session;
    }

    public static void closeFactory(){
        session.close();
        SF.close();
    }

}
