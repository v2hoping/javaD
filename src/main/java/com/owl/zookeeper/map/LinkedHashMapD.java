package com.owl.zookeeper.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wanghouping on 2018/3/28.
 *
 * @author houping wang
 */
public class LinkedHashMapD {

    public static void main(String[] args) {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>(16, 0.75f, false);
        linkedHashMap.put(1, 10);
        linkedHashMap.put(2, 10);
        linkedHashMap.put(3, 10);
        linkedHashMap.put(4, 10);
        linkedHashMap.put(1, 100);
        Iterator<Map.Entry<Integer, Integer>> iterator = linkedHashMap.entrySet().iterator();
        System.out.println("为false时，按照插入顺序排序:");
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println("key:" + next.getKey() + ",value:" + next.getValue());
        }
        Map<Integer, Integer> linkedHashMapTrue = new LinkedHashMap<Integer, Integer>(16, 0.75f, true);
        linkedHashMapTrue.put(1, 10);
        linkedHashMapTrue.put(2, 10);
        linkedHashMapTrue.put(3, 10);
        linkedHashMapTrue.put(4, 10);
        linkedHashMapTrue.put(1, 100);
        Iterator<Map.Entry<Integer, Integer>> iteratorTrue = linkedHashMapTrue.entrySet().iterator();
        System.out.println("为true时，按照操作顺序排序:");
        while (iteratorTrue.hasNext()) {
            Map.Entry<Integer, Integer> next = iteratorTrue.next();
            System.out.println("key:" + next.getKey() + ",value:" + next.getValue());
        }
    }
}
