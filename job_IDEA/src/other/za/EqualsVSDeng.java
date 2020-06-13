package other.za;

public class EqualsVSDeng {
	/**
	 * == 比较的是基本类型的数值，引用类型的地址
	 * equals 比较的是
	 * @param args
	 */
	public static void main(String[] args) {
		  Integer a = 1;
	      Integer b = 2;
	      Integer c = 3;
	      int j = 3;
	      Integer d = 3;
	      Integer e = 321;
	      Integer f = 321;
	      Long g = 3L;
	      Long h = 2L;
	      long i = 3;
	      
	      
	      System.out.println(c==d);//true,自动装箱，integer类型的数值在-127-128之间的会指向已经创建的数值
	      System.out.println(e==f);//false,自动装箱,不在范围内的每次都重新创建一个新的
	      System.out.println(c==(a+b));//true,涉及数学运算，自动拆箱
	      System.out.println(c==j);//true,Integer和int比较，比较的是数值
	      System.out.println(c.equals(a+b));//true,先拆箱，在装箱
	      System.out.println(g==(a+b));//true,int和Long比较数值,装箱
	      System.out.println(i==j);//long和int比较数值
	      System.out.println(g.equals(a+b));//false,包装类的equals方法，比较的是内容，一个Long一个int,即String和包装类都重写了equals方法
	      System.out.println(g.equals(3));//false,包装类的equals方法，比较的是内容，一个Long一个int,不等即String和包装类都重写了equals方法
	      System.out.println(g.equals(a+h));//true,a+h为Long类型
	}
	
	
	
}
