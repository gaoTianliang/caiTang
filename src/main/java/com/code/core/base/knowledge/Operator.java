package com.code.core.base.knowledge;

import org.junit.Test;

/**
 * 运算符
 */
public class Operator {
    /**
     * 异或 相异为1
     */
    @Test
    public void testXor() {
        boolean jsdm = true;
        boolean yhbh = false;
        if (jsdm ^ yhbh) {
            System.out.println("-------");
        }
    }
}
