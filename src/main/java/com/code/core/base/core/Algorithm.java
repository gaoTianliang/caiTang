package com.code.core.base.core;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 算法
 */
public class Algorithm {

    /**
     * 比较：i1>i2 return 1; 升序排序、由小到大
     */
    @Test
    public void testMapSort3() {
        Map<String, String> map = new HashMap<>();
        map.put("13:00-15:00", "0");
        map.put("9:00-11:00", "0");
        map.put("16:00-18:00", "0");
        List<String> collect = map.keySet().stream().collect(Collectors.toList());
        collect.stream().sorted((d1, d2) -> {
            d1 = d1.split(":")[0];
            d2 = d2.split(":")[0];
            int i1 = Integer.parseInt(d1);
            int i2 = Integer.parseInt(d2);
            if (i1 > i2) {
                return 1;
            } else {
                return -1;
            }
        }).forEach(d-> System.out.println(d));
    }

    /**
     * 查询两个数组从开头开始有多长重复的数字
     * data1是主要的数据
     */
    @Test
    public void test4() {
        char[] data1 = {1, 3, 8, 5, 9};
//        char [] data2 = {1,3,9,6,8,42};
//        char [] data2 = {1,3,8,5,9,6,8,42};
        char[] data2 = {2, 1, 3, 8, 5, 9, 6, 8, 42};
        int check = this.check(data1, data2, 13, 0, 1);
        System.out.println(check);
    }

    public int check(char[] data1, char[] data2, int maxNum, int n, int m) {
        int result = 0;
        for (int i = n; i < data1.length; i++) {
            if (result > maxNum) {
                return result;
            }
            if (m + 1 > data2.length - 1) {
                return result;
            }
            int i1 = data1[i];
            int i2 = data2[m++];
            if (i1 == i2) {
                result++;
            } else {
                return result;
            }
        }
        return data1.length;
    }

    /**
     * 查询两个数组从开头开始有多长重复的数字
     * data1是主要的数据
     */
    @Test
    public void test3() {
        int[] data1 = {1, 3, 8, 5, 9};
//        int [] data2 = {1,3,9,6,8,42};
//        int [] data2 = {1,3,8,5,9,6,8,42};
        int[] data2 = {2, 3, 8, 5, 9, 6, 8, 42};
        int result = 0;
        for (int i = 0; i < data1.length; i++) {
            if (i > data2.length - 1) {
                System.out.println(result);
            }
            int i1 = data1[i];
            int i2 = data2[i];
            if (i1 == i2) {
                result++;
            } else {
                System.out.println(result);
                break;
            }
        }
        System.out.println(data1.length);
    }

    /**
     * 分配考场
     * 假设考场数目为 10 ,监考人员数目为 8
     */
    @Test
    public void test2() {
//        int a = 8;  //考务员人数
        int b = 2; //余数
        int c = 10;//考场总数
        int d = 1;//每个人最少分配的数目
        int j = 0;
        for (int i = 1; i < c + 1; ) {
            int min = i;
            if (b > 0) {
                b--;
                i++;
            }
            i += d;
            if (min == (i - 1)) {
                System.out.println("考场" + min + ":" + "考务员" + j++);
            } else {
                System.out.println("考场" + min + "-" + (i - 1) + ":" + "考务员" + j++);
            }
        }
    }

    /**
     * 分配考场
     * 假设考场数目为 8 ,监考人员数目为 3
     * 考场1:考务员1
     * 考场2:考务员1
     * 考场3:考务员1
     * 考场4:考务员2
     * 考场5:考务员2
     * 考场6:考务员2
     * 考场7:考务员3
     * 考场8:考务员3
     */
    @Test
    public void test1() {
        long time = new Date().getTime();
        int a = 3;  //考务员人数
        int b = 2; //余数
        int c = 8;//考场总数
        int d = 2;//每个人最少分配的数目
        for (int i = 1; i < c + 1; ) {
            for (int j = 1; j < a + 1; j++) {
                int temp = d;
                if (b > 0) {
                    b--;
                    temp++;
                }
                for (int k = 1; k < temp + 1; k++) {
                    System.out.println("考场" + i + ":" + "考务员" + j);
                    i++;
                    if (i >= c + 1) {
                        break;
                    }
                }
                if (i >= c + 1) {
                    break;
                }
            }
        }
        System.out.println(new Date().getTime() - time);
    }
}
