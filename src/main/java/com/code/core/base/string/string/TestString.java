package com.code.core.base.string.string;

import org.junit.Test;

/**
 * 字符串
 */
public class TestString {

    @Test
    public void testLastIndexOf() {
        String s = "aaa";
        int b = s.lastIndexOf("aaa");
        System.out.println(b);
    }

    @Test
    public void testSplit() {
        String s = "aaa,.";
        //转义字符
        String[] split = s.split("\\.");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }

    @Test
    public void testSubstring() {
        String s = "/home/temp/html/z/aa.html";
        //里面可以是字符串
        int i = s.lastIndexOf("/");
        String substring = s.substring(i + 1);
        System.out.println(substring);
    }

    @Test
    public void testReplaceAll() {
        String wjdz = "https://shop.ivygate.cn/upload/20190930/0983fa365f144a9e8e6ed48a65bae483.doc";
        String[] split = wjdz.split("upload/");
        String s1 = split[1];
        //     / 替换为\
        //注意转义字符
        String s = s1.replaceAll("/", "\\\\");
        wjdz = "D:\\temp\\" + s;
        System.out.println(wjdz);
        s = s1.replace("/", "\\");
        wjdz = "D:\\temp\\" + s;
        System.out.println(wjdz);
    }
}
