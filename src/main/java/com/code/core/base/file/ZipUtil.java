package com.code.core.base.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        //判断是否为目录s
        if (f.isDirectory()) {
            File[] listFiles = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (File file : listFiles) {
                zip(out, file, base + file.getName());
            }
        } else {
            //压缩目录中的所有文件
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
        }
    }

    /**
     * 将指定路径的文件及其子文件压缩
     * @param inputFileName 要压缩的文件地址 D:\temp\testZip 或者 D:\temp\testZip\AppletContext.java
     * @param zipFileName 压缩包的文件地址 D:\temp\testZip.zip
     * @throws Exception
     */
    public static void zipFile(String inputFileName,String zipFileName) throws Exception {
        File srcFile = new File(inputFileName);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        if (srcFile.isDirectory()) {
            zip(out, srcFile,"");
        }else {
            zip(out, srcFile,srcFile.getName());
        }
        out.close();
    }

    /**
     *
     * @param filePathMap 要压缩的文件路径
     *                  D:\temp\testZip\java\AppletStub.java : java\AppletStub.java
     *                  D:\temp\testZip\java\AudioClip.java : java\AudioClip.java
     *                  D:\temp\testZip\javax\AccessibleAction.java : javax\AccessibleAction.java
     *                  D:\temp\testZip\javax\AccessibleAttributeSequence.java : javax\AccessibleAttributeSequence.java
     *                  D:\temp\testZip\Applet.java : Applet.java
     *                  D:\temp\testZip\AppletContext.java : AppletContext.java
     * @param zipFileName 压缩包的文件地址 D:\temp\testZip.zip
     * @throws Exception
     */
    public static void zipFile(Map<String,String> filePathMap, String zipFileName) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        for (Map.Entry<String, String> map : filePathMap.entrySet()) {
            zipOutputStream.putNextEntry(new ZipEntry(map.getValue()));
            FileInputStream in = new FileInputStream(map.getKey());
            int b;
            while ((b = in.read()) != -1) {
                zipOutputStream.write(b);
            }
            in.close();
        }
        zipOutputStream.close();
    }

    public static void main(String[] args) {
        try {

//            zipFile("D:\\temp\\testZip\\AppletContext.java","D:\\temp\\testZip.zip");

            Map<String,String> stringMap = new HashMap<>();
            stringMap.put("D:\\temp\\testZip\\java\\AppletStub.java","java\\AppletStub.java");
            stringMap.put("D:\\temp\\testZip\\java\\AudioClip.java","java\\AudioClip.java");
            stringMap.put("D:\\temp\\testZip\\javax\\AccessibleAction.java","javax\\AccessibleAction.java");
            stringMap.put("D:\\temp\\testZip\\javax\\AccessibleAttributeSequence.java","javax\\AccessibleAttributeSequence.java");
            stringMap.put("D:\\temp\\testZip\\Applet.java","Applet.java");
            stringMap.put("D:\\temp\\testZip\\AppletContext.java","AppletContext.java");
            zipFile(stringMap,"D:\\temp\\testZip.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



