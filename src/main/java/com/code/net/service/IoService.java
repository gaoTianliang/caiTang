package com.code.net.service;

import com.code.net.util.DownloadUtils;
import com.code.net.util.IdGen;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 下载压缩包
 * @author gtl
 * @version 1.0
 * @date 2019/11/17 15:23
 */
@Service
public class IoService {

    @Value("${file.savepath}")
    private String savepath;
    @Value("${file.webpath}")
    private String webpath;
    @Value("${file.folderpath}")
    private String folderPath;

    /**
     * 将已经存在的文件合并成为一个压缩包
     */
    public void documentsZip(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file1 =new File("D:\\temp\\springBoot");
        if(!file1.exists()){
            file1.mkdirs();
        }
        //临时文件地址
        String path = "D:\\temp\\springBoot\\测试压缩包.txt";
        File file =new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //放入临时文件
        fileOutputStream.write("测试数据".getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        //临时文件
        String[] strings = {"D:\\temp\\springBoot\\测试压缩包.txt"};
        //下载的压缩包里面的文件名称
        String[] strings1 = {"测试压缩包1.txt"};
        DownloadUtils.batchDownLoadFile(strings,strings1);
    }

    /**
     * 文件上传
     * @param file
     * @param userId
     * @return 文件地址
     */
    public String upload(MultipartFile file, String userId) {
        //获取原始的文件名称
        String fileName = file.getOriginalFilename();
        //为防止图片重名，生成一个新的文件名称
        fileName = IdGen.uuid() + fileName.substring(fileName.lastIndexOf("."));
        //根据时间为路径来存储图片
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        //得到存储的真实路径
        String path = savepath + ymd + File.separator;
        //创建文件存储的目录
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //存储文件
        File dest = new File(path+ fileName);
        try {
            //缩略图
            Thumbnails.of(file.getInputStream()).size(840, 430).toFile(path + fileName);
            file.transferTo(dest);
            //把上传的头像信息存储到数据库
            //返回图片的路径
            return folderPath + path + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
