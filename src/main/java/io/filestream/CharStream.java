package io.filestream;

import java.io.*;

public class CharStream {
    public static void main(String[] args)  {
        File file=new File("/Volumes/Backup/hanbi.sql");
        //字符输入流
        try (FileInputStream inputStream=new FileInputStream(file) ){
            FileReader fr=new FileReader(file);
            char [] all=new char[(int)file.length()];
            fr.read(all);

            //当文件不存在时，自动创建该文件
            FileWriter fw=new FileWriter("/Volumes/Backup/text.txt");
            fw.write(all);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
