package mix;

import java.util.HashMap;

public class LRUCache1 {

    //这次不用linkedHashmap写，自己搞一个
    /**
     * 创作一个双向node作为双向链表，然后创作一个hashmap保存数字和node作为键值。
     * 为了使用这个双向链表和hashmap维护。要有addtoHead，添加到头部作为最新节点，
     * removeNode,删除节点，movetoHead将一个已经存在的节点放到最新，removetail删除最老的尾部。
     * 而这一切的维护都由头节点和尾节点维护，它们就像哨兵，作为边界维护头尾附近的节点。put和get都有这些操作来完成
     */
    //先创建双向节点
    class Node{
        int key;//方便删除时少个动作，虽然感觉差
        int val;
        Node prev;
        Node next;
        public Node(){};
        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }

    }
    //创建头尾节点
    Node head,tail;
    //创建哈希表，储存编号和节点，节点保存编号和数值
    HashMap<Integer,Node> cache;
    int size;//列表当前长度
    int capacity;//容量
    public LRUCache1(int capacity) {
        //设置初始值，让头尾相连
        cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    /**
     *
     * @param node，要添加进头部
     *  让head的下一个变成这个node
     * @return
     */
    public void addToHead(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
        cache.put(node.key,node);
    }

    /**
     *
     * @param node,将这个node从当前的node节点删除，还有哈希表也要删
     */
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        cache.remove(node.key);
    }

    /**
     *
     * @param node 将这个节点放到
     */
    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    /**
     *
     */
    public void removeTail(){
        Node node = tail.prev;
        removeNode(node);
    }
    //得到这个node，然后移到首部
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        //情况分为两个，存在与不存在
        Node node = new Node(key,value);
        //如果存在，就删掉老的，把新的换上去
        if(cache.containsKey(key)){
            Node old = cache.get(key);
            removeNode(old);
            addToHead(node);
        }//如果新的，添加时就要看是否超出容量，超出把最老的删掉
        else{
            addToHead(node);
            size+=1;
            if(size>capacity){
                removeTail();
                size--;
            }
        }
    }
}
