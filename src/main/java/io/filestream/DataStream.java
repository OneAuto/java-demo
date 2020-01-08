package io.filestream;

import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import sun.rmi.runtime.Log;
import utils.LoggerUtils;

import java.io.*;

public class DataStream {
    public static final Logger LOG=LoggerUtils.getLoggerEntity(DataStream.class);

    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1(){
        File file=new File("/Volumes/Backup/test.txt");
        try(
                FileOutputStream fos=new FileOutputStream(file);
                FileInputStream fis=new FileInputStream(file);
                DataInputStream dis=new DataInputStream(fis);
                DataOutputStream dos=new DataOutputStream(fos);
                ){
            dos.writeInt(15);
            dos.writeInt(31);
            dos.flush();

            int a=dis.readInt();
            int b=dis.readInt();
            LOG.info("使用数据流读取出的数据 a={},b={}",a,b);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void method2()  {
        File file=new File("/Volumes/Backup/text.txt");
        try(
                FileWriter fw=new FileWriter(file);
                PrintWriter pw=new PrintWriter(fw);
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
            ){
                fw.write(15+"@"+31);
                fw.flush();

                String str=br.readLine();
                String [] all=str.split("@");
                int a=Integer.parseInt(all[0]);
                int b=Integer.parseInt(all[1]);
                LOG.info("使用缓存流读取出的数据 a={},b={}",a,b);
        }catch (Exception e){
            e.printStackTrace();
        }
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
