package leetcode;


import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**对字符串进行解压缩
 * 字符串ABCABCABC将会被压缩为[3|ABC]，反之将其解压出来
 * 可能有嵌套，需要递归
 * @author Xudong Zhang
 */
public class DecodeString {
	public static void main(String[] args) {
		//牛客网的格式要清楚
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		scanner.close();
		System.out.println(Decode(next));
	}

	public  static String Decode(String s) {
		int k = -1;
		int j = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				j = i;
			}
			if (s.charAt(i) == ']') {
				k = i;
				break;
			}
		}
		//说明还有压缩的字符串,j左k右
		if (j != -1 && k != -1) {
			String tmp = help(s.substring(j, k + 1));
			String pre = s.substring(0, j);
			String next = s.substring(k + 1);
			s = pre + tmp + next;
			System.out.println("???");
			s = Decode(s);
		}
		return s;

	}

	public static String help(String s) {
		int num = s.indexOf('|');
		String end = s.substring(num+1, s.length()-1);
		int times = Integer.parseInt(s.substring(1, num));
		StringBuffer rel = new StringBuffer();
		for (int i = 0; i < times; i++) {
			rel.append(end);
		}
		return rel.toString();
	}
}
