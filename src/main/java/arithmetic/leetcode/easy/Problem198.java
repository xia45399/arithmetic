package arithmetic.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem198 {

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println(new Problem198().rob(nums1));

        int[] nums2 = {30, 1, 2, 100};
        System.out.println(new Problem198().rob(nums2));

        long t1 = System.currentTimeMillis();
        int[] nums3 = {
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
                114, 117, 207, 117, 235, 82, 90, 67, 202, 144, 240,
        };
        int res = new Problem198().rob(nums3);
        long t2 = System.currentTimeMillis();
        System.out.println(res + " 耗时:" + (t2 - t1));
    }

    private int rob(int[] nums, int len, Map<Integer, Integer> map) {
        int total = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[total - 1];
        }
        if (len == 2) {
            return Math.max(nums[total - 1], nums[total - 2]);
        }
        if (map.get(len) != null) {
            return map.get(len);
        }
        int a = nums[total - len] + rob(nums, len - 2, map);
        int b = nums[total - len + 1] + rob(nums, len - 3, map);
        int res = Math.max(a, b);
        map.put(len, res);
        return res;
    }

    public int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return rob(nums, nums.length, map);
    }
}
