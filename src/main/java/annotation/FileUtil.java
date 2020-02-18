package annotation;

import java.io.File;
import java.lang.annotation.*;

/**
 * Create by Ant on 2020/2/18 9:13 PM
 * mac
 */
public class FileUtil {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes {
        FileType [] value();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)
    public @interface FileType{
        String value();
    }

    @FileType( ".java" )
    @FileType( ".html" )
    @FileType( ".css" )
    @FileType( ".js" )
    public void work(){
        try {
            FileType [] fileTypes=this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            for (FileType fileType:fileTypes){
                System.out.println(fileType);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
