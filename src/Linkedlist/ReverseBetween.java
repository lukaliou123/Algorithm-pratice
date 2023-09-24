package Linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
// 如果头结点为空或者m等于n，直接返回头结点
        if (head == null || m == n) return head;

        // 创建一个虚拟头结点，并将其指向head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义一个前驱节点，初始化为虚拟头结点
        ListNode pre = dummy;

        // 将前驱节点移动到m-1的位置，为反转做准备
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // 开始反转m到n的节点
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < m-n; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;  // 返回虚拟头结点的下一个节点，也就是真实头结点
    }
    //递归解法，全局递归
    /**
     * ListNode reverse(ListNode head) {
     *     if (head.next == null) return head;
     *     ListNode last = reverse(head.next);
     *     head.next.next = head;
     *     head.next = null;
     *     return last;
     * }
     *
     */
    //本题的递归
    /**
     * ListNode reverseBetween(ListNode head, int m, int n) {
     *     // base case
     *     if (m == 1) {
     *         return reverseN(head, n);
     *     }
     *     // 前进到反转的起点触发 base case
     *     head.next = reverseBetween(head.next, m - 1, n - 1);
     *     return head;
     * }
     *
     */
}
