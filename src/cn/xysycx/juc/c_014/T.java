package cn.xysycx.juc.c_014;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/3 下午11:03
 *
 * volatile 并不能保证多个线程共同修改running变量所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面程序  分析结果
 *
 * 分析之后得出  volatile只能保证线程的可见性 无法保证原子性
 *  添加synchronized 之后可以保证结果正确
 *
 */
public class T {
    /*volatile*/ int count = 0;
    synchronized  void m() {
        for (int i = 0; i <1_0000; i++) {
            count++;
        }
    }
    public static void main(String[] args) {
        T t = new T();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }

}
// 不加volatile  ，多线程执行count++ 结果小于10万
// 加volatile  ，多线程执行count++ 结果依旧小于10万