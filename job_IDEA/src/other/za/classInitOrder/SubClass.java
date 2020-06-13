package other.za.classInitOrder;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/7 17:30
 * @description:
 */
public class SubClass extends Parent{
    /* 静态变量 */
    public static String s_StaticField = "子类--静态变量";
    /* 变量 */
    public String s_Field = "子类--变量";
    /* 静态初始化块 */
    static {
        System.out.println( s_StaticField );
        System.out.println( "2、子类--静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( s_Field );
        System.out.println( "5、子类--初始化块" );
    }
    /* 构造器 */
    public SubClass()
    {
        System.out.println( "6、子类--构造器" );
        System.out.println( "i=" + i + ",j=" + j );
    }


    /* 程序入口 */
    public static void main(String[] args )
    {
        System.out.println( "2.5、子类main方法" );
        new SubClass();
    }
}
