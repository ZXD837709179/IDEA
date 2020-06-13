package list;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * 1、TreeSet的元素实现了Comparable接口，重写compareTo方法
 * 2、定义集合TreeSet的时候就要写好比较器对象
 * @author Xudong Zhang
 *
 */
public class TreeSetDemo {
	
	public static void main(String[] args) {
		TreeSet<R> treeSet = new TreeSet<R>();
		treeSet.add(new R(-5));
		treeSet.add(new R(-3));
		treeSet.add(new R(-10));
		treeSet.add(new R(12));
		treeSet.add(new R(10));
		
		System.out.println(treeSet);
		
		Iterator<R> iterator = treeSet.iterator();
		R next = iterator.next();		
		next.count = 10;
		
		System.out.println(treeSet);
		
	}
}
