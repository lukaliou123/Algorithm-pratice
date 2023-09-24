package Linkedlist;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // 创建一个新的头节点，方便操作
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 交换两个节点
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 移动指针到下一对待交换的节点
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
