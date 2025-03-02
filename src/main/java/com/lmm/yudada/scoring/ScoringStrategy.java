package com.lmm.yudada.scoring;

import com.lmm.yudada.model.entity.App;
import com.lmm.yudada.model.entity.UserAnswer;

import java.util.List;

/**
 * @Description:
 * @Authod:hp
 * @Date:2025/3/2 9:32
 */
public interface ScoringStrategy {

    UserAnswer doScore(List<String> choices, App app) throws Exception;
}
