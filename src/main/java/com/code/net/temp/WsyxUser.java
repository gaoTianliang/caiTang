package com.code.net.temp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("用户")
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

    private static final long serialVersionUID = 1L;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return userpwd - 密码
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * 设置密码
     *
     * @param userpwd 密码
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    /**
     * 获取头像
     *
     * @return userphoto - 头像
     */
    public String getUserphoto() {
        return userphoto;
    }

    /**
     * 设置头像
     *
     * @param userphoto 头像
     */
    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }


    /**
     * 获取身份证号
     *
     * @return idcard - 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号
     *
     * @param idcard 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取unid
     *
     * @return unid - unid
     */
    public String getUnid() {
        return unid;
    }

    /**
     * 设置unid
     *
     * @param unid unid
     */
    public void setUnid(String unid) {
        this.unid = unid == null ? null : unid.trim();
    }

    /**
     * 获取是否授权 0未授权 1已授权
     *
     * @return authorization - 是否授权 0未授权 1已授权
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * 设置是否授权 0未授权 1已授权
     *
     * @param authorization 是否授权 0未授权 1已授权
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization == null ? null : authorization.trim();
    }

    /**
     * 获取状态 1可用 0 不可用
     *
     * @return status - 状态 1可用 0 不可用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 1可用 0 不可用
     *
     * @param status 状态 1可用 0 不可用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记（1：正常；0：删除）
     *
     * @return del_flag - 删除标记（1：正常；0：删除）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记（1：正常；0：删除）
     *
     * @param delFlag 删除标记（1：正常；0：删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", userpwd=").append(userpwd);
        sb.append(", userphoto=").append(userphoto);
        sb.append(", nickname=").append(nickname);
        sb.append(", mobile=").append(mobile);
        sb.append(", idcard=").append(idcard);
        sb.append(", openid=").append(openid);
        sb.append(", unid=").append(unid);
        sb.append(", authorization=").append(authorization);
        sb.append(", status=").append(status);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}