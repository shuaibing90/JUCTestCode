package cn.xysycx.juc.c_002;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T {
    private int count = 10;

    public void m(){
        //任何线程要执行下面的代码必须要先拿到this的锁
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);

        }
    }




}
