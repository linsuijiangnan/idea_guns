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
@TableName("ch_user1")
public class User1 extends Model<User1> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 微信id
     */
    @TableField("user_weixinId")
    private String userWeixinid;
    /**
     * 微信名
     */
    @TableField("user_weixinname")
    private String userWeixinname;
    /**
     * 身份（管理员，普通，专家）
     */
    @TableField("user_identity")
    private String userIdentity;
    /**
     * 身份证号
     */
    @TableField("user_identitycard")
    private String userIdentitycard;
    /**
     * 生日
     */
    @TableField("user_brithday")
    private String userBrithday;
    /**
     * 创建日期
     */
    @TableField("user_createtime")
    private Long userCreatetime;
    /**
     * 真是姓名
     */
    @TableField("user_name")
    private String userName;
    @TableField("user_version")
    private String userVersion;
    /**
     * 身份证正面
     */
    @TableField("user_identitypicturefront")
    private String userIdentitypicturefront;
    /**
     * 身份证反面
     */
    @TableField("user_identitypictureback")
    private String userIdentitypictureback;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserWeixinid() {
        return userWeixinid;
    }

    public void setUserWeixinid(String userWeixinid) {
        this.userWeixinid = userWeixinid;
    }

    public String getUserWeixinname() {
        return userWeixinname;
    }

    public void setUserWeixinname(String userWeixinname) {
        this.userWeixinname = userWeixinname;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserIdentitycard() {
        return userIdentitycard;
    }

    public void setUserIdentitycard(String userIdentitycard) {
        this.userIdentitycard = userIdentitycard;
    }

    public String getUserBrithday() {
        return userBrithday;
    }

    public void setUserBrithday(String userBrithday) {
        this.userBrithday = userBrithday;
    }

    public Long getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Long userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public String getUserIdentitypicturefront() {
        return userIdentitypicturefront;
    }

    public void setUserIdentitypicturefront(String userIdentitypicturefront) {
        this.userIdentitypicturefront = userIdentitypicturefront;
    }

    public String getUserIdentitypictureback() {
        return userIdentitypictureback;
    }

    public void setUserIdentitypictureback(String userIdentitypictureback) {
        this.userIdentitypictureback = userIdentitypictureback;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User1{" +
        ", userId=" + userId +
        ", userWeixinid=" + userWeixinid +
        ", userWeixinname=" + userWeixinname +
        ", userIdentity=" + userIdentity +
        ", userIdentitycard=" + userIdentitycard +
        ", userBrithday=" + userBrithday +
        ", userCreatetime=" + userCreatetime +
        ", userName=" + userName +
        ", userVersion=" + userVersion +
        ", userIdentitypicturefront=" + userIdentitypicturefront +
        ", userIdentitypictureback=" + userIdentitypictureback +
        "}";
    }
}
