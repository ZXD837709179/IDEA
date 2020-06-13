package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * 满足特定顺序的字符串，想到用正则表达式
 * @author:ZXD
 * @create:2020-03-13-星期五
 */
public class DecodeString2 {
	//创建模式对象
	static Pattern pattern = Pattern.compile("\\[(\\d+)\\|(\\w+)\\]");

	public static void main(String[] args) {

		String tmp = "HG[3|B[2|CA]]F";
		//创建匹配对象
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
