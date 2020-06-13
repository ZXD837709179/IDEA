package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Xudong Zhang
 * @Date: 2020/4/9 19:03
 * @Description:
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Miji {

    public static void main(String[] args) {
        System.out.println(new Miji().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList();
        ArrayList<Integer> tmp = new ArrayList();

        help(0,nums,tmp,list);
        return list;

    }
    //每一次在tmp的基础上加新的数字，数字的索引最低是i
    //比如说tmp已经是1 2 4了，我们不用考虑1 2 3 因为这是 1 2考虑的
    public void help(int n,int[] nums, ArrayList<Integer> tmp,ArrayList<List<Integer>> list){
       System.out.println(tmp);
        list.add(tmp);
        System.out.println(list);
        for(int i=n;i<1;i++){
            tmp.add(nums[i]); //i及以上才可以加入
            help(i+1,nums,tmp,list);
            tmp.remove(tmp.size()-1);
        }

    }

}
