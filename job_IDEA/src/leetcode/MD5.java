package leetcode;

import com.sun.javafx.image.IntPixelGetter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/19 22:26
 * @description:
 */
public class MD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String str = "qwertyui";
        //MessageDigest为应用程序提供信息摘要类的算法功能;
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(str.getBytes("UTF-8"));
        byte[] digest = md5.digest();

        int i;
        StringBuffer sb = new StringBuffer();
        for (int offset = 0;offset<digest.length;offset++){
            i = digest[offset];
            if(i<0){
                i +=256;
            }
            if(i<16){
                sb.append(i);
            }
            sb.append(Integer.toHexString(i));
        }
        System.out.println(sb.toString());
    }
}
