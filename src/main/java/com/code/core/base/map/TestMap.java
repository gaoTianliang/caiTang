package com.code.core.base.map;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/12/18 9:39
 */
public class TestMap {

    /**
     * map根据键和值排序
     */
    @Test
    public void test() {
        Map<String, Integer> unsortMap = new HashMap<>();
        System.out.println("插入顺序");
        unsortMap.put("z", 10);
        System.out.print("z-10, ");
        unsortMap.put("b", 5);
        System.out.print("b-5, ");
        unsortMap.put("a", 6);
        System.out.print("a-6, ");
        unsortMap.put("c", 20);
        System.out.print("c-20, ");
        unsortMap.put("d", 1);
        System.out.print("d-1, ");
        unsortMap.put("e", 7);
        System.out.print("e-7, ");
        unsortMap.put("y", 8);
        System.out.print("y-8, ");
        unsortMap.put("n", 99);
        System.out.print("n-99, ");
        unsortMap.put("j", 50);
        System.out.print("j-50, ");
        unsortMap.put("m", 2);
        System.out.print("m-2, ");
        unsortMap.put("f", 9);
        System.out.println("f-9");

        System.out.println("原始数据");
        System.out.println(unsortMap);

        //根据键排序
        Map<String, Integer> result = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        System.out.println("根据键排序");
        System.out.println(result);

        //根据值排序
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(d->result2.put(d.getKey(),d.getValue()));
        System.out.println("根据值排序");
        System.out.println(result2);
    }

    /**
     * 根据键值排序（String）
     */
    @Test
    public void testSortByKey(){
        // 创建一个字符串为Key，数字为值的map
        Map<String, Integer> budget = new HashMap<>();
        budget.put("0", 120);
        budget.put("5", 150);
        budget.put("2", 100);
        budget.put("4", 130);
        budget.put("3", 1150);
        budget.put("1", 90);
        System.out.println("排序前: " + budget);
        // 按值排序 升序
        Map<String, Integer> sorted = budget
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        System.out.println("升序按值排序后的map: " + sorted);
        // 按值排序降序
        sorted = budget
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        System.out.println("降序按值排序后的map: " + sorted);
    }
}
