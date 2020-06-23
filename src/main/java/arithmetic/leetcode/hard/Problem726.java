package arithmetic.leetcode.hard;

import java.util.*;

public class Problem726 {
    public static void main(String[] args) {
        String s1 = new Problem726().countOfAtoms("Mg(OH)2((ABO)30He)4");
        String s2 = new Problem726().countOfAtoms("K4(ON(SO3)2)24");
        String s3 = new Problem726().countOfAtoms("HHH");
//        System.out.println(s1);
//        System.out.println(s2);
        System.out.println(s3);


    }

    private String countOfAtoms(String formula) {
        Map<String, Integer> map = count(formula, 1);

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

    private Map<String, Integer> count(String formula, int mult) {
        Map<String, Integer> map = new HashMap<>();

        Stack<Character> position = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            char c1 = formula.charAt(i);
            if (c1 == '(') {
                //todo 找到了括号,匹配子化学式 递归
                position.push('(');
                String childFormula = null;
                int childMult = 1;
                for (int j = i + 1; j < formula.length(); j++) {
                    char c2 = formula.charAt(j);
                    if (c2 == '(') {
                        position.push('(');
                    } else if (c2 == ')') {
                        position.pop();
                        if (position.isEmpty()) {
                            childFormula = formula.substring(i + 1, j);
                            childMult = getSize(formula, j + 1);
                            i = j;
                            break;
                        }
                    }
                }
//                System.out.println("子化学式" + childFormula);
//                System.out.println("倍数" + childMult);
                Map<String, Integer> childMap = count(childFormula, childMult);
                hebingMap(childMap, map);
            } else if (c1 >= 'A' && c1 <= 'Z') {
                String yuansu = getYuansu(formula, i);
                //找到元素就要接着找数字了
                Integer size = getSize(formula, i + yuansu.length());
                Integer oldSize = map.get(yuansu);
                if (oldSize == null) {
                    oldSize = 0;
                }
                map.put(yuansu, oldSize + size);
//                System.out.println("元素" + yuansu + " 数量" + size);
            }
        }
        map.replaceAll((k, v) -> v * mult);
        return map;
    }

    private void hebingMap(Map<String, Integer> childMap, Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : childMap.entrySet()) {
            String yuansu = entry.getKey();
            Integer size = entry.getValue();
            Integer oldSize = map.get(yuansu);
            if (oldSize == null) {
                oldSize = 0;
            }
            map.put(yuansu, size + oldSize);
        }
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
