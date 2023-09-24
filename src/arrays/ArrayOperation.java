package arrays;

import java.util.HashSet;

/**
 * 对于交集：
 *
 * 将一个数组转换为集合（避免重复）。
 * 遍历另一个数组，检查元素是否在集合中。
 * 如果是，则添加到交集的结果中，并从集合中删除，以防止多次计数。
 * 对于并集：
 *
 * 直接将两个数组转换为集合并合并。
 */
public class ArrayOperation {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
                set1.remove(num); // 为了避免重复计数
            }
        }

        int[] intersection = new int[result.size()];
        int i = 0;
        for (int num : result) {
            intersection[i++] = num;
        }

        return intersection;
    }

    public int[] union(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums1) {
            result.add(num);
        }

        for (int num : nums2) {
            result.add(num);
        }

        int[] union = new int[result.size()];
        int i = 0;
        for (int num : result) {
            union[i++] = num;
        }

        return union;
    }
}


