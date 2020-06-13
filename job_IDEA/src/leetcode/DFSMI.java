package leetcode;

import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.*;


/**
 * @auther: Xudong Zhang
 * @create: 2020/4/18 22:06
 * @description:
 * https://www.nowcoder.com/questionTerminal/f6d9b2475f904b9abd6c1faa2d2f8703
 */

public class DFSMI {
    static Set<Integer>[] nums;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),k = sc.nextInt();
        nums = new HashSet[n+1];
        //Arrays.fill(nums,new HashSet<>())会让所有的元素公用一个地址，所有元素都一样
        for(int j=1;j<=n;j++){
            nums[j] = new HashSet<Integer>();
        }

        visited = new boolean[n+1];

        while (sc.hasNext()){
            int a = sc.nextInt(),b = sc.nextInt(),c=sc.nextInt();
            if(c==0){
                nums[a].add(b);
                nums[b].add(a);
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){//对于每一个节点判断周围可以移动的不同的节点数,被访问过的就不用判断
                if(!visited[i]){
                    list.add(dfs(i));
                }
        }
        //前面所有的可能很大导致mod以后很小，因此进行加1000000007这样子原先是正数也不影响
        System.out.println((help(n,k)-fastPow(list,k)+1000000007)%1000000007);

    }

    private static int fastPow(List<Integer> list, int k) {
        long res = 0;

        for(Integer i: list){
            int tmp = help(i, k);

            res +=tmp;
            res = res%1000000007;
        }
        return (int)res;
    }

    public static int help(int a,int b){
        long res = 1;
        long base = a;
        int mod = 1000000007;
        while(b>0){
            if((b&1)==1){
                res = (res%mod)*(base%mod)%mod;
            }
            b = b>>1;
            base = (base%mod)*(base%mod)%mod;
        }
        return (int)res;
    }

    public static int dfs(int n){
        visited[n] = true;
        long res = 1;//可能只有他自己，所以不能设置为0然后在res +=1+dfs(i)
        Set<Integer> set = nums[n];

            for( Integer next:set){
                if (!visited[next]){

                    res +=dfs(next);
                }
            }

        return (int)res;
    }
}
