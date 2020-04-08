package com.code.core.base.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 数值类型
 */
public class Number {

    /**
     * 对保留小数为的处理
     */
    @Test
    public void testXiaoShu(){
        double a = 21.25864726521;

        //保留两位小数，四舍五入
        String format = String.format("%.2f", a);
        System.out.println(format);

        //保留两位小数，四舍五入
        //返回参数中最接近的 long ，其中 long四舍五入为正无穷大。
        long round = Math.round(a * 100);
        double v = (double) round / 100;
        System.out.println(v);

        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        System.out.println(nf.format(a));

        /**
         * BigDecimal.ROUND_HALF_UP表示四舍五入
         * BigDecimal.ROUND_HALF_DOWN也是五舍六入
         * BigDecimal.ROUND_UP表示进位处理（就是直接加1）
         * BigDecimal.ROUND_DOWN表示直接去掉尾数
         */
        double d = 114.145;
        BigDecimal b = new BigDecimal(d);
        d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(d);
    }

    /**
     * 数字和字符串的转换
     */
    @Test
    public void testNumberStringTran() {
        //对于 "01" 字符串，转换为int会转换为 1
        String data = "01";
        int i = Integer.parseInt(data);
        System.out.println(i);

        //对数字的格式化输出
        DecimalFormat df = new DecimalFormat("000.00");
        String f1 = df.format(1.1);  //001
        System.out.println(f1);
    }
}
