package io.filestream;

import org.slf4j.Logger;
import utils.LoggerUtils;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Test {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(Test.class);
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        LOG.info("请输入类对名称：");
        String className=scan.nextLine();

        LOG.info("请输入属性对类型：");
        String type=scan.nextLine();

        LOG.info("请输入属性对名称：");
        String property=scan.nextLine();
        scan.close();
        String Uproperty=toUupperFirstLetter(property);

        //读取模版文件
        File file=new File("/volumes/backup/system.test");
        String modelCenter=null;
        try(FileReader fr=new FileReader(file)){

            char [] all=new char[(int)file.length()];
            fr.read(all);
            modelCenter=new String(all);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String toUupperFirstLetter(String str){
        char toUpperLetter=Character.toUpperCase(str.charAt(0));
        return toUpperLetter+str.substring(1);
    }
}
