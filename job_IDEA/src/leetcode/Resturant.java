package leetcode;

import java.util.*;

/**
 * @auther: Xudong Zhang
 * @create: 2020/4/13 23:31
 * @description:
 * https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/submissions/
 */
public class Resturant {

    public List<List<String>> displayTable(List<List<String>> orders) {
        //全部菜名
        HashSet<String> set = new HashSet<>();
        //全部桌子名
        HashSet<String> set2 = new HashSet<>();
        //桌号-菜+数
        HashMap<String, HashMap<String, Integer>> biao = new HashMap();

        for (List<String> order:orders) {
            String tableNum = order.get(1);
            String food = order.get(2);
            set.add(food);
            set2.add(tableNum);
            HashMap<String, Integer> row = biao.get(tableNum);

            if (row == null) {
                HashMap<String, Integer> tmpRow = new HashMap();
                tmpRow.put(food, 1);
                biao.put(tableNum, tmpRow);
            } else {
                Integer n = row.get(food);
                if(n==null){
                    row.put(food, 1);
                }else{
                    row.put(food, row.get(food) + 1);
                }
            }

        }
        ArrayList<String> foodNames = new ArrayList(set);
        Collections.sort(foodNames);
        ArrayList<String> tables = new ArrayList(set2);
        Collections.sort(tables, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1)-Integer.valueOf(o2);
            }
        });

        List<List<String>> res = new ArrayList();
        ArrayList<String> list = new ArrayList();
        list.add("Table");
        for(String f:foodNames){
            list.add(f);
        }
        res.add(list);

        for(String table:tables){
            HashMap<String, Integer> food = biao.get(table);
            List<String> tmp = new ArrayList<>();
            tmp.add(table);
            for(String f:foodNames){
                Integer integer = food.get(f);
                if(integer==null){
                    tmp.add("0");
                }else{
                    tmp.add(String.valueOf(integer));
                }
            }
            res.add(tmp);
        }
        return res;

    }

}
