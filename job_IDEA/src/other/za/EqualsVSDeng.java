package other.za;

public class EqualsVSDeng {
	/**
	 * == �Ƚϵ��ǻ������͵���ֵ���������͵ĵ�ַ
	 * equals �Ƚϵ���
	 * @param args
	 */
	public static void main(String[] args) {
		  Integer a = 1;
	      Integer b = 2;
	      Integer c = 3;
	      int j = 3;
	      Integer d = 3;
	      Integer e = 321;
	      Integer f = 321;
	      Long g = 3L;
	      Long h = 2L;
	      long i = 3;
	      
	      
	      System.out.println(c==d);//true,�Զ�װ�䣬integer���͵���ֵ��-127-128֮��Ļ�ָ���Ѿ���������ֵ
	      System.out.println(e==f);//false,�Զ�װ��,���ڷ�Χ�ڵ�ÿ�ζ����´���һ���µ�
	      System.out.println(c==(a+b));//true,�漰��ѧ���㣬�Զ�����
	      System.out.println(c==j);//true,Integer��int�Ƚϣ��Ƚϵ�����ֵ
	      System.out.println(c.equals(a+b));//true,�Ȳ��䣬��װ��
	      System.out.println(g==(a+b));//true,int��Long�Ƚ���ֵ,װ��
	      System.out.println(i==j);//long��int�Ƚ���ֵ
	      System.out.println(g.equals(a+b));//false,��װ���equals�������Ƚϵ������ݣ�һ��Longһ��int,��String�Ͱ�װ�඼��д��equals����
	      System.out.println(g.equals(3));//false,��װ���equals�������Ƚϵ������ݣ�һ��Longһ��int,���ȼ�String�Ͱ�װ�඼��д��equals����
	      System.out.println(g.equals(a+h));//true,a+hΪLong����
	}
	
	
	
}
