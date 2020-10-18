package com.hnf.guet.moreknowleagemoremoney.Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> setString = new HashSet<> ();
        setString.add("星期一");
        setString.add("星期二");
        setString.add("星期三");
        setString.add("星期四");
        setString.add("星期五");

        Iterator it = setString.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
