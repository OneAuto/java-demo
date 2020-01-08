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

            FileWriter fw=new FileWriter("/Volumes/Backup/text.txt");
            fw.write(all);

            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
