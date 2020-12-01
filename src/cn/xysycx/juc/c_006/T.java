package cn.xysycx.juc.c_006;

/**
 * @Description TODO  分析一下这个程序的输出
 * @Author Fedeline
 * @Date 2020/12/1 下午1:33
 *
 */
public class T implements Runnable {
    private /*volatile*/ int count = 100;

    //synchronized 既保证了原子性又保证了可见性

    @Override
    public synchronized void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + " count = "+count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"THREAD"+i).start();
        }
    }
}
