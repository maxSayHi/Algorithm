package bobo.learn.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    /**
     *
     * 146. LRUCache Cache
     * Medium
     *
     * Share
     * Design and implement a data structure for Least Recently Used (LRUCache) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache( 2 capacity );
     *
     *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // returns 1
     *cache.put(3,3);    // evicts key 2
     *cache.get(2);       // returns -1 (not found)
     *cache.put(4,4);    // evicts key 1
     *cache.get(1);       // returns -1 (not found)
     *cache.get(3);       // returns 3
     *cache.get(4);       // returns 4
     *
     * https://www.jiuzhang.com/solution/lru-cache/  使用双链表
     *
     */

    int capacity;
    int cnt=0;
    LinkedList<Integer> list = new LinkedList<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int index = list.indexOf(key);
            Integer remove = list.remove(index);
            list.addFirst(remove);
            return map.get(remove);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            int index = list.indexOf(key);
            Integer remove = list.remove(index);
            list.addFirst(remove);
            map.put(key,value);
        }else {
            if(cnt==capacity){
                Integer integer = list.pollLast();
                map.remove(integer);
            }
            list.addFirst(key);
            map.put(key,value);
            if(cnt<capacity)
                cnt++;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );
        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
//        cache.put(1,1);
//        cache.put(2,2);
//        System.out.println(cache.get(1));
//        cache.put(3,3);
//        System.out.println(cache.get(2));
//        cache.put(4,4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
