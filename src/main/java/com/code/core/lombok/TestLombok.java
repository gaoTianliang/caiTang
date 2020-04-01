package com.code.core.lombok;

import lombok.*;

import java.util.Date;

/**
 * @author sunboyuan
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestLombok {
    /**
     * 编号
     */
    private String id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 作品编号
     */
    private String workId;

    /**
     * 是否喜欢 0 喜欢 1不喜欢
     */
    private String isLike;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 是否删除 0 正常 1 删除
     */
    private String delFlag;

    /**
     * 点赞数
     */
    private String likeCount;
}
