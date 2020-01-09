package io.filestream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class SystemStream {
    public static void main(String[] args) {

        try(
                InputStream is=System.in;
                Scanner scan=new Scanner(System.in);
        ) {

            /*
            使用System.in.read()读取不是很方便，使用Scanner可以逐行读取
             */
//            while(true){
//                System.out.println(is.read());
//            }

            while(true){
                System.out.println(scan.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
