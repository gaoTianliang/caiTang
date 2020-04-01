package com.code.net.controller;

import com.alibaba.excel.EasyExcel;
import com.code.net.listener.QdpxListener;
import com.code.net.pojo.dto.QdpxDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/excel")
@Api(tags = "表格操作")
public class ExcelController {

    public static List<QdpxDTO> list = new ArrayList<>();

    @ApiOperation(value = "导入")
    @GetMapping("/daoRu")
    public String daoRu() {
        String wjdz = "D:\\temp\\test.xlsx";
        //导入excel文件
        try {
            QdpxListener listener = new QdpxListener();
            EasyExcel.read(new FileInputStream(wjdz), QdpxDTO.class, listener).sheet().doRead();
            list = listener.getList();
            System.out.println("=======================");
            for (QdpxDTO qdpxDTO : list) {
                System.out.println(qdpxDTO);
            }
            return list.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/daoChu")
    @ApiOperation(value = "导出")
    public void daoChu(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("监考员安排表", "utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), QdpxDTO.class).sheet("监考员").doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
