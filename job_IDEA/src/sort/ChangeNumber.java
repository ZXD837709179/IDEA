package sort;

import java.util.Arrays;

/**
 * �������ֵ����ŷ�ʽ
 * @author Xudong Zhang
 *
 */
public class ChangeNumber {
	//��ʱ������
	public static void change1(int i, int j, int[] array) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	//�����������ܻ����
	public static void change2(int i, int j, int[] array) {
		array[i] = array[i]+array[j];
		array[j] = array[i]-array[j];
		array[i] = array[i]-array[j];
	}
	
	//λ����
	public static void change3(int i,int j, int[] array) {
		array[i] = array[i]^array[j];
		array[j] = array[i]^array[j];//array[i]^array[j]^array[j]=array[i]
		array[i] = array[i]^array[j];//array[i]^array[j]^array[i]=array[j]
	}
	
	
	
	public static void main(String[] args) {
		int[] array = {10,20,30,40,50,60};
		change1(0, 1, array);
		System.out.println("��һ�θ��ģ� "+Arrays.toString(array));
		change2(2, 3, array);
		System.out.println("�ڶ��θ��ģ� "+Arrays.toString(array));
		change3(4, 5, array);
		System.out.println("�����θ��ģ� "+Arrays.toString(array));
	}
}
