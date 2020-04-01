package com.code.core.base.junit;

import org.junit.Before;
import org.junit.Test;

public class JunitTest {

    @Test
    public void testJunit() {
        System.out.println("test junit");
    }

    /**
     * @Before ：表示每个方法执行之前都会运行这个里面的内容
     * 可以放入公共代码
     */
    @Before
    public void testBefore(){
        System.out.println("before");
    }
}
