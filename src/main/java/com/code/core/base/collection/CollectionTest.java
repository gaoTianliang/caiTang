package com.code.core.base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest {

    @Test
    public void testReverse() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println("反转前");
        for (String s : list) {
            System.out.println(s);
        }
        Collections.reverse(list);
        System.out.println("反转后");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
