package bobo.learn.algorithm.leetcode.reallife;

import com.sun.media.sound.DLSInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 关键点：使用哈希表和双向链表，定义dummyHead和dummyTail
 * "使用"的意思，就是被get或者put
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;

        DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, DLinkedNode> map = new HashMap<>();

    DLinkedNode dummyHead = new DLinkedNode(-1, -1);
    DLinkedNode dummyTail = new DLinkedNode(-1, -1);
    private int capacity = 10;
    private int size = 0;

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        moveToHead(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            map.put(key, dLinkedNode);
            size++;
            //判断空间
            if (size > capacity) {
                DLinkedNode remove = removeTail();
                map.remove(remove.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        moveToHead(node);
    }

    public void addHead(DLinkedNode node) {
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DLinkedNode removeTail() {
        DLinkedNode node = dummyTail.pre;
        removeNode(node);
        return node;
    }
}
