package sort;

import java.util.Arrays;

/**
 * 交换数字的三张方式
 * @author Xudong Zhang
 *
 */
public class ChangeNumber {
	//临时变量法
	public static void change1(int i, int j, int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	//算术法，可能会溢出
	public static void change2(int i, int j, int[] array) {
		array[i] = array[i]+array[j];
		array[j] = array[i]-array[j];
		array[i] = array[i]-array[j];
	}
	
	//位运算
	public static void change3(int i,int j, int[] array) {
		array[i] = array[i]^array[j];
		array[j] = array[i]^array[j];//array[i]^array[j]^array[j]=array[i]
		array[i] = array[i]^array[j];//array[i]^array[j]^array[i]=array[j]
	}
	
	
	
	public static void main(String[] args) {
		int[] array = {10,20,30,40,50,60};
		change1(0, 1, array);
		System.out.println("第一次更改： "+Arrays.toString(array));
		change2(2, 3, array);
		System.out.println("第二次更改： "+Arrays.toString(array));
		change3(4, 5, array);
		System.out.println("第三次更改： "+Arrays.toString(array));
	}
}
