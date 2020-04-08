package com.code.net.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel("用户")
@Data
public class WsyxUserVO implements Serializable {

    @ApiModelProperty("编号")
    private String id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String userpwd;
    @ApiModelProperty("用户头像")
    private String userphoto;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("手机区号")
    private String mobileCode;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("身份证号")
    private String idcard;
    @ApiModelProperty("微信OPENID")
    private String openid;
    @ApiModelProperty("微信UnionId")
    private String unid;
    @ApiModelProperty("是否授权 0未授权 1已授权")
    private String authorization;
    @ApiModelProperty("状态 1可用 0 不可用")
    private String status;
    @ApiModelProperty("首次登陆时间")
    private Date loginDate;
    @ApiModelProperty("创建者")
    private String createBy;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;
    @ApiModelProperty("更新者")
    private String updateBy;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateDate;
    @ApiModelProperty("删除标记（1：正常；0：删除）")
    private String delFlag;

}