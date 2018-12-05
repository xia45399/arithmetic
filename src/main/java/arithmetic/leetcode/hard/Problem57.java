package arithmetic.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Problem57 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public static void main(String[] args) {
        Interval integer1 = new Interval(1, 3);
        Interval integer3 = new Interval(2, 6);
        Interval integer2 = new Interval(6, 10);
        Interval integer4 = new Interval(10, 12);
        Interval newInterval = new Interval(10, 12);
        List<Interval> list = new ArrayList<>();
        list.add(integer1);
        list.add(integer2);
        list.add(integer3);
        list.add(integer4);
        List<Interval> newList = insert(list, newInterval);
        // TODO: 2018/9/24 直接插入法
        System.out.println(newList);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        //56 题的合并
        return null;
    }
}
