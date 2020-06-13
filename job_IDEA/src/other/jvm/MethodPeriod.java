package other.jvm;

public class MethodPeriod {
	public static void main(String[] args) {
		String s = new String("a");//“a”在常量池创建，new String()在堆中创建，因此生成了两个对象,s指向堆中
		s.intern();
		String s2 = "a";//说s2指向常量池
		System.out.println(s==s2);
		
		String s3 = new String("a")+new String("a");//常量池的a和堆中的aa
		s3.intern();//1.6及以前方法区不在堆里面，因此需要创建，1.7及以后在堆中，直接引用即可
		String s4 = "aa";//1.8引用堆中的
		System.out.println(s3 == s4);
	}
}
