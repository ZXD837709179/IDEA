package sort;

import java.util.Arrays;
/**
 * ϣ�����򣬲��ȶ������㷨��ϣ�������һ��ͻ��O(n*n)�������㷨��ƽ�����Ӷ�n^1.3
 * ��õ�ʱ�临�Ӷ�Ϊn,���Ϊn^2��
 * �Ǽ򵥲�������ĸĽ���
 * @author Xudong Zhang
 */
public class ShellSort {
	public static void sort(int[] a) {
		for(int gap = a.length/2; gap>0; gap = gap/2) {//����,ÿ��ô���������Ϊһ��
			//ֱ�Ӵӵ�gap����ʼ������ֱ�Ӳ�������
			for(int i=gap; i<a.length; i++) {
				//��ǰ���ÿһ�����бȽϣ�ѡ�����
				for(int j=i;j-gap>=0;j = j-gap) {
					if(a[j]<a[j-gap]) {
						int tmp = a[j];
						a[j] = a[j-gap];
						a[j-gap] = tmp;
					}
				}
			}
		}
	}
	//ϣ������
	public static void sort2(int[] nums) {
		for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {
			for (int i = gap; i < nums.length; i = i + 1) {
				int cur = nums[i];
				int j = i - gap;
				while (j >= 0 && nums[j] > cur) {
					//�����ǲ��������ܵ���˵sort2�����ǲ�������ĸĽ�
					nums[j + gap] = nums[j];
					j = j - gap;

				}
				nums[j + gap] = cur;
			}
		}
	}

	
	public static void main(String[] args) {
		int[] array = {5,9,6,7,2,3,4};
		System.out.println(Arrays.toString(array));
		sort(array);
		System.out.println(Arrays.toString(array));
	}
}
