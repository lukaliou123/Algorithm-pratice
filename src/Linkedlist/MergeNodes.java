package Linkedlist;

public class MergeNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    // 归并函数，用于分割链表数组，并将分割的部分合并
    private ListNode merge(ListNode[] lists, int left, int right) {
        // 递归终止条件：左索引等于右索引，直接返回对应的链表
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid); // 归并左半部分
        ListNode l2 = merge(lists, mid + 1, right); // 归并右半部分
        return mergeTwoLists(l1, l2); // 将左右两部分合并
    }

    // 合并两个链表的函数
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 虚拟头节点
        ListNode current = dummy; // 当前指针

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 如果一个链表已经合并完，将另一个链表的剩余部分接上
        current.next = l1 == null ? l2 : l1;

        return dummy.next; // 返回虚拟头节点的下一个节点，即合并后的头节点
    }

}
