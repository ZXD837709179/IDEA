package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * �����ض�˳����ַ������뵽��������ʽ
 * @author:ZXD
 * @create:2020-03-13-������
 */
public class DecodeString2 {
	//����ģʽ����
	static Pattern pattern = Pattern.compile("\\[(\\d+)\\|(\\w+)\\]");

	public static void main(String[] args) {

		String tmp = "HG[3|B[2|CA]]F";
		//����ƥ�����
		Matcher matcher = pattern.matcher(tmp);
		while (matcher.find()){
			int num = Integer.parseInt(matcher.group(1));
			String ch = "";
			for (int i = 0; i < num; i++) {
				ch = ch+matcher.group(2);
			}
			tmp = matcher.replaceFirst(ch);
			matcher = pattern.matcher(tmp);

		}

		System.out.println(tmp);

	}

}
