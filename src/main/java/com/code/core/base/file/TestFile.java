package com.code.core.base.file;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/12/16 17:40
 */
public class TestFile {

    /**
     * 将桌面下aa文件夹下的两层以内的txt文件复制到查重试卷2文件夹下，保持相对位置不变
     */
    @Test
    void copyFile(){
        try {
            File source = new File("C:\\Users\\gaotianliang\\Desktop\\aa");
            for (File file : source.listFiles()) {
                String name = file.getName();
                for (File listFile : file.listFiles()) {
                    //获取这个文件的内容
                    String data = "";
                    String name1 = listFile.getName();
                    String s = "C:\\Users\\gaotianliang\\Desktop\\查重试卷2\\" + name;
                    File file1 = new File(s);
                    if (!file1.exists()){
                        file1.mkdirs();
                    }
                    BufferedWriter bufw = new BufferedWriter(
                            new FileWriter("C:\\Users\\gaotianliang\\Desktop\\查重试卷2\\" + name + "\\" + name1 + ".txt"));
                    bufw.write(data);
                    bufw.newLine();
                    bufw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
