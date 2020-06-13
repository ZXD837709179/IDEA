package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;

public class StringToInt {
    public static int myAtoi(String str) {
        int sig = 1;//��������
        long rel= 0;//���
        str = str.trim();
        char[] chars = str.toCharArray();
        if(chars[0] == '-'){
            sig = -1;
        }else if(chars[0] == '+'){
            sig = 1;
        }else if('0'<=chars[0] && chars[0]<='9'){
            rel = (long)(chars[0]-'0');
        }else{
            return 0;
        }

        for(int i=1; i<chars.length;i++){
            if('0'<=chars[i] && chars[i]<='9'){
                rel = rel*10+chars[i]-'0';
            }else{
                break;
            }
            if(sig*rel > Integer.MAX_VALUE || sig* rel<Integer.MIN_VALUE) {
            	break;//������ܴܺ��ڹ����з���Խ����˳���û�б�Ҫ�ټ�������ȥ
            }
        }

        if(sig*rel > Integer.MAX_VALUE){
                return  Integer.MAX_VALUE;
        }else if(sig* rel<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return sig*(int)rel;
        }
    }
    
    public static void main(String[] args) {
		System.out.println(myAtoi("9223372036854775808"));
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(1,3);
		System.out.println(arrayList.toString());
		System.out.println(arrayList.get(2));




        String s1 = "1b"; // 16������
        BigInteger b = new BigInteger(s1,16);     // 16����ת�ɴ�������\
        System.out.println(b);  //27
        String s2 = b.toString(16);//1b
        String s3 = b.toString();//27
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(new BigInteger("123"));//123


	}
}
