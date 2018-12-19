package arithmetic.leetcode.easy;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Problem88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int n = 3, m = 3;
        new Problem88().merge(nums1, m, nums2, n);
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int maxMIndex = m - 1;
        int maxNIndex = n - 1;
        while (len-- > 0) {
            if (maxMIndex >= 0 && maxNIndex >= 0) {
                int max = nums1[maxMIndex];
                if (nums1[maxMIndex] >= nums2[maxNIndex]) {
                    maxMIndex--;
                } else {
                    max = nums2[maxNIndex];
                    maxNIndex--;
                }
                nums1[len] = max;
            } else if (maxMIndex >= 0) {
                nums1[len] = nums1[maxMIndex--];
            } else {
                nums1[len] = nums2[maxNIndex--];
            }

        }
    }
}
