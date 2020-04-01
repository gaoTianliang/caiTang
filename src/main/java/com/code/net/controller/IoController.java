package com.code.net.controller;

import com.code.net.service.IoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gtl
 * @version 1.0
 * @date 2019/11/15 15:43
 */
@RestController
@RequestMapping("/io")
@Api(tags = "io流")
public class IoController {

    @Autowired
    private IoService ioService;

    @ApiOperation(value = "文件的上传")
    @PostMapping("/upload")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户的id"),
            @ApiImplicitParam(name = "file", value = "上传的头像")
    })
    public Object upload(MultipartFile file, @RequestParam String userId) {
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        return ioService.upload(file,userId);
    }

    /**
     * 下载压缩包
     */
    @PostMapping
    public void downloadZip(HttpServletRequest request, HttpServletResponse response) {
        try {
            ioService.documentsZip(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
