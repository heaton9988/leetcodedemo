package toutiao;

import java.util.ArrayList;
import java.util.HashMap;

public class AllOne {
    class Node {
        Node pre, next;
        int val;
        ArrayList<String> content;

        public Node(int val, boolean isData) {
            this.val = val;
            if (isData) this.content = new ArrayList<>();
        }
    }

    class DoubleLinkedList {
        Node head, tail;

        public DoubleLinkedList() {
            head = new Node(0, false);
            tail = new Node(0, false);
            head.next = tail;
            tail.pre = head;
        }

        // 在base前插入节点
        public void insertNodeAtPre(Node base, Node node) {
            node.pre = base.pre;
            base.pre.next = node;
            node.next = base;
            base.pre = node;
        }

        // 在base后插入节点
        public void insertNodeAtNext(Node base, Node node) {
            node.next = base.next;
            base.next.pre = node;
            base.next = node;
            node.pre = base;
        }

        public void deleteNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    HashMap<String, Node> dict;
    DoubleLinkedList list;

    public AllOne() {
        dict = new HashMap<>();
        list = new DoubleLinkedList();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int num = 0;
        if (dict.containsKey(key)) {
            num = dict.get(key).val;
            Node base = dict.get(key);
            if (base.content.size() == 1 && base.next.val != num + 1) {
                base.val = num + 1;
            } else {
                base.content.remove(key);
                if (base.next.val == num + 1) {
                    base.next.content.add(key);
                    dict.put(key, base.next);
                } else {
                    Node node = new Node(num + 1, true);
                    node.content.add(key);
                    list.insertNodeAtNext(base, node);
                    dict.put(key, node);
                }
                if (base.content.isEmpty()) list.deleteNode(base);
            }
        } else { // 原先没有这个key, 新增这个key, value=1
            if (list.head.next.val == 1) {
                dict.put(key, list.head.next);
                list.head.next.content.add(key);
            } else {
                Node node = new Node(num + 1, true);
                dict.put(key, node);
                node.content.add(key);
                list.insertNodeAtNext(list.head, node);
            }
        }
    }

    public void dec(String key) {
        if (!dict.containsKey(key)) return;
        Node base = dict.get(key);
        int num = base.val;
        if (base.content.size() == 1) {
            num--;
            if (num == 0) {
                list.deleteNode(base);
                dict.remove(key);
            } else {
                if (base.pre.val == num) {
                    base.pre.content.add(key);
                    list.deleteNode(base);
                    dict.put(key, base.pre);
                } else {
                    base.val = num;
                }
            }
        } else {
            base.content.remove(key);
            num--;
            if (num == 0) {
                dict.remove(key);
            } else {
                if (base.pre.val == num) {
                    base.pre.content.add(key);
                    dict.put(key, base.pre);
                } else {
                    Node node = new Node(num, true);
                    node.content.add(key);
                    list.insertNodeAtPre(base, node);
                    dict.put(key, node);
                }
            }
        }
    }

    public String getMaxKey() {
        return list.tail.pre.content == null ? "" : list.tail.pre.content.get(0);
    }

    public String getMinKey() {
        return list.head.next.content == null ? "" : list.head.next.content.get(0);
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("key");
        obj.dec("key");
        String param_3 = obj.getMaxKey();
        String param_4 = obj.getMinKey();
        System.out.println();
    }
}