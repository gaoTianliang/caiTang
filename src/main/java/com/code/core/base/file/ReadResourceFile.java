package com.code.core.base.file;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/3/26 16:20
 * 读取resource目录下的文件,读取jar包下的文件
 */
public class ReadResourceFile {

    @Test
    public void  method1() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("file/aa.txt");
        InputStream inputStream =classPathResource.getInputStream();
        System.out.println(inputStream);
    }

    @Test
    public void  method2() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("file/aa.txt");
        System.out.println(inputStream);
    }

    @Test
    public void  method3() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("file/aa.txt");
        System.out.println(inputStream);
    }
}
