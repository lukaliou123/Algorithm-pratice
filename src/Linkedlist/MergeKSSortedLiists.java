package Linkedlist;

import java.util.PriorityQueue;

public class MergeKSSortedLiists {

    /**
     * 23. 合并 K 个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 思路：直接使用优先队列，将所有linkedlistnode倒进去，再吐出来
     */

    public ListNode mergeKlIst(ListNode[] lists){
        //先设置一个优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        //全放进去，这个时候就排好了
        for(ListNode node:lists){
            //注意判断null
            if(node!=null){
                queue.add(node);
            }
        }

        //设置dummy节点重新连接
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            cur.next=queue.poll();
            cur=cur.next;
            //记住，每次放完后，要判定当前节点的下一个节点可不可以放进优先队列，毕竟原本的储存就一个节点
            if(cur.next!=null){
                queue.add(cur.next);
            }
        }

        return dummy.next;
    }
}
