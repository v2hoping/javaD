package com.owl.zookeeper.map;

import java.util.*;

/**
 * Created by wanghouping on 2018/3/27.
 *
 * @author houping wang
 */
public class HashMapD {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 3);
        map.put(10, 7);
        map.put(4, 9);
        map.put(20, 6);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        System.out.println("默认排序：");
        for(Map.Entry<Integer, Integer> entry : set) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        //按照Key排序，使用TreeMap
        Map<Integer, Integer> keyMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                //倒叙排序
                return o2.compareTo(o1);
            }
        });
        keyMap.putAll(map);
        System.out.println("TreeMap,按照key降序排序：");
        for(Map.Entry<Integer, Integer> entry : keyMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        //按照Key排序，使用ArrayList
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println("ArrayList,按照key升序排序：");
        for(Map.Entry<Integer, Integer> entry : list) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        //按照Value降序
        List<Map.Entry<Integer, Integer>> listValue = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(listValue, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println("ArrayList,按照value降序排序：");
        for(Map.Entry<Integer, Integer> entry : listValue) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }

}
