package com.code.core.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TestPdf {

    /**
     * pdf文件提取
     */
    @Test
    public void test1() {
        File pdfFile = new File("D:\\awork\\project\\7.考务\\查重用资料\\a.pdf");
        PDDocument document;
        InputStream pdfFileInputStream;
        List<String> datas = new ArrayList<>();
        try {
            pdfFileInputStream = new FileInputStream(pdfFile);
            document = PDDocument.load(pdfFileInputStream);
            // 获取页码
            int pages = document.getNumberOfPages();
            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            String content = stripper.getText(document);
            content.replaceAll("(?m)^\\s*$" + System.lineSeparator(), "");  //去除空行
            String[] split = content.split("\r\n");
            for (int i = 0; i < split.length; i++) {
                String s = split[i].trim();
                s = s.replaceAll("．", ".");//将中文.替换为英文
                String regex = "^[0-9]{1,3}[.].*$";  //匹配以数字和小数点开头的字符串
                Pattern p = Pattern.compile(regex);
                if (p.matcher(s).matches()) {  //以为是题干
                    if (s.lastIndexOf("。") == s.length() - 1 || s.lastIndexOf("）") == s.length() - 1) {
                        int starIndex = 1;
                        String[] split1 = s.split("\\.");
                        if (split1.length > 0) {
                            starIndex = split1[0].length();
                        }
                        s = s.substring(starIndex);
                        s = s.replaceAll("[\\pP\\p{Punct}]", "");  //去除所有标点符号
                        s = s.replaceAll(" ", "");
                        datas.add(s);
                    } else {
                        if (i + 1 >= split.length) {
                            break;
                        }
                        split[i + 1] = s + split[i + 1];
                    }
                }
            }
            for (String data : datas) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
