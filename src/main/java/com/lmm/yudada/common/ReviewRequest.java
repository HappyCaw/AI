package com.lmm.yudada.common;

import lombok.Data;

/**
 * @Description: 审核请求
 * @Authod:hp
 * @Date:2025/2/28 7:45
 */
@Data
public class ReviewRequest {
    /**
     * 审核状态：0-待审核, 1-通过, 2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    /**
     * app id
     */
    private Long id;
}
