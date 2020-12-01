package cn.xysycx.juc.c_001;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T {
    private int count = 10;
    private Object o = new Object();
    public void m(){
        //任何线程要执行下面的代码必须要先拿到o的锁
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);

        }
    }




}
