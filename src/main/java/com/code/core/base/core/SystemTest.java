package com.code.core.base.core;

import org.junit.Test;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/3/26 17:23
 */
public class SystemTest {

    //查询相对路径
    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
    }
}
