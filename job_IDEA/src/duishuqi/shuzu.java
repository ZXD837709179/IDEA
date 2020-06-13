package duishuqi;

/**
 * @auther: Xudong Zhang
 * @create: 2020/6/9 10:15
 * @description:
 */
public class shuzu {
    //生成一个随机大小，最大数随机的数组,maxSize为数组最大个数，maxNum为数组元素最大值
    public static int[] generateRandomArray(int maxSize, int maxNum) {
        int[] arr = new int[(int) ((maxSize+1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(maxNum+1)) - (int)(Math.random()*maxNum);
        }
        return arr;
    }
    //生成一个随机的字符串,最大的字符为c
    public static String generateRandomString(int maxLength,char cc){
        double t = Math.random();
        while(t==0){
            t = Math.random();
        }
        int len = (int)(t*(maxLength))+1;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<len;i++){
            double d = Math.random();
            while(d==0){
                d = Math.random();
            }
            char tmp = (char)((int)(d*(cc-'a'+1)+'a'));
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println(generateRandomString(10,'z'));
        }
    }
    //判断两个数组是否完全相同
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        return true;
    }

}
