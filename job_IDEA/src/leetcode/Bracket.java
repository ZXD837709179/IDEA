package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xudong Zhang
 * @Date: 2020/4/9 09:20
 * @Description:
 *
 *
 * 题目：generateParenthesis()
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bracket {
    public static void main(String[] args) {
        List<String> strings = new Bracket().generateParenthesis(3);
        System.out.println(strings);
        System.out.println("中文");
    }


    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        help(0,0,"",n);
        return list;
    }
    //迭代，1、什么时候出来  2、会出现哪几种情况，考虑全
    //考虑有一些冗余，只需要考虑 左括号小于n和右括号小于左括号即可
    public void help(int left,int right,String s, int n){
        if(s.length()== n*2){
            list.add(s);
            return ;
        }
        if(left == right && left<n){
            help(left+1,right,s+"(",n);
        }
        if(left>right && left<n){
            help(left+1,right,s+"(",n);
            help(left,right+1,s+")",n);
        }
        if(left>right && left==n){
            help(left,right+1,s+")",n);
        }
    }
}
