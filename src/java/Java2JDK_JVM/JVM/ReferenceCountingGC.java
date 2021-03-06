package Java2JDK_JVM.JVM;

/***Created by moyongzhuo
 *On 2018/3/29  ***13:33.
 ******/
/**
 * 虚拟机参数：-verbose:gc
 */
public class ReferenceCountingGC {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /** 这个成员属性唯一的作用就是占用一点内存 */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        System.gc();
    }
}