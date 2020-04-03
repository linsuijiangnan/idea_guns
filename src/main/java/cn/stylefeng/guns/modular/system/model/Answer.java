package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-10
 */
@TableName("other_answer")
public class Answer extends Model<Answer> {

    private static final long serialVersionUID = 1L;

    /**
     * 引用ch_user表中的user_id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 回答Id
     */
    @TableId(value = "answer_id", type = IdType.AUTO)
    private Long answerId;
    /**
     * 问问题id
     */
    @TableField("question_id")
    private Long questionId;
    /**
     * 解决程度
     */
    @TableField("answer_degree")
    private String answerDegree;
    /**
     * 完成度
     */
    @TableField("answer_completion")
    private Integer answerCompletion;
    /**
     * 态度
     */
    @TableField("answer_attitude")
    private Integer answerAttitude;
    /**
     * 效率
     */
    @TableField("answer_efficiency")
    private Integer answerEfficiency;
    /**
     * 评价
     */
    @TableField("answer_evaluation")
    private String answerEvaluation;
    @TableField("answer_remake")
    private String answerRemake;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswerDegree() {
        return answerDegree;
    }

    public void setAnswerDegree(String answerDegree) {
        this.answerDegree = answerDegree;
    }

    public Integer getAnswerCompletion() {
        return answerCompletion;
    }

    public void setAnswerCompletion(Integer answerCompletion) {
        this.answerCompletion = answerCompletion;
    }

    public Integer getAnswerAttitude() {
        return answerAttitude;
    }

    public void setAnswerAttitude(Integer answerAttitude) {
        this.answerAttitude = answerAttitude;
    }

    public Integer getAnswerEfficiency() {
        return answerEfficiency;
    }

    public void setAnswerEfficiency(Integer answerEfficiency) {
        this.answerEfficiency = answerEfficiency;
    }

    public String getAnswerEvaluation() {
        return answerEvaluation;
    }

    public void setAnswerEvaluation(String answerEvaluation) {
        this.answerEvaluation = answerEvaluation;
    }

    public String getAnswerRemake() {
        return answerRemake;
    }

    public void setAnswerRemake(String answerRemake) {
        this.answerRemake = answerRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.answerId;
    }

    @Override
    public String toString() {
        return "Answer{" +
        ", userId=" + userId +
        ", answerId=" + answerId +
        ", questionId=" + questionId +
        ", answerDegree=" + answerDegree +
        ", answerCompletion=" + answerCompletion +
        ", answerAttitude=" + answerAttitude +
        ", answerEfficiency=" + answerEfficiency +
        ", answerEvaluation=" + answerEvaluation +
        ", answerRemake=" + answerRemake +
        "}";
    }
}
