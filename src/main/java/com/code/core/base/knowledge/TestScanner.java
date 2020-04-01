package com.code.core.base.knowledge;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/12/26 14:37
 * 获取键盘输入
 */
public class TestScanner {

    /**
     * 获取键盘输入简单使用
     */
    @Test
    public void imple(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String next = scanner.next();
        System.out.println(next);
    }
}
