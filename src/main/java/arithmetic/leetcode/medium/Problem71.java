package arithmetic.leetcode.medium;

import java.util.*;

/**
 * 简化路径
 */
public class Problem71 {
    public static void main(String[] args) {
//        String s1 = "/home//fff";
        String s1 = "/a//b////c/d//././/..";
        System.out.println(new Problem71().simplifyPath(s1));
    }

    public String simplifyPath(String path) {
        String[] arr = path.split("/");

        LinkedList<String> linkedList = new LinkedList<>();
        for (String dir : arr) {
            if(dir.equals("")){
                continue;
            }
            if (dir.equals(".")) {
            } else if (dir.equals("..")) {
                if (!linkedList.isEmpty()) {
                    linkedList.removeLast();
                }
            } else {
                linkedList.add(dir);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!linkedList.isEmpty()) {
            String dir =  linkedList.removeFirst();
            stringBuilder.append("/").append(dir);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }
}
