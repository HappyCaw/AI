package com.lmm.yudada.scoring;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lmm.yudada.model.dto.question.QuestionContentDTO;
import com.lmm.yudada.model.entity.App;
import com.lmm.yudada.model.entity.Question;
import com.lmm.yudada.model.entity.ScoringResult;
import com.lmm.yudada.model.entity.UserAnswer;
import com.lmm.yudada.model.vo.QuestionVO;
import com.lmm.yudada.service.QuestionService;
import com.lmm.yudada.service.ScoringResultService;
import com.lmm.yudada.service.UserAnswerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Authod:hp
 * @Date:2025/3/2 9:42
 */
@ScoringStrategyConfig(appType = 0, scoringStrategy = 0)
public class CustomScoreScoringStrategy implements ScoringStrategy {

    @Resource
    private ScoringResultService scoringResultService;

    @Resource
    private QuestionService questionService;

    @Override
    public UserAnswer doScore(List<String> choices, App app) throws Exception {
        // 1.根据 id 查询到题目和结果信息（按分数降序排序）
        Long appId = app.getId();
        Question question = questionService.getOne(
                Wrappers.lambdaQuery(Question.class).eq(Question::getAppId, appId)
        );
        //这一套题对应多个结果，所以用list接收
        List<ScoringResult> scoringResultList = scoringResultService.list(
                Wrappers.lambdaQuery(ScoringResult.class)
                        .eq(ScoringResult::getAppId, appId)
                        .orderByDesc(ScoringResult::getResultScoreRange)
        );
        // 2. 统计用户的总得分
        int totalScore = 0;
        QuestionVO questionVO = QuestionVO.objToVo(question);
        List<QuestionContentDTO> questionContent = questionVO.getQuestionContent();
        // 遍历题目列表
        for (int i = 0; i < questionContent.size(); i++) {
            List<QuestionContentDTO.Option> options = questionContent.get(i).getOptions();
            for (QuestionContentDTO.Option option : options) {
                //找到用户选的值 == 题目选项中的值
                if (option.getKey().equals(choices.get(i))){
                    totalScore += option.getScore();
                }
            }
        }
        // 3. 遍历的分结果，找到第一个用户分数大于得分范围的结果，作为最终结果
        ScoringResult target = scoringResultList.get(0);
        for (ScoringResult scoringResult : scoringResultList) {
            if( totalScore >= scoringResult.getResultScoreRange()){
                target = scoringResult;
                break;
            }
        }
        // 4. 返回结果
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAppId(appId);
        userAnswer.setAppType(app.getAppType());
        userAnswer.setScoringStrategy(app.getScoringStrategy());
        userAnswer.setChoices(JSONUtil.toJsonStr(choices));
        userAnswer.setResultId(target.getId());
        userAnswer.setResultName(target.getResultName());
        userAnswer.setResultDesc(target.getResultDesc());
        userAnswer.setResultPicture(target.getResultPicture());
        userAnswer.setResultScore(target.getResultScoreRange());
        return userAnswer;
    }
}
