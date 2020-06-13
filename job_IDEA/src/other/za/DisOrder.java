package other.za;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;

import java.util.HashSet;
import java.util.concurrent.Callable;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/7 21:01
 * @description:指令重排序的验证，不管线程怎么运行，理论上xy都不可能为0的情况
 */
public class DisOrder {
    private static int x = 0,y=0;
    private static int a = 0,b=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        while(true){
            i++;
            x = 0;y=0;
            a = 0;b=0;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            if(x==0 && y==0){
                System.out.println("第"+i+"次实验出现重排序,x="+x+",y="+y);//三十八万次出现重排序
                break;
            }else{
                if(i%10000==0){
                    System.out.println(i);
                }
            }
        }

    }
}
