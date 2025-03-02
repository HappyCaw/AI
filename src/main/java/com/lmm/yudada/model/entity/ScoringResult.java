package com.lmm.yudada.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 评分结果
 * @TableName scoring_result
 */
@TableName(value ="scoring_result")
public class ScoringResult implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 结果名称，如物流师
     */
    private String resultName;

    /**
     * 结果描述
     */
    private String resultDesc;

    /**
     * 结果图片
     */
    private String resultPicture;

    /**
     * 结果属性集合 JSON，如 [I,S,T,J]
     */
    private String resultProp;

    /**
     * 结果得分范围，如 80，表示 80及以上的分数命中此结果
     */
    private Integer resultScoreRange;

    /**
     * 应用 id
     */
    private Long appId;

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
     * 结果图片
     */
    public String getResultPicture() {
        return resultPicture;
    }

    /**
     * 结果图片
     */
    public void setResultPicture(String resultPicture) {
        this.resultPicture = resultPicture;
    }

    /**
     * 结果属性集合 JSON，如 [I,S,T,J]
     */
    public String getResultProp() {
        return resultProp;
    }

    /**
     * 结果属性集合 JSON，如 [I,S,T,J]
     */
    public void setResultProp(String resultProp) {
        this.resultProp = resultProp;
    }

    /**
     * 结果得分范围，如 80，表示 80及以上的分数命中此结果
     */
    public Integer getResultScoreRange() {
        return resultScoreRange;
    }

    /**
     * 结果得分范围，如 80，表示 80及以上的分数命中此结果
     */
    public void setResultScoreRange(Integer resultScoreRange) {
        this.resultScoreRange = resultScoreRange;
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