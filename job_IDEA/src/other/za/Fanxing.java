package other.za;
/**
 * �Լ����һ�����͵Ļ�ȡ������Сֵ�ĺ���.
 * �����������ֻ�ܽ���Number�����ಢ��ʵ����Comparable�ӿ�,���������͵ļ̳���ʵ���������Ϲ�ϵ
 * @author Xudong Zhang
 *
 */
public class Fanxing {
	
	public <T extends  Number & Comparable<? super T> > T min(T[] nums) {
		if(nums.length ==0 || nums == null) {
			return null;
		}
		T m = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(m.compareTo(nums[i])>0) {        //  �̳�camparable�ӿڣ���Ҫʹ��caompareTo���Ƚϴ�С�����ܵ�������>
				m = nums[i];
			}
		}
		
		return m;
	}
}
