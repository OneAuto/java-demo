package io;
import org.slf4j.Logger;
import utils.LoggerUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Demo {
    public static Logger LOG = LoggerUtils.getLoggerEntity(Demo.class);

    public static void main(String[] args) {
        try {
            /*
            项目路径
             */
            File file = new File(new File("").getCanonicalPath());

            File file_1 = new File("/Volumes/Backup/myfile");
            if (!file_1.exists()) {
                file_1.mkdir();
            }

            File file_2 = new File(file_1, "childFile");
            if (!file_2.exists()) {
                file_2.mkdirs();
            }

                    /*
                    创建一个空文件之前一般要先创建父文件夹，否则将抛出异常
                     */
            File file_3 = new File(file_2, "mytxt.txt");
            if (!file_3.exists()) {
                file_3.createNewFile();
            }
            //以字符串数组的形式返回当前文件夹下的所有文件（不包含文件子文件及子文件夹）
            String[] fileArray = file.list();


            //以文件数组的形式返回当前文件夹下的所有文件（不包含子文件夹及子文件夹）
            File[] filelists = file.listFiles();

            LOG.info(file_3.getParentFile().getAbsolutePath());

            LOG.info("项目：" + file_1.getName() + " -> 绝对路径：{}", file_1.getAbsolutePath());
            LOG.info("文件：" + file.getName() + " -> 绝对路径：{}", file.getAbsolutePath());
            LOG.info("文件：" + file_2.getName() + " -> 绝对路径：{}", file_2.getAbsolutePath());
            LOG.info("txt文件：" + file_3.getName() + " -> 绝对路径：{}", file_3.getAbsolutePath());
            LOG.info("txt文件：" + file_3.getName() + " -> 文件所在目录：{}", file_3.getParent());

            LOG.info("txt文件：" + file_3.getName() + "文件长度：{}", file_3.length() + "B");
            LOG.info("txt文件：" + file_3.getName() + "文件最后修改时间：{}", new Date(file_3.lastModified()));
            LOG.info(file_3.getAbsolutePath());
            String fileIndex = file_3.getName();
            if (file_3.delete()) {
                LOG.info("文件：" + fileIndex + " 已删除");
            }

            File root_1 = new File("/Volumes/Backup");
            if (root_1.isDirectory()) {
                traverseFile(root_1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void traverseFile(File file) {
            File[] files = file.listFiles();
            for (File nextFile : files) {
                if (nextFile.isDirectory()) {
                    System.out.println();
                    LOG.info("当前目录：{}", nextFile.getAbsolutePath());
                    traverseFile(nextFile);
                } else {
                    LOG.info("文件名：{}", nextFile.getName());
                }
            }
    }



}
