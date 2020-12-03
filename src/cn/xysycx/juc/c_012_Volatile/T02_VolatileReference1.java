package cn.xysycx.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/3 下午10:15
  *
 */
public class T02_VolatileReference1 {
     boolean running = true;
     volatile static T02_VolatileReference1 T = new T02_VolatileReference1();
     void m(){
         System.out.println("m start");
         while (running){
             /*try{
                 TimeUnit.SECONDS.sleep(10);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }*/
         }
         System.out.println(" m end");

     }

    public static void main(String[] args) {
        new Thread(T::m,"t1").start();
        //lambda表达式  new Thread(new Runnable(run(){m()})
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T.running = false;
    }

}
