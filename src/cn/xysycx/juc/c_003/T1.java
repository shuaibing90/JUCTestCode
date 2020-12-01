package cn.xysycx.juc.c_003;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T1 {
    private int count = 10;


    public synchronized void m(){
            //等同于在方法代码执行时要synchronized(this)

            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);


    }
    public void n(){ count++; }




}
