package io.filestream;

import org.slf4j.Logger;
import sun.rmi.runtime.Log;
import utils.LoggerUtils;

import java.io.*;

public class DataStream {
    public static final Logger LOG=LoggerUtils.getLoggerEntity(DataStream.class);

    public static void main(String[] args) {
        writer();
        read();
    }

    public static void read()  {
        File file=new File("/Volumes/Backup/dos.txt");
        try(FileInputStream fis=new FileInputStream(file);
            DataInputStream dis=new DataInputStream(fis); ) {

            boolean b=dis.readBoolean();
            int i=dis.readInt();
            String str=dis.readUTF();
            LOG.info("文件："+file.getName()+" ->AbsolutePath:{}",file.getAbsolutePath());
            LOG.info("整形数据:"+i);
            LOG.info("布尔值："+b);
            LOG.info("UTF:"+str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writer(){
        File file=new File("/Volumes/Backup/dos.txt");
        try(
                FileOutputStream fos=new FileOutputStream(file);
                DataOutputStream dos=new DataOutputStream(fos);
                ) {

            dos.writeBoolean(true);
            dos.writeInt(250);
            dos.writeUTF("123 this is gareen");
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
