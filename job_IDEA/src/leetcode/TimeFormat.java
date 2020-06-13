package leetcode;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Scanner;

/**
 * @auther: Xudong Zhang
 * @create: 2020/5/19 17:50
 * @description:
 */
public class TimeFormat {
    public static void main(String[] args) throws ParseException {
        //获取当前的时间，毫秒值
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);

        //获取当前系统的时间,形式  Tue May 19 21:40:26 CST 2020
        Date date = new Date();
        System.out.println(date);

        //时间转换
        //date->毫秒
        long time = date.getTime();
        //毫秒->date
        Date date1 = new Date(currentTimeMillis);


        //日期的格式化
        //年yyyy 月MM 日dd 时HH 分mm 秒ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);


        Date da = simpleDateFormat.parse(format);
        System.out.println(da);

    }
}
