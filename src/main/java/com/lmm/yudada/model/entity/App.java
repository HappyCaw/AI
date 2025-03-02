package com.lmm.yudada.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用
 * @TableName app
 */
@TableName(value ="app")
public class App implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用图标
     */
    private String appIcon;

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义，1-AI）
     */
    private Integer scoringStrategy;

    /**
     * 审核状态：0-待审核, 1-通过, 2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    /**
     * 审核人 id
     */
    private Long reviewerId;

    /**
     * 审核时间
     */
    private Date reviewTime;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用名
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 应用描述
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 应用描述
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    /**
     * 应用图标
     */
    public String getAppIcon() {
        return appIcon;
    }

    /**
     * 应用图标
     */
    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    public Integer getAppType() {
        return appType;
    }

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    /**
     * 评分策略（0-自定义，1-AI）
     */
    public Integer getScoringStrategy() {
        return scoringStrategy;
    }

    /**
     * 评分策略（0-自定义，1-AI）
     */
    public void setScoringStrategy(Integer scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    /**
     * 审核状态：0-待审核, 1-通过, 2-拒绝
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 审核状态：0-待审核, 1-通过, 2-拒绝
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 审核信息
     */
    public String getReviewMessage() {
        return reviewMessage;
    }

    /**
     * 审核信息
     */
    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    /**
     * 审核人 id
     */
    public Long getReviewerId() {
        return reviewerId;
    }

    /**
     * 审核人 id
     */
    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 创建用户 id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 创建用户 id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}