package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @version v 1.0 2020/1/5 12:42
 */
public class LruCache146 {



    public static class LruCache {
        int capacity;
        int size;
        Node head;
        Node tail;
        Map<Integer,Node> map;

        public void addFirst(Node node){
            //head->1->2->3
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        public Node removeLast(){
            //1->2->3->tail
            Node temp = tail.pre;
            removeNode(temp);
            return temp;
        }

        public void moveToHead(Node node){
            removeNode(node);
            addFirst(node);
        }

        public void removeNode(Node node){
            //1->2->3
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }


        public LruCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node!=null){
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node==null){
                 node = new Node();
                 node.key = key;
                 node.value = value;
                 if(size==capacity){
                     Node oldNode = removeLast();
                     map.remove(oldNode.key);
                     size--;
                 }
                 addFirst(node);
                 map.put(key,node);
                 size++;
            }else{
                moveToHead(node);
                node.value = value;
            }
        }
    }

    public static class Node{
        int key;
        int value;
        Node next;
        Node pre;
    }



}
