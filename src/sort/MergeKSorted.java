package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeKSorted {
    public List<Integer> mergeSortedArrays(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<>();
        }

        return mergeHelper(nums, 0, nums.size() - 1);
    }

    private List<Integer> mergeHelper(List<List<Integer>> nums, int left, int right) {
        if (left == right) {
            return nums.get(left);
        }

        int mid = left + (right - left) / 2;

        List<Integer> leftList = mergeHelper(nums, left, mid);
        List<Integer> rightList = mergeHelper(nums, mid + 1, right);

        return mergeTwoLists(leftList, rightList);
    }

    private List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }

        return mergedList;
    }
}