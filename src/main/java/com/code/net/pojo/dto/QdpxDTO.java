package com.code.net.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class QdpxDTO extends BaseRowModel {

    @ExcelProperty("编号")
    private String bh;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private String age;

    @ExcelProperty("生日")
    private String birthday;
}
