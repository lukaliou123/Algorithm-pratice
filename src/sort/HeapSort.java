package sort;

public class HeapSort {
    /**
     * 还是不太会手撕堆
     */
    public static void main(String[] args) {
        // 定义一个待排序的数组
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        // 对数组进行快速排序
        sort(arr);
        // 打印排序后的数组
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // 构建大顶堆
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // 初始化最大元素的索引为 i
        int left = 2 * i + 1;  // 左孩子的索引
        int right = 2 * i + 2;  // 右孩子的索引

        // 如果左孩子存在，且大于当前最大元素，则更新最大元素的索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右孩子存在，且大于当前最大元素，则更新最大元素的索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大元素的索引不是 i，说明需要调整堆
        if (largest != i) {
            swap(arr, i, largest);
            // 递归调整子堆，确保子堆也是一个大顶堆
            heapify(arr, n, largest);
        }
    }

    // 交换数组中的两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 堆排序的主函数
    public static void sort(int[] arr) {
        int n = arr.length;

        // 从最后一个非叶子节点开始，向上构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 将堆顶元素（最大元素）与最后一个元素交换，然后调整剩余元素成为新的大顶堆
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
}
