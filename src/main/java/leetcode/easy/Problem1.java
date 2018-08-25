package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 11, 15};
        int t = 4;
        int[] a = new Problem1().twoSum(nums, t);
        // TODO: 2018/8/25 一次for循环完成
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com) && map.get(com) != i) {
                return new int[]{i, map.get(com)};
            }
        }
        return null;
    }
}
