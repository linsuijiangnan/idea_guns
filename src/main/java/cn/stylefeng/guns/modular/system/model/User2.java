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
@TableName("other_user2")
public class User2 extends Model<User2> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表2的id
     */
    @TableId(value = "user2_id", type = IdType.AUTO)
    private Long user2Id;
    /**
     * 用户表的id引用主键ch_user1中的user_id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 电话
     */
    @TableField("user_photo")
    private String userPhoto;
    /**
     * 省份
     */
    @TableField("user_addressproince")
    private String userAddressproince;
    /**
     * 城市
     */
    @TableField("user_addresscity")
    private String userAddresscity;
    /**
     * 开始工作时间
     */
    @TableField("user_workstart")
    private Long userWorkstart;
    /**
     * 结束工作时间
     */
    @TableField("user_workover")
    private Long userWorkover;
    /**
     * 职业方向
     */
    @TableField("user_industrytype")
    private String userIndustrytype;
    /**
     * 职业
     */
    @TableField("user_industry")
    private String userIndustry;
    /**
     * 工作状态（正常非正常）
     */
    @TableField("user_workstate")
    private String userWorkstate;
    /**
     * 工作经历的公司
     */
    @TableField("user_experiencecompany")
    private String userExperiencecompany;
    /**
     * 工作经历的职业
     */
    @TableField("user_experienceoccupation")
    private String userExperienceoccupation;
    /**
     * 价格
     */
    @TableField("user_price")
    private BigDecimal userPrice;
    /**
     * 个人介绍
     */
    @TableField("user_introduction")
    private String userIntroduction;
    /**
     * 工作内容
     */
    @TableField("user_workcontent")
    private String userWorkcontent;
    /**
     * 工作内容图片
     */
    @TableField("user_workpicture")
    private String userWorkpicture;
    /**
     * 添加工作内容id引用other_addwork表中的addwork_id
     */
    @TableField("addwork_")
    private Long addwork;
    /**
     * 常住地址
     */
    @TableField("user_address")
    private String userAddress;
    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 支付宝账号
     */
    @TableField("user_alipayuser")
    private String userAlipayuser;
    /**
     * 支付宝密码
     */
    @TableField("user_alipaypass")
    private String userAlipaypass;
    /**
     * 评分
     */
    @TableField("user_score")
    private Double userScore;
    /**
     * 照片
     */
    @TableField("user_picture")
    private String userPicture;
    /**
     * 评论数
     */
    @TableField("user_commentnumber")
    private Long userCommentnumber;
    /**
     * 可用
     */
    @TableField("user_remake")
    private String userRemake;


    public Long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserAddressproince() {
        return userAddressproince;
    }

    public void setUserAddressproince(String userAddressproince) {
        this.userAddressproince = userAddressproince;
    }

    public String getUserAddresscity() {
        return userAddresscity;
    }

    public void setUserAddresscity(String userAddresscity) {
        this.userAddresscity = userAddresscity;
    }

    public Long getUserWorkstart() {
        return userWorkstart;
    }

    public void setUserWorkstart(Long userWorkstart) {
        this.userWorkstart = userWorkstart;
    }

    public Long getUserWorkover() {
        return userWorkover;
    }

    public void setUserWorkover(Long userWorkover) {
        this.userWorkover = userWorkover;
    }

    public String getUserIndustrytype() {
        return userIndustrytype;
    }

    public void setUserIndustrytype(String userIndustrytype) {
        this.userIndustrytype = userIndustrytype;
    }

    public String getUserIndustry() {
        return userIndustry;
    }

    public void setUserIndustry(String userIndustry) {
        this.userIndustry = userIndustry;
    }

    public String getUserWorkstate() {
        return userWorkstate;
    }

    public void setUserWorkstate(String userWorkstate) {
        this.userWorkstate = userWorkstate;
    }

    public String getUserExperiencecompany() {
        return userExperiencecompany;
    }

    public void setUserExperiencecompany(String userExperiencecompany) {
        this.userExperiencecompany = userExperiencecompany;
    }

    public String getUserExperienceoccupation() {
        return userExperienceoccupation;
    }

    public void setUserExperienceoccupation(String userExperienceoccupation) {
        this.userExperienceoccupation = userExperienceoccupation;
    }

    public BigDecimal getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(BigDecimal userPrice) {
        this.userPrice = userPrice;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getUserWorkcontent() {
        return userWorkcontent;
    }

    public void setUserWorkcontent(String userWorkcontent) {
        this.userWorkcontent = userWorkcontent;
    }

    public String getUserWorkpicture() {
        return userWorkpicture;
    }

    public void setUserWorkpicture(String userWorkpicture) {
        this.userWorkpicture = userWorkpicture;
    }

    public Long getAddwork() {
        return addwork;
    }

    public void setAddwork(Long addwork) {
        this.addwork = addwork;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAlipayuser() {
        return userAlipayuser;
    }

    public void setUserAlipayuser(String userAlipayuser) {
        this.userAlipayuser = userAlipayuser;
    }

    public String getUserAlipaypass() {
        return userAlipaypass;
    }

    public void setUserAlipaypass(String userAlipaypass) {
        this.userAlipaypass = userAlipaypass;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Long getUserCommentnumber() {
        return userCommentnumber;
    }

    public void setUserCommentnumber(Long userCommentnumber) {
        this.userCommentnumber = userCommentnumber;
    }

    public String getUserRemake() {
        return userRemake;
    }

    public void setUserRemake(String userRemake) {
        this.userRemake = userRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.user2Id;
    }

    @Override
    public String toString() {
        return "User2{" +
        ", user2Id=" + user2Id +
        ", userId=" + userId +
        ", userPhoto=" + userPhoto +
        ", userAddressproince=" + userAddressproince +
        ", userAddresscity=" + userAddresscity +
        ", userWorkstart=" + userWorkstart +
        ", userWorkover=" + userWorkover +
        ", userIndustrytype=" + userIndustrytype +
        ", userIndustry=" + userIndustry +
        ", userWorkstate=" + userWorkstate +
        ", userExperiencecompany=" + userExperiencecompany +
        ", userExperienceoccupation=" + userExperienceoccupation +
        ", userPrice=" + userPrice +
        ", userIntroduction=" + userIntroduction +
        ", userWorkcontent=" + userWorkcontent +
        ", userWorkpicture=" + userWorkpicture +
        ", addwork=" + addwork +
        ", userAddress=" + userAddress +
        ", userName=" + userName +
        ", userAlipayuser=" + userAlipayuser +
        ", userAlipaypass=" + userAlipaypass +
        ", userScore=" + userScore +
        ", userPicture=" + userPicture +
        ", userCommentnumber=" + userCommentnumber +
        ", userRemake=" + userRemake +
        "}";
    }
}
