package arithmetic.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Problem56 {
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
        List<Interval> list = new ArrayList<>();
        list.add(integer1);
        list.add(integer2);
        list.add(integer3);
        list.add(integer4);
        List<Interval> newList = merge(list);
        //todo now 23ms defeat 0.84
        System.out.println(newList);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = 1;
        int size = intervals.size();
        for (int i = start; i < size; i++) {
            Interval interval1 = intervals.get(i - 1);
            Interval interval2 = intervals.get(i);
            Interval newI = mergeTwo(interval1, interval2);
            if (newI != null) {
                interval1.end = newI.end;
                intervals.remove(i);
                i--;
                size = intervals.size();
            }
        }

        return intervals;
    }

    private static Interval mergeTwo(Interval interval1, Interval interval2) {
        if (interval2.start <= interval1.end) {
            //可以合并
            return new Interval(interval1.start, Math.max(interval1.end, interval2.end));
        }
        return null;
    }
}

