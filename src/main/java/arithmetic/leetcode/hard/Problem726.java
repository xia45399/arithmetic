package arithmetic.leetcode.hard;

import java.util.*;

public class Problem726 {
    public static void main(String[] args) {
        System.out.println(new Problem726().countOfAtoms("Mg(OH)2"));
        System.out.println(new Problem726().countOfAtoms("H2O"));
        System.out.println(new Problem726().countOfAtoms("K4(ON(SO3)2)2"));
    }

    public String countOfAtoms(String formula) {

        Map<String, Integer> map = new HashMap<>();

        Stack<String> yuansuStack = new Stack<>();
        Map<String, Integer> mulMap = new HashMap<>();

        for (int i = 0; i < formula.length(); i++) {
            char a1 = formula.charAt(i);
            if (a1 >= 'A' && a1 <= 'Z') {
                String yuansu = getYuansu(formula, i);
                //找到元素就要接着找数字了
                Integer size = getSize(formula, i + yuansu.length());
                if (!yuansuStack.isEmpty()) {
                    //需要倍乘的
                    yuansuStack.push(yuansu);
                    mulMap.put(yuansu, size);
                } else {
                    //直接计算总数
                    calc(map, yuansu, size);
                }
                System.out.println("元素" + yuansu + " 数量" + size);
            }
            if (a1 == '(') {
                yuansuStack.push("(");
            }
            if (a1 == ')') {
                while (!yuansuStack.isEmpty()){
                    String key=yuansuStack.pop();
                    if(key==")"){

                    }
                }
                int beishu = getSize(formula, i + 1);
                System.out.println();
                for (Map.Entry<String, Integer> stringIntegerEntry : mulMap.entrySet()) {
                    String yuansu = stringIntegerEntry.getKey();
                    int size = stringIntegerEntry.getValue();
                    calc(map, yuansu, size * beishu);
                }
                mulMap.clear();
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            list.add(item.getKey());
        }
        Collections.sort(list);
        StringBuilder s = new StringBuilder();
        for (String yuansu : list) {
            int size = map.get(yuansu);
            s.append(yuansu);
            if (size > 1) {
                s.append(size);
            }
        }
        return s.toString();
    }

    private void calc(Map<String, Integer> map, String yuansu, Integer size) {
        Integer count = map.get(yuansu);
        if (count == null) {
            count = 0;
        }
        count += size;
        map.put(yuansu, count);
    }

    /**
     * @param formula 化学式
     * @param start   start 第一个大写字母所有
     * @return 元素
     */
    private String getYuansu(String formula, int start) {
        StringBuilder s = new StringBuilder().append(formula.charAt(start));
        for (int j = start + 1; j < formula.length(); j++) {
            char a2 = formula.charAt(j);
            if (a2 >= 'a' && a2 <= 'z') {
                s.append(a2);
                continue;
            }
            break;
        }
        return s.toString();
    }

    private Integer getSize(String forluma, int start) {
        StringBuilder s = new StringBuilder();
        for (int i = start; i < forluma.length(); i++) {
            char c = forluma.charAt(i);
            if (c >= '0' && c <= '9') {
                s.append(c);
                continue;
            }
            break;
        }
        if (s.length() == 0) {
            s.append(1);
        }
        return Integer.valueOf(s.toString());
    }
}
