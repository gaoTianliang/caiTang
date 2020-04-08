package com.code.net.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.code.net.pojo.dto.QdpxDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//@Component   不能让spring管理，不可以加这个注解
public class QdpxListener extends AnalysisEventListener<QdpxDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QdpxListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    List<QdpxDTO> list = new ArrayList<>();

    public List<QdpxDTO> getList() {
        return list;
    }

    public void setList(List<QdpxDTO> list) {
        this.list = list;
    }

    @Override
    public void invoke(QdpxDTO qdpxDTO, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(qdpxDTO));
        list.add(qdpxDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());

        LOGGER.info("所有数据解析完成！");
    }

}