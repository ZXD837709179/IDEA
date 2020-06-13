package other.za;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/7 11:02
 * @description:
 *
 *  T内部有8个long类型总共64位，这样CPU只会读取arr[0]进入，其他线程改变arr[1]也不宜你更像自己的数据
 */
public class CacheLine2 {
    public static class padding{
        public volatile long p1,p2,p3,p4,p5,p6,p7;
    }

    public static class T extends padding{
        public volatile long x=0L;
    }

    public static T[] arr = new T[2];

    static{
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 0L; i < 10000000; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0L; i < 10000000; i++) {
                arr[1].x = i;
            }
        });
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        final long end = System.nanoTime();

        System.out.println((end-start)/1000000);
    }
}
