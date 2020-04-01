package com.code.core.base.core;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    private static List<TestStreamModel> getList() {
        List<TestStreamModel> list = new ArrayList<TestStreamModel>();

        TestStreamModel testStreamModel = new TestStreamModel();

        testStreamModel.setId(2);/*主键*/
        testStreamModel.setName("张三");/*姓名*/
        testStreamModel.setClasses(1);/*班级*/
        testStreamModel.setGrade(1);/*年级*/
        testStreamModel.setScore(80);/*成绩*/
        list.add(testStreamModel);

        TestStreamModel testStreamModel1 = new TestStreamModel();
        testStreamModel1.setId(1);
        testStreamModel1.setName("李四");
        testStreamModel1.setClasses(1);
        testStreamModel1.setGrade(1);
        testStreamModel1.setScore(60);
        list.add(testStreamModel1);

        TestStreamModel testStreamModel2 = new TestStreamModel();
        testStreamModel2.setId(3);
        testStreamModel2.setName("王二麻子");
        testStreamModel2.setClasses(2);
        testStreamModel2.setGrade(1);
        testStreamModel2.setScore(90);
        list.add(testStreamModel2);

        TestStreamModel testStreamModel3 = new TestStreamModel();
        testStreamModel3.setId(4);
        testStreamModel3.setName("王五");
        testStreamModel3.setClasses(2);
        testStreamModel3.setGrade(1);
        testStreamModel3.setScore(59.5);
        list.add(testStreamModel3);

        TestStreamModel testStreamModel4 = new TestStreamModel();
        testStreamModel4.setId(8);
        testStreamModel4.setName("小明");
        testStreamModel4.setClasses(1);
        testStreamModel4.setGrade(2);
        testStreamModel4.setScore(79.5);
        list.add(testStreamModel4);

        TestStreamModel testStreamModel5 = new TestStreamModel();
        testStreamModel5.setId(5);
        testStreamModel5.setName("小红");
        testStreamModel5.setClasses(2);
        testStreamModel5.setGrade(2);
        testStreamModel5.setScore(99);
        list.add(testStreamModel5);

        TestStreamModel testStreamModel6 = new TestStreamModel();
        testStreamModel6.setId(7);
        testStreamModel6.setName("小黑");
        testStreamModel6.setClasses(2);
        testStreamModel6.setGrade(2);
        testStreamModel6.setScore(45);
        list.add(testStreamModel6);

        TestStreamModel testStreamModel7 = new TestStreamModel();
        testStreamModel7.setId(6);
        testStreamModel7.setName("小白");
        testStreamModel7.setClasses(1);
        testStreamModel7.setGrade(2);
        testStreamModel7.setScore(88.8);
        list.add(testStreamModel7);

        TestStreamModel testStreamModel8 = new TestStreamModel();
        testStreamModel8.setId(6);
        testStreamModel8.setName("小白");
        testStreamModel8.setClasses(1);
        testStreamModel8.setGrade(2);
        testStreamModel8.setScore(88.8);
        list.add(testStreamModel8);
        return list;
    }

    /**
     * distinct
     * 去除重复对象（每个属性的值都一样的），需要注意的是要先重写对象TestStreamModel的equals和hashCode方法
     */
    @Test
    public void testDistinct(){
        List<TestStreamModel> list = getList();
        System.out.println("--------去重前---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        List<TestStreamModel> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("--------去重后---------");
        for (TestStreamModel testStreamModel : distinctList) {
            System.out.println(testStreamModel);
        }
    }

    /**
     * sort:排序
     */
    @Test
    public void testSort(){
        List<TestStreamModel> list = getList();
        System.out.println("--------排序前---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        List<TestStreamModel> sortList = list.stream()
                //从小到大
//                .sorted((a, b) -> a.getId() - b.getId())
                .sorted(Comparator.comparingInt(TestStreamModel::getId))
                .collect(Collectors.toList());
        System.out.println("--------排序后---------");
        for (TestStreamModel testStreamModel : sortList) {
            System.out.println(testStreamModel);
        }
    }

    /**
     * filter:过滤
     */
    @Test
    public void testFilter(){
        List<TestStreamModel> list = getList();
        System.out.println("--------过滤前---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        List<TestStreamModel> filterList = list.stream()
                //只留下符合条件的数据
                .filter(t -> t.getScore() < 60)
                .collect(Collectors.toList());
        System.out.println("--------过滤后---------");
        for (TestStreamModel testStreamModel : filterList) {
            System.out.println(testStreamModel);
        }
    }

    /**
     * map:提取
     */
    @Test
    public void testMap(){
        List<TestStreamModel> list = getList();
        System.out.println("--------提取前---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        List<String> mapList = list.stream()
                .map(t -> t.getName())
                .collect(Collectors.toList());
        System.out.println("--------提取后---------");
        for (String s : mapList) {
            System.out.println(s);
        }
    }

    /**
     * sum:统计
     */
    @Test
    public void testSum(){
        List<TestStreamModel> list = getList();
        System.out.println("--------原始数据---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        double sum = list.stream()
                .mapToDouble(t -> t.getScore())
                .sum();
        System.out.println("--------统计结果---------");
        System.out.println("分数之和："+sum);
    }

    /**
     * groupingBy:分组
     * 按照对象中某个属性将list分组
     */
    @Test
    public void testGroupingBy(){
        List<TestStreamModel> list = getList();
        System.out.println("--------原始数据---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        Map<Integer, List<TestStreamModel>> map =
                list.stream().
                        collect(Collectors.groupingBy(t -> t.getGrade()));
        System.out.println("--------按照年级分组---------");
        for (Map.Entry<Integer, List<TestStreamModel>> ma : map.entrySet()) {
            System.out.println(ma.getKey());
            for (TestStreamModel data : ma.getValue()) {
                System.out.println("\t"+data);
            }
        }
        System.out.println("--------先按照年级分组，在按照班级分组---------");
        Map<Integer/*年级id*/,
                Map<Integer/*班级id*/,
                        List<TestStreamModel>>> groupMap =list.stream()
                .collect(
                        Collectors.groupingBy(t -> t.getGrade(),
                        Collectors.groupingBy(t -> t.getClasses()))
                );
        for (Map.Entry<Integer, Map<Integer, List<TestStreamModel>>> mapEntry : groupMap.entrySet()) {
            System.out.println("年级："+mapEntry.getKey());
            for (Map.Entry<Integer, List<TestStreamModel>> listEntry : mapEntry.getValue().entrySet()) {
                System.out.println("\t班级："+listEntry.getKey());
                for (TestStreamModel data : listEntry.getValue()) {
                    System.out.println("\t\t"+data);
                }
            }
        }
        System.out.println("--------先按照年级分组，在按照班级分组，然后计算总分---------");
        Map<Integer/*年级id*/,
                Map<Integer/*班级id*/,Double>> groupNumMap =list.stream()
                .collect(Collectors.groupingBy(
                                t -> t.getGrade(),Collectors.groupingBy(
                                        t -> t.getClasses(),Collectors.summingDouble(t->t.getScore())
                                )
                        ));
        for (Map.Entry<Integer, Map<Integer, Double>> mapEntry : groupNumMap.entrySet()) {
            System.out.println("年级："+mapEntry.getKey());
            for (Map.Entry<Integer, Double> doubleMap : mapEntry.getValue().entrySet()) {
                System.out.println("\t班级:"+doubleMap.getKey()+"\t总分:"+doubleMap.getValue());
            }
        }
    }

    /**
     * 综合使用:计算每个年级每个班的及格人数
     */
    @Test
    public void testStream(){
        List<TestStreamModel> list = getList();
        System.out.println("--------原始数据---------");
        for (TestStreamModel testStreamModel : list) {
            System.out.println(testStreamModel);
        }
        Map<Integer/*年级*/, Map<Integer/*班级*/, Long/*人数*/>> integerMap =
                list.stream()
                        .filter(t -> t.getScore() >= 60)
                        .collect(Collectors.groupingBy(
                                t -> t.getGrade(),
                                Collectors.groupingBy(t -> t.getClasses(),Collectors.counting())
                        ));
        System.out.println("--------结果数据---------");
        for (Map.Entry<Integer, Map<Integer, Long>> entry : integerMap.entrySet()) {
            System.out.println("年级："+entry.getKey());
            for (Map.Entry<Integer, Long> map : entry.getValue().entrySet()) {
                System.out.println("\t班级："+map.getKey()+"\t人数："+map.getValue());
            }
        }
    }
}

@Data
class TestStreamModel{
    private int id;
    private String name;
    private int grade;
    private int classes;
    private double score;
}
