package JDK8;

import java.util.*;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/30 00:06
 * @description:
 */
public class Tmp {
    static int[][] map = new int[26][26];
    static Set<Integer> set = new HashSet();
    static boolean[] visited = new boolean[26];
    static int[] in = new int[26];
    static List<Integer> list = new ArrayList();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        build(strs);
        topology();
        if(list.size()==set.size()){
            for(int i=0;i<list.size();i++){
                System.out.print((char)(list.get(i)+'a'));
            }
        }else{
            System.out.println("invalid");
        }
    }

    public static void topology(){
        while(list.size()<set.size()){
            int count = 0;
            for(int i=0;i<in.length;i++){
                if(visited[i] && in[i]==0){
                    count++;
                }
            }
            if(count!=1) break;
            for(int i=0;i<in.length;i++){
                if(visited[i] && in[i]==0){
                    list.add(i);
                    visited[i] = false;
                    for(int j=0;j<26;j++){
                        if(map[i][j]>0){
                            in[j]--;
                            map[i][j] =0;
                        }
                    }
                }
            }

        }


    }

    public static void build(String[] strs){
        String pre = strs[0];
        for(int i=0;i<pre.length();i++){
            set.add(pre.charAt(i)-'a');
        }
        for(int j=1;j<strs.length;j++){
            String cur = strs[j];
            for(int i=0;i<cur.length();i++){
                set.add(cur.charAt(i)-'a');
            }

            for(int i=0;i<pre.length()&&i<cur.length();i++){
                int left = pre.charAt(i)-'a';
                int right = cur.charAt(i)-'a';
                if(left==right) continue;
                if(map[left][right] == 1){
                    break;
                }
                in[right]++;
                map[left][right] = 1;
                visited[left] = true;
                visited[right] = true;
                break;//只记录第一个大的，后面的不影响
            }
            pre = cur;
        }
    }
}
