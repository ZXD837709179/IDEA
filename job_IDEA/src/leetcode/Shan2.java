package leetcode;

import java.util.HashSet;

/**
 * @auther: Xudong Zhang
 * @create: 2020/6/6 10:18
 * @description:
 */
public class Shan2 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(20);
        set.add(15);

        set.add(2);
        set.add(3);
        System.out.println(set.remove(3));
        System.out.println(set);
    }
}
