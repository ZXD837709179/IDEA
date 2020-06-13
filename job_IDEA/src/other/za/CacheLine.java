package other.za;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/7 11:02
 * @description: 与CacheLine2对比，发现这个的效率不如2；
 * 因为在CPU内部缓存行是64位，每次读取缓存是64位。两个线程分别在两个核内运行，每次读取64位的数据
 * 对于线程1而言每次只改变arr[0]的数据，但是会读取arr[1]的数据进入核内，当然还有其他的数据，总共64位，其中
 * arr[0]只有一个long8字节。
 * 但是arr[1]的值被另一个线程所改变，加上volatile会让CPU再次读取arr[1]的数据，因此时间比较慢。
 */
public class CacheLine {

    public static class T {
        public volatile long x = 0L;
    }
    public static T[] arr = new T[2];

    static {
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

        System.out.println((end - start) / 1000000);
    }
}
