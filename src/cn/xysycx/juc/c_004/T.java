package cn.xysycx.juc.c_004;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T {
    private static int count = 10;


    public synchronized void m(){
            //等同于synchronized(T.class)

            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);


    }
    public static void mm(){
        //考虑一下这里的synchronized(this) 是否可以？
        synchronized(T.class){
            count--;
        }
    }




}
