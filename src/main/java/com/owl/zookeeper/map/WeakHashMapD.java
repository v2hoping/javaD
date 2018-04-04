package com.owl.zookeeper.map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by wanghouping on 2018/3/28.
 *
 * @author houping wang
 */
public class WeakHashMapD {

    public static void main(String[] args) {
        WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<Integer, Integer>();
        Integer a = 1;
        Integer b = 2;
        weakHashMap.put(a, 1);
        weakHashMap.put(b, 2);
        a = null;
        b = null;
        int size = weakHashMap.size();
        System.out.println(size);
        System.gc();
        System.runFinalization();
        System.out.println(size);
    }
}
