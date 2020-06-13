package other.za.classInitOrder;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/7 13:52
 * @description:
 */
public class ClassInitOrder {
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 变量 */
    public String field = "变量";
    /* 静态初始化块 */
    static {
        System.out.println( staticField );
        System.out.println( "静态代码块" );
    }
    /* 初始化块 */
    {
        System.out.println( field );
        System.out.println( "初始化块" );
    }
    /* 构造器 */
    public ClassInitOrder()
    {
        System.out.println( "构造器" );
    }


    public static void main( String[] args )
    {
        new ClassInitOrder();
    }
}
