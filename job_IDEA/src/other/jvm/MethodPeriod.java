package other.jvm;

public class MethodPeriod {
	public static void main(String[] args) {
		String s = new String("a");//��a���ڳ����ش�����new String()�ڶ��д����������������������,sָ�����
		s.intern();
		String s2 = "a";//˵s2ָ������
		System.out.println(s==s2);
		
		String s3 = new String("a")+new String("a");//�����ص�a�Ͷ��е�aa
		s3.intern();//1.6����ǰ���������ڶ����棬�����Ҫ������1.7���Ժ��ڶ��У�ֱ�����ü���
		String s4 = "aa";//1.8���ö��е�
		System.out.println(s3 == s4);
	}
}
