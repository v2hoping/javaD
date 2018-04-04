package com.owl.zookeeper.map;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wanghouping on 2018/3/28.
 *
 * @author houping wang
 */
public class ConcureentHashMapD {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println("key:" + next.getKey() + ",value:" + next.getValue());
        }
    }
}
