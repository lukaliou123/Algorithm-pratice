package search;

public class LeftMostBinarySearch {
    /**
     *
     这个实现就是为有重复元素的数组设计的。

     当我们在二分查找中找到目标值时，我们不会立即停止。相反，我们会继续在左侧进行查找，以确保我们找到的是目标值的最左侧的索引。

     例如，考虑数组[2,4,4,4,6,7] 和目标值 4
     这个算法会正确地返回索引 1，这是第一个
     4 出现的位置，而不是索引2 或3。

     所以，这个实现可以很好地处理有序数组中的重复元素，并返回目标值的最左侧索引。
     */
    public int leftMostBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // 避免整数溢出
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid; // 当找到目标值时，尝试向左边缩小范围
            }
        }
        // 检查最后的元素是否为目标值
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
