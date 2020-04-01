package com.code.core.base.knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/12/2 20:38
 */
public class Function {

    //普通方法
    {
        //格式
        /*
        [修饰符] 方法返回值类型 方法名(形参列表 ) {
            方法体
            return 返回值；
        }
        */
        //重载
        /*
            一个类中可以定义有相同的名字，但参数不同的多个方法调用时，会根据不同的参数表选择对应的方法。
            判断依据：
                    相同点：同一个类 同一个方法名
                    不同：参数列表不同(类型，个数，顺序不同)
            注意：
                只有返回值不同不构成方法的重载
                只有形参的名称不同，不构成方法的重载
        */
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        testParam(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 对对象参数操作可以保留数据
     * @param list
     */
    public static void testParam(List<String> list){
        list.add("999");
    }
}
