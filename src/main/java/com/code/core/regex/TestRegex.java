package com.code.core.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - start()返回匹配到的子字符串在字符串中的索引位置.
 * - end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
 * - group()返回匹配到的子字符串
 */
public class TestRegex {

    /**
     * 去除标点符号
     */
    @Test
    public void test4() {
        String s = "If you are _______ something，you may say, “It’s cool.”";
        System.out.println(s);
        System.out.println(s.replaceAll("[\\pP\\p{Punct}]\\s", " "));
        System.out.println(s.replaceAll("\\s[\\pP\\p{Punct}]", " "));
        System.out.println(s.replaceAll("(\\s[\\pP\\p{Punct}])|([\\pP\\p{Punct}]\\s)", " "));
        System.out.println(s.replaceAll("[^a-zA-Z][\\pP\\p{Punct}][^a-zA-Z] | [\\pP\\p{Punct}]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}][\b]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}/b]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}\b]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}]/b", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}]\b", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}/B]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}]/B", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}\\\\B]", ""));
        System.out.println(s.replaceAll("[\\pP\\p{Punct}]\\\\B", ""));
    }

    @Test
    public void test3() {
        String s = "1. A. In a cinema. B. In a library. C. In a department store. D. In a hotel.";
        System.out.println(Pattern.compile("^[0-9]{1,3}[.][\\s]*[A][.].*$").matcher(s).matches());
    }

    @Test
    public void test2() {
        String s = "agagga123141gjaljg";
        String s1 = "123141g";
        String s2 = "aaad";
        System.out.println(s2.matches("^[a-zA-Z]*"));
        String s3 = "但是现在高铁列车(high-speed trains)的票经 常很快就售罄，尽管发车间隔比较短";
        System.out.println(s3.replaceAll("[(](.*?)[)]", ""));
    }

    @Test
    public void test1() {
        String s = "agagga123141gjaljg";
        String s1 = "123141g";
        Pattern p = Pattern.compile("[0-9]{6}");
        Matcher m = p.matcher(s1);
        boolean matches = m.matches();  //matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        boolean b1 = m.lookingAt();   //对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        boolean b = m.find(); //find()对字符串进行匹配,匹配到的字符串可以在任何位置.   ?? s1 不可以
        if (b) {
            System.out.println("验证码：" + m.group(0));
        } else {
            System.out.println("截取不到验证码！");
        }
    }
}
