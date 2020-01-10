package thread;

import javafx.application.Platform;
import org.slf4j.Logger;
import utils.LoggerUtils;

public class Main {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(Main.class);
    public static void main(String[] args) throws InterruptedException {



        /*
        创建线程的三种方式：
        1.继承Thread类
        2.实现Runnable接口
        3.匿名类方式
         */

        //实现Runnable接口
       Thread th= new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //当前线程暂停3秒
                    Thread.sleep(3000);
                    LOG.info("th线程");
                    LOG.info("th线程执行完毕->耗时3000ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //匿名类
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    //当前线程暂停1秒
                    Thread.sleep(1000);
                    LOG.info(getName()+ "线程");
                    LOG.info(getName()+" 线程执行完毕->耗时1000ms");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        thread.setPriority(Thread.MAX_PRIORITY);        //设置优先级最大
        th.setPriority(Thread.MIN_PRIORITY);        //设置优先级最小
        thread.join();      //加入主线程，等该线程完成后才能继续
        th.join();
        thread.start();
        th.start();

        LOG.info("主线程最后执行");
    }
}
