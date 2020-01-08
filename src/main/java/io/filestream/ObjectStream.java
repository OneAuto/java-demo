package io.filestream;

import org.slf4j.Logger;
import utils.LoggerUtils;

import javax.management.ObjectInstance;
import java.io.*;

/*
对象序列化为流，必须实现serializeble接口（这个接口啥也没有）
 */
class Hero implements Serializable {
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;

}

public class ObjectStream {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(ObjectStream.class);

    public static void main(String[] args) {
        Hero hero=new Hero();
        hero.name="garen";
        hero.hp=616;

        //创建一个文件用于保存该对象
        File file=new File("/Volumes/Backup/hero.txt");

        try(
                /*
                创建对象流
                 */

                FileOutputStream fos=new FileOutputStream(file);
                ObjectOutputStream oos=new ObjectOutputStream(fos);

                FileInputStream fis=new FileInputStream(file);
                ObjectInputStream ois=new ObjectInputStream(fis);
                ){

            oos.writeObject(hero);
            oos.flush();

            Hero newHero=(Hero) ois.readObject();
            LOG.info("写入文件对对象是：{}",hero.name);
            LOG.info("从文件读取出对对象是：{}",newHero.name);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
