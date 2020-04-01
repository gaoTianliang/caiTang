package com.code.core.base.number;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * 数值类型
 */
public class Number {

    /**
     * 对于 "01" 字符串，转换为int会转换为 1
     */
    @Test
    public void testIntegerParse() {
        String data = "01";
        int i = Integer.parseInt(data);
        System.out.println(i);
    }

    /**
     * 返回小数的位数
     */
    @Test
    public void testDoubleFormat() {
        double a = 1.22222222;
        String format = String.format("%.2f", a);
        System.out.println(format);
    }

    /**
     * 对数字的格式化输出
     */
    @Test
    public void testDecimalFormat() {
        int a = 1;
        DecimalFormat df = new DecimalFormat("000");
        String f1 = df.format(a);  //001
        System.out.println(f1);
    }
}
