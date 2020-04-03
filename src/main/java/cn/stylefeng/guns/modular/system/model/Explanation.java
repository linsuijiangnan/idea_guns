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
@TableName("other_explanation")
public class Explanation extends Model<Explanation> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "explanation_id", type = IdType.AUTO)
    private Long explanationId;
    /**
     * 引用ch_user表中的user_id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 解决问题的行业方向
     */
    @TableField("explanation_driection")
    private String explanationDriection;
    /**
     * 类型
     */
    @TableField("explanation_type")
    private String explanationType;


    public Long getExplanationId() {
        return explanationId;
    }

    public void setExplanationId(Long explanationId) {
        this.explanationId = explanationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExplanationDriection() {
        return explanationDriection;
    }

    public void setExplanationDriection(String explanationDriection) {
        this.explanationDriection = explanationDriection;
    }

    public String getExplanationType() {
        return explanationType;
    }

    public void setExplanationType(String explanationType) {
        this.explanationType = explanationType;
    }

    @Override
    protected Serializable pkVal() {
        return this.explanationId;
    }

    @Override
    public String toString() {
        return "Explanation{" +
        ", explanationId=" + explanationId +
        ", userId=" + userId +
        ", explanationDriection=" + explanationDriection +
        ", explanationType=" + explanationType +
        "}";
    }
}
