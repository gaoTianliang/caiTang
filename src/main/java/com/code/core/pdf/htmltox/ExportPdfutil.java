package com.code.core.pdf.htmltox;

import java.io.File;

/**
 * @Author: bysun
 * @Date: 2019/9/3 10:38
 */
public class ExportPdfutil {
    private static final String toPdfTool = "D:\\app\\wkhtmltox\\wkhtmltopdf\\bin\\wkhtmltopdf.exe";
    private static final String whktmlExe = "/usr/local/bin/wkhtmltopdf";
    private static final String whktmlPicExe = "/usr/local/bin/wkhtmltoimage";

    //判断操作系统
    public static Boolean convert(String srcPath, String destPath, String type) {
        Boolean result = true;
        result = convertwin(srcPath, destPath, type);
        return result;
    }

    /**
     * html转pdf
     *
     * @param srcPath  html路径,可以是硬盘上的路径,也可以是网络路径
     * @param destPath pdf保存路径
     * @return转换成功返回true
     */
    public static boolean convertwin(String srcPath, String destPath, String type) {
        final String propertyName = "os.name";
        final String systemName = "Windows";
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在,则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        //创建pdf指令指令   //每个指令和指令之间，必须拼一个空格出来
        StringBuilder cmd = new StringBuilder();
        cmd.append("D:\\app\\wkhtmltox\\wkhtmltopdf\\bin\\wkhtmltopdf.exe");
        /*if (System.getProperty(propertyName).indexOf(systemName) == -1) {
            cmd.append(whktmlExe);
        } else {
            cmd.append(toPdfTool);
        }*/
        cmd.append(" ");
        //设置页的头部边距(默认10mm)
        cmd.append(" --margin-top 0cm");
        //设置页左边距(默认10毫米)
        cmd.append(" --margin-left 0cm");
        cmd.append(" --margin-right 0cm");
        cmd.append(" --margin-bottom 0cm");
        //设置页面的尺寸和页面的宽
        if ("1".equals(type)) {
            cmd.append(" --page-size A4");
            cmd.append(" --page-width 210mm");
        } else {
            cmd.append(" --page-size A3");
            cmd.append(" --page-width 420mm");
        }
        //页面的高
        cmd.append(" --page-height 297mm");
        //设置页码,默认为6
        cmd.append(" --page-offset 1");
        cmd.append(" --disable-smart-shrinking");
        cmd.append(" --zoom 1");
        cmd.append(" ");
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);
        System.out.println(cmd);
        boolean result = true;
        try {
            //操作cmd,将指令放入
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            proc.waitFor();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}