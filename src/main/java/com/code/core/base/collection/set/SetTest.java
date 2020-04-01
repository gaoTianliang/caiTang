package com.code.core.base.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/3/26 16:42
 */
public class SetTest {

    /**
     * 验证set加入重复数据时返回的结果
     * 当添加的数据，容器里面已经有的时候返回false
     */
    @Test
    public void testSet() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            boolean add = set.add("1");
            System.out.println(add);
        }
    }
}
