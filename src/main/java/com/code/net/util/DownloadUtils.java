package com.code.net.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 下载公共类
 */
public class DownloadUtils {

    public static void downLoadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String filename) {
        try {
            File file = new File(filePath);
            InputStream inStream =new FileInputStream(file);
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称 用于浏览器的下载框中自动显示的文件名
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.toUpperCase().indexOf("MSIE") > 0  || userAgent.contains("Trident")) {
                // IE浏览器
                filename = URLEncoder.encode(filename, "UTF-8");
            }else {
                // 谷歌 firefox
                filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=UTF-8");
            filename = URLEncoder.encode(filename, "utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            response.addHeader("Content-Length", String.valueOf(inStream.available()));
            byte[] c = new byte[2048];
            int len;

            while ((len = inStream.read(c)) > 0){
                response.getOutputStream().write(c, 0, len);
            }
            inStream.close();
//            byte[] b = new byte[1024];
//            int len = 0;
//            FileInputStream fs = new FileInputStream(file);
//            PrintWriter writer = response.getWriter();
//            while ((len = fs.read()) != -1) {
//                writer.write(len);
//            }
//            fs.close();
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  filepath 和 documentname 必须一一对应
     * @param filepath D:\\temp\\aa.txt
     * @param documentname 真实名称.txt
     */
    public static void batchDownLoadFile(String[] filepath, String[] documentname) {
        byte[] buffer = new byte[1024];
        //生成zip文件的临时存放位置
        String strZipPath = "D:\\temp\\" + IdGen.uuid()+ ".zip";
        File file = new File("D:\\temp");
        if (!file.isDirectory() && !file.exists()) {
            // 创建多层目录
            file.mkdirs();
        }
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(strZipPath));
            // 需要同时下载的多个文件
            for (int i = 0; i < filepath.length; i++) {
                File f = new File(filepath[i]);
                FileInputStream fis = new FileInputStream(f);
                System.out.println(documentname[i]);
                out.putNextEntry(new ZipEntry(documentname[i]));
                //设置压缩文件内的字符编码，不然会变成乱码
//                out.setEncoding("GBK");
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();
            File temp = new File(strZipPath);
            if (temp.exists()) {
                temp.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
