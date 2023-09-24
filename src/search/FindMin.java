package search;

/**
 * 个数组先递减再递增，如何找到数组最小数，要求时间复杂度小于O(N)
 */
public class FindMin {
    public int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return arr[low];
    }

}
