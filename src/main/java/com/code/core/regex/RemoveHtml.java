package com.code.core.regex;

import org.junit.Test;

public class RemoveHtml {

    /**
     * 去除html代码中含有的标签
     */
    @Test
    public void delHtmlTags() {

        String htmlStr = "<p>46784<strong>46784</strong></p>";

        //定义script的正则表达式，去除js可以防止注入
        String scriptRegex = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        //定义style的正则表达式，去除style样式，防止css代码过多时只截取到css样式代码
        String styleRegex = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        //定义HTML标签的正则表达式，去除标签，只提取文字内容
        String htmlRegex = "<[^>]+>";
        //定义空格,回车,换行符,制表符
        String spaceRegex = "\\s*|\t|\r|\n";

        System.out.println("原始数据");
        System.out.println(htmlStr);
        // 过滤script标签
        htmlStr = htmlStr.replaceAll(scriptRegex, " ");
        System.out.println("过滤script标签");
        System.out.println(htmlStr);
        // 过滤style标签
        htmlStr = htmlStr.replaceAll(styleRegex, " ");
        System.out.println("过滤style标签");
        System.out.println(htmlStr);
        // 过滤html标签
        htmlStr = htmlStr.replaceAll(htmlRegex, " ");
        System.out.println("过滤html标签");
        System.out.println(htmlStr);
        // 过滤空格等
        htmlStr = htmlStr.replaceAll(spaceRegex, "");
        System.out.println("过滤空格等");
        System.out.println(htmlStr);
    }
}











