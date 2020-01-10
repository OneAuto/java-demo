package thread;

import org.slf4j.Logger;
import utils.LoggerUtils;

public class DaemonTest {

    private static final Logger LOG= LoggerUtils.getLoggerEntity(DaemonTest.class);

    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                LOG.info("线程准备完蛋");
            }
        };

        t.setDaemon(true);
        t.start();
        LOG.info("如果这条信息出现说明没有提前完蛋");

    }
}
