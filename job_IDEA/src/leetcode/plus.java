package leetcode;
/**
 * 不适用加法进行两个数相加
 * https://blog.csdn.net/surp2011/article/details/51149828
 * @author Xudong Zhang
 *
 */
public class plus {
	public static int myPlus(int i,int j) {
		int sum= i^j;//本位
		int carry = (i&j)<<1;//进位
		while(carry!=0) {
			int a = sum;
			int b = carry;
			sum = a^b;
			carry = (a&b)<<1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(myPlus(12, 39));

	}
}
