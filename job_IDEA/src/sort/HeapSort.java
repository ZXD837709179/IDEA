package sort;

import java.util.Arrays;
/**
 * �������㷨�ĸ��Ӷ���nlogn
 * @author Xudong Zhang
 *
 */
public class HeapSort {
	public static void sort(int[] a) {//����
		//1�������󶥶�,�ڷ�Ҷ�ӽڵ�������ϵ���
		for(int i=a.length/2-1;i>=0;i--) {//i�Ǵӷ�Ҷ�ӽڵ㿪ʼ��,�������ϣ���������
			adjustHeap(a, i, a.length);
		}
		//2�������ѽṹ+�����Զ�Ԫ�غ�ĩβԪ��
		for(int j=a.length-1;j>0;j--) {
			swap(a, 0, j);//ĩβ��Ѷ����н���
			adjustHeap(a, 0, j);
		}
	}	
	
	//�����󶥶ѣ���ķ������棬С�ķ����������Ѿ������õĻ�����
	public static void adjustHeap(int[] a, int i, int length) {
		int tmp = a[i];//ȡ����ǰԪ�أ��ڵ�ǰԪ�����µ���˳��
		for(int k =i*2+1; k < length; k = k * 2 + 1) {
			if(k+1<length && a[k]<a[k+1]) {//��������ֵ����һЩ
				k++;
			}
			//ע����a[k]>tmp������a[k]>a[i]
			if(a[k]>tmp) {//�ӽڵ���ڸ��ڵ�,���ӽڵ�ֵ�������ڵ㣨���ý��н�����
				a[i]=a[k];
				i = k;
			}else {
				break;
			}
		}
		a[i] = tmp;
	}

	//����С����
	public static void sort2(int[] a) {//����
		for(int i=a.length/2-1;i>=0;i--) {
			adjustHeap2(a, i, a.length);
		}
		for(int i=a.length-1;i>=0;i--) {
			swap(a,0,i);
			adjustHeap2(a, 0, i);
		}		
	}

	public static void adjustHeap2(int[] a, int i, int length) {
		//�ѵ�i��λ�ü����������������λ�ã�������С����
		int tmp = a[i];
		for(int j=2*i+1;j<length;j=2*j+1) {
			if(j+1<length && a[j]>a[j+1]) {//������С
				j++;
			}
			if(a[j]<tmp) {
				a[i] = a[j];
				i = j;
			}else {
				break;
			}
		}
		a[i] = tmp;
	}

	
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] array = {50,10,90,30,70,40,80,60,20};
		System.out.println(Arrays.toString(array));
		sort2(array);
		System.out.println(Arrays.toString(array));
	}
}
