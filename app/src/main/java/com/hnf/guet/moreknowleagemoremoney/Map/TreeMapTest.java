package com.hnf.guet.moreknowleagemoremoney.Map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("1","hnf1");
        treeMap.put("2","hnf2");
        treeMap.put("3","hnf3");

        //遍历方式一
        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
        }

        //遍历方式二
        Iterator iterator1 = treeMap.keySet().iterator();
        while (iterator1.hasNext()){
            String key = (String) iterator1.next();
            String value = (String) treeMap.get(key);
        }
    }
}
