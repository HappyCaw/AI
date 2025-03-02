package com.lmm.yudada.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户答题记录
 * @TableName user_answer
 */
@TableName(value ="user_answer")
public class UserAnswer implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 应用 id
     */
    private Long appId;

    /**
     * 应用类型（0-得分类，1-角色测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义，1-AI）
     */
    private Integer scoringStrategy;

    /**
     * 用户答案（JSON 数组）
     */
    private String choices;

    /**
     * 评分结果 id
     */
    private Long resultId;

    /**
     * 结果名称，如物流师
     */
    private String resultName;

    /**
     * 结果描述
     */
    private String resultDesc;

    /**
     * 结果图标
     */
    private String resultPicture;

    /**
     * 得分
     */
    private Integer resultScore;

    /**
     * 用户 id
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
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用 id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 应用 id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 应用类型（0-得分类，1-角色测评类）
     */
    public Integer getAppType() {
        return appType;
    }

    /**
     * 应用类型（0-得分类，1-角色测评类）
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
     * 用户答案（JSON 数组）
     */
    public String getChoices() {
        return choices;
    }

    /**
     * 用户答案（JSON 数组）
     */
    public void setChoices(String choices) {
        this.choices = choices;
    }

    /**
     * 评分结果 id
     */
    public Long getResultId() {
        return resultId;
    }

    /**
     * 评分结果 id
     */
    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    /**
     * 结果名称，如物流师
     */
    public String getResultName() {
        return resultName;
    }

    /**
     * 结果名称，如物流师
     */
    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    /**
     * 结果描述
     */
    public String getResultDesc() {
        return resultDesc;
    }

    /**
     * 结果描述
     */
    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    /**
     * 结果图标
     */
    public String getResultPicture() {
        return resultPicture;
    }

    /**
     * 结果图标
     */
    public void setResultPicture(String resultPicture) {
        this.resultPicture = resultPicture;
    }

    /**
     * 得分
     */
    public Integer getResultScore() {
        return resultScore;
    }

    /**
     * 得分
     */
    public void setResultScore(Integer resultScore) {
        this.resultScore = resultScore;
    }

    /**
     * 用户 id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户 id
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