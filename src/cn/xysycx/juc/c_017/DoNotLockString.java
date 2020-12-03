package cn.xysycx.juc.c_017;

/**
 * @Description TODO
 * @Author Fedeline
 * @Date 2020/12/3 下午11:44
 *
 *
 */
public class DoNotLockString {
    String s1 = "Hello";
    String s2 = "Hello";

    void m1() {
        synchronized(s1) {

        }
    }

    void m2() {
        synchronized(s2) {

        }
    }
}
