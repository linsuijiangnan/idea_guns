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
@TableName("other_industry")
public class Industry extends Model<Industry> {

    private static final long serialVersionUID = 1L;

    /**
     * 行业id
     */
    @TableId(value = "industry_id", type = IdType.AUTO)
    private Long industryId;
    /**
     * 行业方向
     */
    @TableField("industry_direction")
    private String industryDirection;
    /**
     * 行业类型
     */
    @TableField("industry_type")
    private String industryType;


    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getIndustryDirection() {
        return industryDirection;
    }

    public void setIndustryDirection(String industryDirection) {
        this.industryDirection = industryDirection;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    @Override
    protected Serializable pkVal() {
        return this.industryId;
    }

    @Override
    public String toString() {
        return "Industry{" +
        ", industryId=" + industryId +
        ", industryDirection=" + industryDirection +
        ", industryType=" + industryType +
        "}";
    }
}
