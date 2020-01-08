package io.filestream;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class TestStream {

    public static final Logger LOG=LoggerUtils.getLoggerEntity(TestStream.class);

    public static void main(String[] args) {

        try {

            //计算程序运行时间
            long startTime=System.currentTimeMillis();

            File file=new File("/Volumes/Backup/myfile/childFile");
            File txt=new File(file,"test.txt");
            if (!file.exists()||!txt.exists()){
                file.mkdir();
                txt.createNewFile();
            }

            LOG.info("文件："+txt.getName()+" 目录：{}",txt.getAbsolutePath());

            //创建文件输入流，将文件流输入到JVM内存
            File newFile=new File("/Volumes/Backup/hanbi.sql");
            FileInputStream fileInputStream=new FileInputStream(newFile);
            byte [] all=new byte[(int) newFile.length()];
            fileInputStream.read(all);

            //将数据从内存写入到文件，也就是输出流，
            // 当文件txt不存在时会自动创建该文件
            FileOutputStream fileOutputStream=new FileOutputStream(txt);
            fileOutputStream.write(all);



            long endTime=System.currentTimeMillis();





            LOG.info("程序运行时间：{}",(endTime-startTime)+"ms");
            //关闭输出流
            fileOutputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }
}
