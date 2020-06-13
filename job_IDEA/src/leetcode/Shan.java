package leetcode;
import org.omg.CORBA.INTERNAL;

import javax.swing.plaf.FontUIResource;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;
/**
 * @auther: Xudong Zhang
 * @create: 2020/5/23 20:59
 * @description:
 */
public class Shan {
    public static int calculate(int numNodes,int sourceNode,int[][] network,int tmp){
        int count = 0;
        int maxOil = 0;
        for(int i=0;i<network.length;i++){
            int[] nums = network[i];
            if(nums[0] == sourceNode){
                count++;
                maxOil +=Math.min(calculate(numNodes,nums[1],network,nums[2]),nums[2]);
            }
        }
        if(count==0) {
            return tmp;
        }
        return maxOil;
    }


    public static void main(String[] args) {
        int numNodes = 6;
        int sourceNode = 4;
        int[][] network = new int[5][3];
        network[0] = new int[]{4,2,10};
        network[1] = new int[]{4,6,20};
        network[2] = new int[]{4,1,30};
        network[3] = new int[]{1,3,50};
        network[4] = new int[]{1,5,80};
        int calculate = calculate(numNodes, sourceNode, network,Integer.MAX_VALUE);
        System.out.println(calculate);


        int numNodes2 = 9;
        int sourceNode2 = 1;
        int[][] network2 = new int[8][3];
        network2[0] = new int[]{1,2,30};
        network2[1] = new int[]{1,3,10};
        network2[2] = new int[]{2,4,50};
        network2[3] = new int[]{2,6,10};
        network2[4] = new int[]{2,5,10};
        network2[5] = new int[]{4,9,1};
        network2[6] = new int[]{6,7,10};
        network2[7] = new int[]{5,8,10};
        int calculate2 = calculate(numNodes2, sourceNode2, network2, Integer.MAX_VALUE);
        System.out.println(calculate2);
    }
}
