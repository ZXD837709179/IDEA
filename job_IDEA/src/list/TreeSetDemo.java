package list;

import java.util.Iterator;
import java.util.TreeSet;
/**
 * 1��TreeSet��Ԫ��ʵ����Comparable�ӿڣ���дcompareTo����
 * 2�����弯��TreeSet��ʱ���Ҫд�ñȽ�������
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
