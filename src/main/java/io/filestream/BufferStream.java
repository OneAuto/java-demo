package io.filestream;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.*;

public class BufferStream {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(BufferStream.class);

    public static void main(String[] args) {
        File file=new File("/Volumes/Backup/hanbi.sql");
        long startTime=System.currentTimeMillis();
        try(FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter("/Volumes/Backup/demo.sql");
            BufferedWriter bw=new BufferedWriter(fw)) {

            char [] all=new char[(int) file.length()];

            br.read(all);

            bw.write(all);
            //有时候需要将数据立即写入硬盘，而不是等缓存满了在写入硬盘
            bw.flush();

            //缓存字符输出流，还有缓存输出字节流，一次写出一行数据
            PrintWriter pw=new PrintWriter("/Volumes/Backup/pw.txt");

            pw.println("缓存字符输出流");
            pw.flush();


            
            long endTime=System.currentTimeMillis();
            LOG.info("拷贝创建新文件用时：{}",(endTime-startTime)+"ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
