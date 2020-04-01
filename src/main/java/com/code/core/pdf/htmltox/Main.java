package com.code.core.pdf.htmltox;

import java.io.*;
import java.util.UUID;

public class Main {

    /**
     * 根据html生成html和pdf
     *
     * @param args
     */
    public static void main(String[] args) {

        String html = "aaaaaaaa";
        Integer mblx = 1;

        String savePath = "D:\\temp\\";

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        // 保存到本地
        String htmlPath = savePath + "/html/" + id + ".html";
        String pdfPath = savePath + "/pdf/" + id + ".pdf";
        File file = new File(htmlPath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(htmlPath);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(html);
            fileOutputStream.flush();
            printStream.flush();
            fileOutputStream.close();
            printStream.close();

            //核心代码
            ExportPdfutil.convert(htmlPath, pdfPath, mblx.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
