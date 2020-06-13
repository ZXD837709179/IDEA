package JDK8;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/29 00:27
 * @description:
 */
public class Shan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] nums = sc.nextLine().split(" ");
            LinkedList<String> stack = new LinkedList();
            boolean flag = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i].equals("false") || nums[i].equals("true")) {
                    if (stack.isEmpty() || stack.peek().equals("or")) {
                        stack.push(nums[i]);
                    } else {
                        if (stack.peek().equals("and")) {//前一个是and
                            stack.pop();
                            String tmp = stack.pop();
                            if (tmp.equals("false") || nums[i].equals("false")) {
                                stack.push("false");
                            } else {
                                stack.push("true");
                            }
                        } else {//前一个布尔
                            System.out.println("error");
                            return;
                        }
                    }
                } else {
                    if (stack.isEmpty() || stack.peek().equals("or") || stack.peek().equals("and")) {
                            System.out.println("error");
                            return;
                    } else {
                        stack.push(nums[i]);
                    }
                }
            }

            if(stack.peekLast().equals("or") || stack.peekLast().equals("and")){
                System.out.println("error");
                return;
            }

            while(!stack.isEmpty()){
                String pop = stack.pop();
                if (pop.equals("true")){
                    System.out.println("true");
                    return;
                }
            }
            System.out.println("false");


        }
    }

}
