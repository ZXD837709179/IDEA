package JDK8;

import java.util.stream.Stream;

public class LamdaScopes{
	static int outerStaticNum;
    int outerNum;
    //局部变量相比，我们对lambda表达式中的实例字段和静态变量都有读写访问权限
    void testScopes() {
    	FunctionInterface<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        FunctionInterface<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
	public static void main(String[] args) {
		//lamda表达式中的局部num隐含为final，不可修改
		int num = 1;
		FunctionInterface<String,Integer> stringConverter =Integer::valueOf;
		FunctionInterface<String,Integer> stringConverter2= (tmp)->Integer.valueOf(tmp)+num;
		System.out.println(stringConverter.convert("2"));// 2
		System.out.println(stringConverter2.convert("2"));// 3
		// num = 3;
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2); // 排序
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a"); // 过滤出以 a 为前缀的元素
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase(); // 转大写
	    })
	    .forEach(s -> System.out.println("forEach: " + s)); // for 循环输出

		
		
	}
}
