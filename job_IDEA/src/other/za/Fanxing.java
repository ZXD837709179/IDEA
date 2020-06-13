package other.za;
/**
 * 自己设计一个泛型的获取数组最小值的函数.
 * 并且这个方法只能接受Number的子类并且实现了Comparable接口,即参数类型的继承与实现满足以上关系
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
			if(m.compareTo(nums[i])>0) {        //  继承camparable接口，需要使用caompareTo来比较大小，不能单纯的用>
				m = nums[i];
			}
		}
		
		return m;
	}
}
