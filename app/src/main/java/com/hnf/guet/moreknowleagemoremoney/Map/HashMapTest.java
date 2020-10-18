package com.hnf.guet.moreknowleagemoremoney.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        //hashMap的遍历方式一
        Iterator<Map.Entry<String,Integer>> entryIterator = hashMap.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String,Integer> next = entryIterator.next();
            System.out.println("key="+next.getKey()+" value="+next.getValue());
        }

        //遍历方式二
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key = "+key+" value = "+hashMap.get(key));
        }

        /**
         * 综合比较下来，是第一种遍历方式更好一点
         */

    }
}
