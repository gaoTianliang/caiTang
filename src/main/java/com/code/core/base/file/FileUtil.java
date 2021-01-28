package com.code.core.base.file;

import com.code.net.util.IdGen;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    /**
     * 将指定路径的文件及其子文件压缩
     *
     * @param inputFileName 要压缩的文件地址 D:\temp\testZip 或者 D:\temp\testZip\AppletContext.java
     * @param zipFileName   压缩包的文件地址 D:\temp\testZip.zip
     * @throws Exception
     */
    public static void zipFile(String inputFileName, String zipFileName) throws Exception {
        File srcFile = new File(inputFileName);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        if (srcFile.isDirectory()) {
            zip(out, srcFile, "");
        } else {
            zip(out, srcFile, srcFile.getName());
        }
        out.close();
    }

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
     * @param filePathMap 要压缩的文件路径
     *                    D:\temp\testZip\java\AppletStub.java : java\AppletStub.java
     *                    D:\temp\testZip\java\AudioClip.java : java\AudioClip.java
     *                    D:\temp\testZip\javax\AccessibleAction.java : javax\AccessibleAction.java
     *                    D:\temp\testZip\javax\AccessibleAttributeSequence.java : javax\AccessibleAttributeSequence.java
     *                    D:\temp\testZip\Applet.java : Applet.java
     *                    D:\temp\testZip\AppletContext.java : AppletContext.java
     * @param zipFileName 压缩包的文件地址 D:\temp\testZip.zip
     * @throws Exception
     */
    public static void zipFile(Map<String, String> filePathMap, String zipFileName) throws Exception {
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

    /**
     * 修改文件的md5值：通过合成空白文件
     *
     * @param nasPath
     * @param basePath
     * @param wjdz
     * @return
     */
    public static String updFileMd5(String nasPath, String basePath, String wjdz) {
        String result = null;

        //  /10/yz_kw/20192/2020-05-20/73a19cbaed9f4c82823e62decfaada8c.pdf
        //旧的答题卡文件
        File ysPdf = new File(nasPath + File.separator + basePath + wjdz);

        // /10/yz_kw/20192/2020-05-20/uuid.pdf
        String newWjdz = wjdz.substring(0, wjdz.lastIndexOf("/") + 1) + IdGen.uuid() + ".pdf";
        String newPath = nasPath + File.separator + basePath + newWjdz;
        //新的答题卡文件
        File newFile = new File(newPath);

        //空白文件
        String blankFilePath = "/home/data/" + IdGen.uuid() + ".txt";
        copyStringToFile(UUID.randomUUID().toString(), blankFilePath);
        File blankFile = new File(blankFilePath);

        /*File blankFile = new File("/home/data/" + IdGen.uuid() + ".pdf");
        if (!blankFile.getParentFile().exists()) {
            blankFile.getParentFile().mkdirs();
        }
        InputStream blankInputStream = getClass().getClassLoader().getResourceAsStream("template/blank.pdf");*/
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
//            FileUtils.copyInputStreamToFile(blankInputStream,blankFile);
            File[] files = {ysPdf, blankFile};
            bos = new BufferedOutputStream(new FileOutputStream(newFile));
            for (File file : files) {
                bis = new BufferedInputStream(new FileInputStream(file));
                int hasRead = 0;
                byte[] b = new byte[1024];
                while ((hasRead = bis.read(b)) != -1) {
                    bos.write(b, 0, hasRead);
                }
            }
            result = newWjdz;
        } catch (IOException e) {
            System.out.println("合成新的答题卡异常");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            blankFile.delete();
        }
        return result;
    }

    /**
     * 将String类型的数据直接转化为文本数据
     *
     * @param str
     * @param filename
     */
    private static void copyStringToFile(String str, String filename) {
        FileWriter out = null;
        try {
            //将Str 转化为文件
            out = new FileWriter(new File(filename));
            char[] chars = str.toCharArray();
            out.write(chars, 0, chars.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    /**
     * 读取文件的json数据
     *
     * @param file
     * @return
     */
    public static String readFile2JsonString(File file) {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader read;
        try {
            read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                buffer.append(lineTxt);
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //学生答题卡VO
        return buffer.toString();
    }

    /**
     * 解压缩文件
     *
     * @param zipFileName
     * @param outputPath
     * @param password    <dependency>
     *                    <groupId>net.lingala.zip4j</groupId>
     *                    <artifactId>zip4j</artifactId>
     *                    <version>1.3.2</version>
     *                    </dependency>
     */
    public void unZip(String zipFileName, String outputPath, String password) {
        try {
            long startTime = new Date().getTime();
            File zipFile = new File(zipFileName);
            ZipFile zFile = new ZipFile(zipFile); // 首先创建ZipFile指向磁盘上的.zip文件
            zFile.setFileNameCharset("GBK");
            File destDir = new File(outputPath); // 解压目录
            if (!destDir.exists()) {// 目标目录不存在时，创建该文件夹
                destDir.mkdirs();
            }
            if (zFile.isEncrypted()) {
                zFile.setPassword(password.toCharArray()); // 设置密码
            }
            zFile.extractAll(outputPath); // 将文件抽出到解压目录(解压)
            List<FileHeader> headerList = zFile.getFileHeaders();
            List<File> extractedFileList = new ArrayList<File>();
            for (FileHeader fileHeader : headerList) {
                if (!fileHeader.isDirectory()) {
                    extractedFileList.add(new File(destDir, fileHeader.getFileName()));
                }
            }
            File[] extractedFiles = new File[extractedFileList.size()];
            extractedFileList.toArray(extractedFiles);
            for (File f : extractedFileList) {
                System.out.println(f.getAbsolutePath() + "文件解压成功!");
            }
            long endTime = new Date().getTime();
            long haoshi = endTime - startTime;
            System.out.println("共耗时：" + haoshi + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改pdf文件的属性
     *
     * @param filePath
     */
    public static void setPdfInfo(String filePath) {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
            pdDocumentInformation.setAuthor("aaaa");
            pdDocumentInformation.setCustomMetadataValue("paperId", IdGen.uuid());
            document.setDocumentInformation(pdDocumentInformation);
            document.save(filePath);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void getPdfInfo(String filePath) {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDDocumentInformation pdDocumentInformation = new PDDocumentInformation();
            String author = pdDocumentInformation.getAuthor();
            System.out.println(author);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         *         <dependency>
         *             <groupId>commons-io</groupId>
         *             <artifactId>commons-io</artifactId>
         *             <version>2.6</version>
         *         </dependency>
         */
        File file = FileUtils.toFile(new URL("https://img-blog.csdnimg.cn/20210127220651370.png"));
        List<String> list = IOUtils.readLines(new InputStreamReader(new FileInputStream(new File("aaa"))));


        System.out.println(file.getAbsolutePath());
        System.out.println("");
    }
}



