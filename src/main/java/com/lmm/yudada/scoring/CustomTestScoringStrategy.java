package com.lmm.yudada.scoring;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lmm.yudada.model.dto.question.QuestionContentDTO;
import com.lmm.yudada.model.entity.App;
import com.lmm.yudada.model.entity.Question;
import com.lmm.yudada.model.entity.ScoringResult;
import com.lmm.yudada.model.entity.UserAnswer;
import com.lmm.yudada.model.vo.QuestionVO;
import com.lmm.yudada.service.AppService;
import com.lmm.yudada.service.QuestionService;
import com.lmm.yudada.service.ScoringResultService;
import com.lmm.yudada.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 自定义测评类应用（MBTI）
 * @Authod:hp
 * @Date:2025/3/2 9:41
 */
@ScoringStrategyConfig(appType = 1, scoringStrategy = 0)
public class CustomTestScoringStrategy implements ScoringStrategy {

    @Resource
    private QuestionService questionService;
    
    @Resource
    private ScoringResultService scoringResultService;

    @Override
    public UserAnswer doScore(List<String> choices, App app) throws Exception {
        // 1.根据 appId 查询到题目和题目结果信息
        Long appId = app.getId();
        Question question = questionService.getOne(
                Wrappers.lambdaQuery(Question.class).eq(Question::getAppId, appId)
        );
        List<ScoringResult> scoringResultList = scoringResultService.list(
                Wrappers.lambdaQuery(ScoringResult.class).eq(ScoringResult::getAppId, appId)
        );
        // 2.统计用户每个选择对应的属性个数，如 I = 10个， E = 5个
        HashMap<String, Integer> optionCount = new HashMap<>();
        QuestionVO questionVO = QuestionVO.objToVo(question);
        List<QuestionContentDTO> questionContent = questionVO.getQuestionContent();
        // 遍历题目列表
        for (int i = 0; i < choices.size(); i++) {
            List<QuestionContentDTO.Option> options = questionContent.get(i).getOptions();
            for (QuestionContentDTO.Option option : options) {
                //找到用户选的值 == 题目选项中的值
                if (option.getKey().equals(choices.get(i))){
                    optionCount.put(option.getResult(),optionCount.getOrDefault(option.getResult(),0) + 1);
                }
            }
        }
        // 3.遍历每种评分结果，计算哪个结果的得分更高
        // 初始化最高分和最高分对应的评分结果
        int maxScore = 0;
        ScoringResult maxScoringResult = scoringResultList.get(0);
        for (ScoringResult result : scoringResultList) {
            List<String> resultPropList = JSONUtil.toList(result.getResultProp(), String.class);
            int score = resultPropList.stream()
                    .mapToInt(prop -> optionCount.getOrDefault(prop, 0))
                    .sum();
            //如果评分结果高于当前最高分数，更新最高分数和最高分数对应的评分结果
            if (score > maxScore){
                maxScore = score;
                maxScoringResult = result;
            }
        }
        // 4.构造返回值，填充答案对象的属性
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAppId(appId);
        userAnswer.setAppType(app.getAppType());
        userAnswer.setScoringStrategy(app.getScoringStrategy());
        userAnswer.setChoices(JSONUtil.toJsonStr(choices));
        userAnswer.setResultId(maxScoringResult.getId());
        userAnswer.setResultName(maxScoringResult.getResultName());
        userAnswer.setResultDesc(maxScoringResult.getResultDesc());
        userAnswer.setResultPicture(maxScoringResult.getResultPicture());
        return userAnswer;
    }
}
