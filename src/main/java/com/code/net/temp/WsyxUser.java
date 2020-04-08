package com.code.net.temp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("用户")
@Data
public class WsyxUser implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("编号")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String userpwd;

    /**
     * 头像
     */
    @ApiModelProperty("用户头像")
    private String userphoto;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机区号")
    private String mobileCode;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;


    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String idcard;

    /**
     * openid
     */
    @ApiModelProperty("微信OPENID")
    private String openid;

    /**
     * unid
     */
    @ApiModelProperty("微信UnionId")
    private String unid;

    /**
     * 是否授权 0未授权 1已授权
     */
    @ApiModelProperty("是否授权 0未授权 1已授权")
    private String authorization;

    /**
     * 状态 1可用 0 不可用
     */
    @ApiModelProperty("状态 1可用 0 不可用")
    private String status;

    @ApiModelProperty("首次登陆时间")
    private Date loginDate;
    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 删除标记（1：正常；0：删除）
     */
    @ApiModelProperty("删除标记（1：正常；0：删除）")
    private String delFlag;
}