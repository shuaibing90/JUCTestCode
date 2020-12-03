package cn.xysycx.juc.c_016;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/3 下午11:25
 *
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 *
 */
public class FineCoarseLock {
    int count  = 0;
    synchronized void m1(){
        //do sth need not sync

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有这句需要sync ，这时不应该给整个方法上锁
        count ++;

        //do sth need not sync

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    void m2(){
        //do sth need not sync
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            count ++;
        }
        //do sth need not sync

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
