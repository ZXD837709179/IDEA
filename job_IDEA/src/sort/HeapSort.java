package sort;

import java.util.Arrays;
/**
 * 堆排序，算法的复杂度是nlogn
 * @author Xudong Zhang
 *
 */
public class HeapSort {
	public static void sort(int[] a) {//升序
		//1、构建大顶堆,在非叶子节点从下往上调整
		for(int i=a.length/2-1;i>=0;i--) {//i是从非叶子节点开始的,从下往上，从右往左
			adjustHeap(a, i, a.length);
		}
		//2、调整堆结构+交换对顶元素和末尾元素
		for(int j=a.length-1;j>0;j--) {
			swap(a, 0, j);//末尾与堆顶进行交换
			adjustHeap(a, 0, j);
		}
	}	
	
	//调整大顶堆，大的放在上面，小的放在下面在已经建立好的基础上
	public static void adjustHeap(int[] a, int i, int length) {
		int tmp = a[i];//取出当前元素，在当前元素往下调整顺序
		for(int k =i*2+1; k < length; k = k * 2 + 1) {
			if(k+1<length && a[k]<a[k+1]) {//右子树的值更大一些
				k++;
			}
			//注意是a[k]>tmp，不是a[k]>a[i]
			if(a[k]>tmp) {//子节点大于父节点,将子节点值赋给父节点（不用进行交换）
				a[i]=a[k];
				i = k;
			}else {
				break;
			}
		}
		a[i] = tmp;
	}

	//构建小顶堆
	public static void sort2(int[] a) {//降序
		for(int i=a.length/2-1;i>=0;i--) {
			adjustHeap2(a, i, a.length);
		}
		for(int i=a.length-1;i>=0;i--) {
			swap(a,0,i);
			adjustHeap2(a, 0, i);
		}		
	}

	public static void adjustHeap2(int[] a, int i, int length) {
		//把第i个位置及其下面的子树调整位置，构建成小顶堆
		int tmp = a[i];
		for(int j=2*i+1;j<length;j=2*j+1) {
			if(j+1<length && a[j]>a[j+1]) {//右子树小
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
