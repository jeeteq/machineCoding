package multilevelcache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache<K, V> {

    Map<K, Node<K, V>> cacheMap;
    PriorityQueue<Node<K, V>> pq;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
    }

    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    public boolean isFull() {
        return cacheMap.size() == capacity;
    }

    public void evict() {
        Node<K, V> node = pq.poll();
        cacheMap.remove(node.key);
    }

    public V get(K key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        Node<K, V> node = cacheMap.get(key);
        pq.remove(node);
        node.freq++;
        pq.add(node);
        return node.value;
    }

    public K getEvictedKey() {
        return pq.peek().key;
    }

    public V getEvictedValue() {
        return pq.peek().value;
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            pq.remove(node);
            node.freq++;
            pq.add(node);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            cacheMap.put(key, newNode);
            pq.add(newNode);
        }
    }

    public void removeKey(K key) {
        Node<K, V> node = cacheMap.get(key);
        cacheMap.remove(key);
        pq.remove(node);
    }

    public static class Node<K, V> {
        K key;
        V value;
        int freq;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
}
