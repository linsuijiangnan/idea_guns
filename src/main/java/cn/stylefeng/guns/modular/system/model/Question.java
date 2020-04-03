package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("other_question")
public class Question extends Model<Question> {

    private static final long serialVersionUID = 1L;

    /**
     * 引用ch_user表中的user_id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 问题id
     */
    @TableId(value = "question_id", type = IdType.AUTO)
    private Long questionId;
    /**
     * 问题方向
     */
    @TableField("question_direction")
    private String questionDirection;
    /**
     * 问题类型
     */
    @TableField("question_type")
    private String questionType;
    /**
     * 图片
     */
    @TableField("question_picture")
    private String questionPicture;
    /**
     * 价格
     */
    @TableField("question_price")
    private BigDecimal questionPrice;
    /**
     * 联系电话
     */
    @TableField("question_photo")
    private String questionPhoto;
    /**
     * 问题描述
     */
    @TableField("question_describe")
    private String questionDescribe;
    /**
     * 回答者
     */
    @TableField("question_responder")
    private String questionResponder;
    /**
     * 时间限制
     */
    @TableField("question_time")
    private Long questionTime;
    /**
     * 可用
     */
    @TableField("question_remake")
    private String questionRemake;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDirection() {
        return questionDirection;
    }

    public void setQuestionDirection(String questionDirection) {
        this.questionDirection = questionDirection;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionPicture() {
        return questionPicture;
    }

    public void setQuestionPicture(String questionPicture) {
        this.questionPicture = questionPicture;
    }

    public BigDecimal getQuestionPrice() {
        return questionPrice;
    }

    public void setQuestionPrice(BigDecimal questionPrice) {
        this.questionPrice = questionPrice;
    }

    public String getQuestionPhoto() {
        return questionPhoto;
    }

    public void setQuestionPhoto(String questionPhoto) {
        this.questionPhoto = questionPhoto;
    }

    public String getQuestionDescribe() {
        return questionDescribe;
    }

    public void setQuestionDescribe(String questionDescribe) {
        this.questionDescribe = questionDescribe;
    }

    public String getQuestionResponder() {
        return questionResponder;
    }

    public void setQuestionResponder(String questionResponder) {
        this.questionResponder = questionResponder;
    }

    public Long getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Long questionTime) {
        this.questionTime = questionTime;
    }

    public String getQuestionRemake() {
        return questionRemake;
    }

    public void setQuestionRemake(String questionRemake) {
        this.questionRemake = questionRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.questionId;
    }

    @Override
    public String toString() {
        return "Question{" +
        ", userId=" + userId +
        ", questionId=" + questionId +
        ", questionDirection=" + questionDirection +
        ", questionType=" + questionType +
        ", questionPicture=" + questionPicture +
        ", questionPrice=" + questionPrice +
        ", questionPhoto=" + questionPhoto +
        ", questionDescribe=" + questionDescribe +
        ", questionResponder=" + questionResponder +
        ", questionTime=" + questionTime +
        ", questionRemake=" + questionRemake +
        "}";
    }
}
