package thread;

import org.slf4j.Logger;
import utils.LoggerUtils;

public class Main {
    private static final Logger LOG= LoggerUtils.getLoggerEntity(Main.class);
    public static void main(String[] args) {

       Thread th= new Thread(new Runnable() {
            @Override
            public void run() {
                LOG.info("启动了新线程");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();

        try{
            //加入主线程，要等th线程执行完后才继续下去
            th.join();
            LOG.info("th线程执行完毕->耗时1000ms");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
