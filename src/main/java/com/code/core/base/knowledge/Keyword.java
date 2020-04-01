package com.code.core.base.knowledge;

import org.junit.Test;

public class Keyword {

    /**
     * 1.switch语句会根据表达式的值从相匹配的执行，一直执行到break标签处开始ak语句处或者是switch语句的末尾与任一case值
     * 不匹配，则进入default语句(如果有的话)
     * 2.只能处理等值条件判断的情况，且表达式必须为byte，short，int或char类型 ，不能是String或double,float.
     * 3.常量值必须是与表达式类型兼容的特定的一个常量
     * 4.不允许有重复的case值
     * 5.default子句为可选
     */
    @Test
    public void testSwitch() {
        int a = 1;
        switch (a) {
            case 1:
                System.out.println("a=1");
            case 2:
                System.out.println("a=2");
                break;
            case 3:
                System.out.println("a=3");
            default:
                System.out.println("default");
        }
    }

    @Test
    public void testBreak() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j > 3) {
                    break;
                }
                System.out.println(i + "\t" + j);
            }
        }
    }
}
