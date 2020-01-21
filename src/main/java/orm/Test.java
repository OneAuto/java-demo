package orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import utils.C3p0Utils;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Product p = new Product();
        p.setName("iphone7");
        p.setPrice(7000.0);
        s.save(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}
