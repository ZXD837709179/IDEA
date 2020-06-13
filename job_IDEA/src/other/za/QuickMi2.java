package other.za;

/**
 * @Auther: Xudong Zhang
 * @Date: 2020/4/8 20:16
 * @Description:快速幂，对 Math.pow()的优化，针对help2进行的修改
 */
public class QuickMi2 {
    public static void main(String[] args) {
        double m = 2.0000;
        int n = 10;

        //对于n变量可能是Integer.MIN_VALUE,绝对值超过整数的范围，所以像下面这样更改或者干脆直接改为long
        double res = help2(2,Math.abs(n/2));
        if(Math.abs(n)%2==0){
            res = res*res;
        }else{
            res = res*res*m;
        }

        if(n>0){
            System.out.println(res);
        }else{
            System.out.println(1.0/res);
        }


    }

    //如果n为负数，应该判断，让他变成正数，结果被1.0除
    public static double help2(double m, int n){
        double res = 1;
        double base = m;
        //自然可以设一个数字c=1,然后每次乘以2，与n进行&，但是c可能过int的最大值，所以干脆让n除以2
        while(n!=0){
            if((n&1)==1){
                res = res*base;
            }
            base = base*base;
            n = n>>1;
        }
        return res;
    }
}
