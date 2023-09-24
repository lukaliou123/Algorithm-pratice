package hashmap;

/**
 *
 Entry类:
 这是一个内部的静态类，用于表示HashMap中的键值对。每个Entry都包含一个键、一个值和一个指向下一个Entry的引用（在同一索引下的链表中）。

 put(K key, V value):
 这是添加键值对到HashMap的方法。

 首先，计算键的哈希值，并确定它在表中的索引位置。
 如果该索引处已经存在一个或多个键值对，我们就遍历链表检查是否有与新键相同的键。如果有，更新其值并返回旧值。
 如果没有找到相同的键，我们就在该索引处添加一个新的键值对。
 addEntry(K key, V value, int index):
 这个方法会在指定的索引处添加一个新的Entry。当我们添加一个新的Entry时，也会检查当前的size是否超过了载荷因子所允许的最大值。如果超过了，就会调用resize方法。

 resize():
 当HashMap中的元素数量超过了数组的容量与载荷因子的乘积时，数组就需要扩容了。通常情况下，新的容量是原容量的两倍。

 transfer(Entry<K, V>[] newTable):
 这个方法用于将旧表中的所有Entry转移到新表中。对于每一个旧表中的Entry，它会重新计算新的索引并放入新表。

 hash(K key):
 这是用于计算键的哈希值的方法。我们使用键的hashCode()方法，并对其进行一些额外的处理，以增强其分散性。

 indexFor(int hash, int length):
 这个方法将哈希值转换为在表中的索引。因为数组的大小总是2的幂，所以我们可以通过位操作来得到索引。
 */
public class CustomHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Entry<K, V>[] table;

    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V put(K key, V value) {
        int index = indexFor(hash(key), table.length);

        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(key, value, index);
        return null;
    }

    private void addEntry(K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(key, value, e);
        size++;

        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        int newCapacity = oldCapacity << 1;  // Double the capacity

        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    private void transfer(Entry<K, V>[] newTable) {
        for (Entry<K, V> e : table) {
            while (e != null) {
                Entry<K, V> next = e.next;

                int newIndex = indexFor(hash(e.key), newTable.length);
                e.next = newTable[newIndex];
                newTable[newIndex] = e;

                e = next;
            }
        }
    }

    private int hash(K key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    // ... Other methods like get(), remove() ...
}

