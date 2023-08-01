package mix;

public class ReverseKGroup {
    /**
     这一题的思路，是先判定当前段长度能否满足k，不满足就直接退出
     如果能满足，则反转这一段，接着将新的段尾的下一位设置为新的head，直到结束未知
     我们需要两个辅助函数，一个判断当前是否小于k，并找到尾部，一个负责进行翻转，并返回头尾节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //链表题遇事不决先dummy
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        //一个重要参数，我们要知道当前段组的前置节点
        ListNode groupPrev = dummy;
        //一个重要参数，我们要知道当前段组的尾部的下一段的头节点
        ListNode groupNext = null;
        while(head!=null){
            //先测距，不足就直接退出
            ListNode kTail = getKth(head,k);
            //如果到头了就退出
            if(kTail == null) break;
            //更新groupNext
            groupNext = kTail.next;

            ListNode[] group = reverse(head,kTail);
            //先将之前的prev指向反转后的现头节点
            groupPrev.next = group[0];
            //接着将当前的尾部指向下一个头节点
            group[1].next = groupNext;
            //将当前的prev的下一个指向groupNext，之前保存过的
            groupPrev = group[1];

            head = groupNext;
        }
        return dummy.next;
    }

    //第一个是得到kth
    public ListNode getKth(ListNode node,int k){
        while(node!=null && k>1){
            node=node.next;
            k--;
        }
        return node;
    }

    //反转并得到首尾，用这个操作
    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode cur = head;
        //熟练的切换，指导原本的prev变成原本的tail为止
        while(prev!=tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
