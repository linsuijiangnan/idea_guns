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
@TableName("other_evaluation")
public class Evaluation extends Model<Evaluation> {

    private static final long serialVersionUID = 1L;

    /**
     * 评价表主键100开始递增
     */
    @TableId(value = "evaluation_Id", type = IdType.AUTO)
    private Long evaluationId;
    /**
     * 专家id
     */
    @TableField("evaluation_expertsId")
    private Long evaluationExpertsid;
    /**
     * 用户id
     */
    @TableField("evaluation_userId")
    private Long evaluationUserid;
    /**
     * 评价内容
     */
    @TableField("evaluation_content")
    private String evaluationContent;
    /**
     * 评价时间
     */
    @TableField("evaluation_time")
    private Long evaluationTime;
    @TableField("evaluation_remake")
    private String evaluationRemake;


    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Long getEvaluationExpertsid() {
        return evaluationExpertsid;
    }

    public void setEvaluationExpertsid(Long evaluationExpertsid) {
        this.evaluationExpertsid = evaluationExpertsid;
    }

    public Long getEvaluationUserid() {
        return evaluationUserid;
    }

    public void setEvaluationUserid(Long evaluationUserid) {
        this.evaluationUserid = evaluationUserid;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Long getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Long evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    public String getEvaluationRemake() {
        return evaluationRemake;
    }

    public void setEvaluationRemake(String evaluationRemake) {
        this.evaluationRemake = evaluationRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.evaluationId;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
        ", evaluationId=" + evaluationId +
        ", evaluationExpertsid=" + evaluationExpertsid +
        ", evaluationUserid=" + evaluationUserid +
        ", evaluationContent=" + evaluationContent +
        ", evaluationTime=" + evaluationTime +
        ", evaluationRemake=" + evaluationRemake +
        "}";
    }
}
