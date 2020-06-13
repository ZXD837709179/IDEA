package other.za;

import java.util.Scanner;

/**
 * @Auther: Xudong Zhang
 * @Date: 2020/4/8 20:16
 * @Description:快速幂，对 Math.pow()的优化
 */
public class QuickMi {
    public static void main(String[] args) {

        System.out.println(help(23,32 ,1000000007));
        System.out.println(fastPow(23,32 ,1000000007));
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
        System.out.println(Long.MAX_VALUE);


    }


    public static int help(int m, int n,int mod){
        long res = 1;
        long base = m%mod;
        while(n!=0){
            if((n&1)==1){
                res = (res%mod)*(base%mod)%mod;
            }
            base = (base%mod)*(base%mod)%mod;
            n = n>>1;
        }
        return (int)res;
    }
    public static int help2(int m, int n){
        int res = 1;
        int base = m;
        while(n!=0){
            if((n&1)==1){
                res = res*base;
            }
            base = base*base;
            n = n>>1;
        }
        return res;
    }

    public static int fastPow(int a,int b, int mod){
        if(b==0){
            return a%mod;
        }
        long ans  = 1l;
        long base = a%mod;
        while(b!=0){
            if((b&1)==1){
                ans = ans * base % mod;
            }
            b = b>>1;
            base = (base%mod)*(base%mod)%mod;
        }
        return (int)ans;

    }
}
