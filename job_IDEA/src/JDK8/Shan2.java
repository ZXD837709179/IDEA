package JDK8;

import org.w3c.dom.ls.LSException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * @auther: Xudong Zhang
 * @create: 2020/4/29 22:16
 * @description:
 */
public class Shan2 {
    public static ArrayList<int[]> res = new ArrayList<>();
    static double total = 0;
    static boolean[] visited;
    static double[][] nums;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = sc.nextDouble();
            }
        }
        visited = new boolean[n];

        help(0,new ArrayList<>());
        System.out.println(String.format("%.2f",total));
        for(int i=0;i<n;i++){
            System.out.println(i+1+" "+res.get(i)[1]);
        }
    }
    public static void help(double count,ArrayList<int[]> list){
        if(list.size()==nums.length){
            if(count>total){
                total = count;
                res.clear();
                res = new ArrayList<>(list);
            }
            return;
        }
        int row = list.size();
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                count +=nums[row][i];
                int[] tmp = new int[2];
                tmp[0] = row+1;
                tmp[1] = i+1;
                list.add(tmp);
                visited[i] = true;
                help(count,list);
                count -=nums[row][i];
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
