package pass;

import java.util.*;

class lruCache{
    class Node{
        int key;
        int val;
        Node next, prev;
        public Node(int k, int v){
            key = k;
            val = v;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;

    public lruCache(int cap){
        capacity = cap;
        head.next = tail;
        tail.prev = head;
    }
    public void addLast(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    public void remove(Node x){
        Node prev = x.prev;
        Node next = x.next;
        prev.next = next;
        next.prev = prev;
    }

    public Node removeFirst(){
        if (head.next == tail) return null;
        Node next = head.next;
        remove(next);
        return next;
    }

    public void put(int k, int v){
        Node node = new Node(k, v);
        addLast(node);
        if (cache.containsKey(k)){
            Node prev = cache.get(k);
            remove(prev);
        }
        else{
            if (cache.size() == capacity){
                Node temp = removeFirst();
                cache.remove(temp.key);
            }
        }
        cache.put(k, node);
    }
    public int get(int k){
        if (!cache.containsKey(k)) return -1;
        Node node = cache.get(k);
        remove(node);
        addLast(node);
        return node.val;
    }
}

public class lc146 {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;
    int size = 0;
    public lc146(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            cache.remove(key);
        }
        cache.put(key, value);
        if (cache.size() > cap){
            cache.remove(cache.keySet().iterator().next());
        }
    }
}


class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        private int size;
        
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addLast(Node node){
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }
        public void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        public Node removeFirst(){
            if (head.next == tail){
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;            
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    DoubleList dblist = new DoubleList();

    private int cap;
    public LRUCache(int size){
        cap = size;
    }

    public int get(int key){
        if (!map.containsKey(key)) return -1;
        else {
            Node node = map.get(key);
            int val = node.val;
            dblist.remove(node);
            dblist.addLast(node);
            return val;
        }
    }

    public void put(int key, int val){
        Node new_node = new Node(key, val);
        if (map.containsKey(key)){
            Node node = map.get(key);
            map.put(key, new_node);
            dblist.remove(node);
            dblist.addLast(new_node);
        }
        else {
            map.put(key, new_node);
            if (map.size() > cap){
                Node node = dblist.removeFirst();
                map.remove(node.key);
            }
            dblist.addLast(new_node);
        }
    }
}

