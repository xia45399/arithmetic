package arithmetic.leetcode.hard;

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * now 4-9ms 飘忽不定
 */
public class Problem164 {

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(new Problem164().maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = 0;
        for (int i = 1; i < size; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }
}
