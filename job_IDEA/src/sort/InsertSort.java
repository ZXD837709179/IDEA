package sort;

import java.util.Arrays;

/**
 * �������򣬴ӵ�һ��Ԫ�ؿ�ʼ��һ����ǰ��Ľ��бȽϣ��嵽һ�����ʵĵط�
 * �ȶ������򣬸��Ӷ�Ϊ n*n,��õ�ʱ�临�Ӷ�Ϊn
 * @author Xudong Zhang
 *
 */
public class InsertSort {
	//��λ��
	public static void sort(int[] a) {
		if(a==null || a.length==0)return;//�������������Ϊ�պ�Ϊnull
		
		for(int i=1;i<a.length;i++) {
			int j = i-1;
			int tmp = a[i];
			while(j>=0 && a[j]>tmp) {//a[j]>tmp && j>=0�Ǵ���ģ����жϴ��ڣ����жϲ����ڵ�����
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = tmp;
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {5,4,9,6,7,2,3};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
