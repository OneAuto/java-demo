package Refiect;

import sun.reflect.misc.ConstructorUtil;

import java.lang.reflect.Constructor;
import java.time.temporal.ChronoField;

public class Test {

    @org.junit.Test
    public void test1(){
        //通过传统机制创建一个对象
        Hero hero=new Hero();
        hero.setId(1);
        hero.setName("gailun");

        try{

            //使用反射创建对象
            String className="Refiect.Hero";

            //类对象 Class加载会类对象会初始化静态初始化块，Hero.class则不会
            Class clazz1=Class.forName(className);
            Class clazz2=Hero.class;
            Class clazz3=hero.getClass();

            //JVM内存中只有一个Class类对象
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz2==clazz3);
            System.out.println(clazz1 == clazz3);

            //构造器
            Constructor p1=clazz1.getConstructor();
            Constructor p2=clazz2.getConstructor();
            Constructor p3=clazz3.getConstructor();



            //通过构造器是实例化

            Hero h1=(Hero)clazz1.newInstance();
            Hero h2=(Hero)clazz2.newInstance();
            Hero h3=(Hero)clazz3.newInstance();

            h1.setName("1");  h1.setId(1);
            h2.setName("2");
            System.out.println(h1);
            System.out.println(h2);
            System.out.println(h3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
