package leetcode;

public class Solution {
	
	 public static int GetUglyNumber_Solution(int index) {
	        int count = 0;//����ڼ�������
	        int i = 1;
	        while(count < index){
	            if(isUgly(i)){
	                count++;
	            }
	            i++;
	        } 
	        return i-1;
	 }
	    public static boolean isUgly(int num){
	        //�ж�num�ǲ��ǳ���,��2,3,5������ɸ������ǳ���;
	        while(num !=1 && num % 2 == 0){
	            num = num/2;  
	        }
	        while(num !=1 && num % 3 == 0){
	            num = num/3;
	        }
	        while(num !=1 && num % 5 == 0){
	            num = num/5;   
	        }
	        if(num == 1){
	            return true;
	        }else{
	            return false;    
	        }
	 
	    }
	public static void main(String[] args) {
		//����,1,2,3,4,5,6,8,9,10,11,12,13,
		System.out.println(isUgly(9));
		System.out.println(GetUglyNumber_Solution(1352));
	}
}