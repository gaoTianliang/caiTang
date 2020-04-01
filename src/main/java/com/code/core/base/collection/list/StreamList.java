package com.code.core.base.collection.list;

import com.code.net.pojo.entity.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/3/26 17:28
 */
public class StreamList {

    public static List<String> list = Arrays.asList(
            "aaa", "bbb", "ccc", "ddd", "eee"
    );

    public static List<User> userList = Arrays.asList(
            new User("1", "a", 1),
            new User("2", "b", 22),
            new User("3", "b", 33),
            new User("4", "c", 25)
    );

    /**
     * 根据用户的姓名去重
     */
    @Test
    public void quChong() {
        System.out.println("--------原始数据---------");
        for (User user : userList) {
            System.out.println(user);
        }
        ArrayList<User> collect = userList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))),
                                ArrayList::new
                        ));
        System.out.println("--------处理完成数据---------");
        for (User user : collect) {
            System.out.println(user);
        }
    }

    /**
     * 集合转换为map
     */
    @Test
    public void listToMap() {
        List<User> items = Arrays.asList(new User("000001", "itemId1"),
                new User("0002", "itemId2"),
                new User("0003", "itemId2"));
        // 成员作为value
        Map<String, String> map1 = items.stream().collect(Collectors.toMap(User::getId, User::getItemId));
        System.out.println(map1);
        // 元素作为value
        Map<String, User> map2 = items.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(map2);
        // 键重复取第一个
        Map<String, User> map3 = items.stream().collect(Collectors.toMap(User::getItemId, Function.identity(), (n1, n2) -> n1));
        System.out.println(map3);
        // 键重复自定义异常，指定返回类型
        Map<String, User> map4 = items.stream()
                .collect(Collectors.toMap(User::getItemId, Function.identity(), (a, b) -> {
                    throw new IllegalStateException("自定义异常: " + a + " - " + b);
                }, IdentityHashMap::new));
        System.out.println(map4);
        // Map转Map
        Map<String, String> collect = map1.entrySet().stream()
                .filter(e -> e.getValue().length() > 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect);
    }

    /**
     * 集合数据处理
     */
    @Test
    public void listStream() {
        List<String> strs = Arrays.asList("s123", "s12345", "s123456789");
        List<String> list1 = strs.stream().filter(str -> str.length() > 4).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list1);
        List<String> list2 = strs.stream().filter(str -> str.length() < 5).map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list2);
    }

    /**
     * 集合转换为数组
     */
    @Test
    public void listToArray() {
        List<String> strs = Arrays.asList("s1", "s2", "s3");
        Object[] arr = strs.toArray();
        System.out.println(arr);
        //可以转换为特定类型的数组
        String[] arr2 = strs.stream().toArray(String[]::new);
        System.out.println(arr2);
    }

    /**
     * 字符串集合转换为字符串
     */
    @Test
    public void listStringToString() {
        List<String> strs = Arrays.asList("s1", "s2", "s3");
        //分隔符   前缀    后缀
        String collect = strs.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }
}
