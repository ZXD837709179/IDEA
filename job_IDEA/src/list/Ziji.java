package list;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
/**
 * 求一个数组的子集的集合
 * @author Xudong Zhang
 *
 */
public class Ziji {
		
	    public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>>  list = new ArrayList<>();
	        list.add(new ArrayList<>());
	        for(int i = 0;i<nums.length;i++){
	            int length = list.size();
	            //第一次循环把所有的数添加1，第二次把所有的数添加2
	            for(int j = 0;j<length;j++){
	                List<Integer> tmp = new ArrayList<>(list.get(j));//???要清楚，初始化是new ArrayList<>(list);
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
