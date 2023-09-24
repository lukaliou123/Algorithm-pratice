package mix;
import java.util.*;
class LRUCacheTime {
    // 定义节点结构
    class Node {
        int key;
        int value;
        long expireTime; // 过期时间
        Node prev;
        Node next;
    }

    private final int capacity;
    private final long expireMillis; // 过期毫秒数
    private final HashMap<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(); // 链表头部
    private final Node tail = new Node(); // 链表尾部

    public LRUCacheTime(int capacity, long expireMillis) {
        this.capacity = capacity;
        this.expireMillis = expireMillis;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        // 如果节点不存在或已过期，返回-1
        if (node == null || node.expireTime < System.currentTimeMillis()) {
            return -1;
        }
        // 将节点移动到链表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            // 节点已存在，更新值并移动到链表头部
            moveToHead(node);
            return;
        }

        // 如果达到容量，移除最近最少使用的元素
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        // 创建新节点并添加到头部
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        newNode.expireTime = System.currentTimeMillis() + expireMillis; // 设置过期时间
        map.put(key, newNode);
        addToHead(newNode);
    }

    // 将节点移动到链表头部
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // 从链表中移除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 将节点添加到链表头部
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
