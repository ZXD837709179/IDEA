package leetcode;


import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**���ַ������н�ѹ��
 * �ַ���ABCABCABC���ᱻѹ��Ϊ[3|ABC]����֮�����ѹ����
 * ������Ƕ�ף���Ҫ�ݹ�
 * @author Xudong Zhang
 */
public class DecodeString {
	public static void main(String[] args) {
		//ţ�����ĸ�ʽҪ���
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
		//˵������ѹ�����ַ���,j��k��
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
