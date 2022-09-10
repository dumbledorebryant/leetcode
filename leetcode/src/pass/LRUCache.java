package pass;

import java.util.*;

public class LRUCache {
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
            size = 0;
        }

        public void addLast(Node node){
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            size++;
        }
        public void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
        public Node removeFirst(){
            if (head.next == tail){
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;            
        }
        public int size(){
            return size;
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

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 0);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);
        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }
}
