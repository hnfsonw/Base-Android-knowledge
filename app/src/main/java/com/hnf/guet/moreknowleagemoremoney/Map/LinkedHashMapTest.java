package com.hnf.guet.moreknowleagemoremoney.Map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 可以实现顺序读取，即先put进去的键值对会先被get出来
 */

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        map.put("星期一", 40);
        map.put("星期二", 43);
        map.put("星期三", 35);
        map.put("星期四", 55);
        map.put("星期五", 45);
        map.put("星期六", 35);
        map.put("星期日", 30);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        /**
         * 运行结果
         * key: 星期一, value: 40
         * key: 星期二, value: 43
         * key: 星期三, value: 35
         * key: 星期四, value: 55
         * key: 星期五, value: 45
         * key: 星期六, value: 35
         * key: 星期日, value: 30
         */
    }
}
