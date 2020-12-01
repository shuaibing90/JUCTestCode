package cn.xysycx.juc.c_007;

/**
 * @Description TODO  同步和非同步方法是否可以同时调用
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T  {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end");
    }
    public void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T t = new T();
       /*

       new Thread(()-> t.m1(),"t1").start();
        new Thread(()-> t.m2(),"t2").start();      */

        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        });*/


    }

}