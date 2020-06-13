package list;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
/**
 * ��һ��������Ӽ��ļ���
 * @author Xudong Zhang
 *
 */
public class Ziji {
		
	    public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>>  list = new ArrayList<>();
	        list.add(new ArrayList<>());
	        for(int i = 0;i<nums.length;i++){
	            int length = list.size();
	            //��һ��ѭ�������е������1���ڶ��ΰ����е������2
	            for(int j = 0;j<length;j++){
	                List<Integer> tmp = new ArrayList<>(list.get(j));//???Ҫ�������ʼ����new ArrayList<>(list);
	                tmp.add(nums[i]);
	                list.add(tmp);
	            }
	        }
	        return list;
	    }
		
		public static void main(String[] args) {
			int[] t = new int[] {1,2,3};
			System.out.println(subsets(t));
		}
	
}
