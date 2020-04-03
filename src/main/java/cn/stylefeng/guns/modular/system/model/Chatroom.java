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
 * @since 2018-12-11
 */
@TableName("other_chatroom")
public class Chatroom extends Model<Chatroom> {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天室主键100开始递增
     */
    @TableId(value = "chatroom_id", type = IdType.AUTO)
    private Long chatroomId;
    /**
     * 专家id
     */
    @TableField("chatroom_expertsId")
    private Long chatroomExpertsid;
    @TableField("chatroom_userId")
    private Long chatroomUserid;
    /**
     * 聊天有效时间
     */
    @TableField("chatroom_time")
    private Long chatroomTime;
    @TableField("chartroom_remake")
    private String chartroomRemake;


    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public Long getChatroomExpertsid() {
        return chatroomExpertsid;
    }

    public void setChatroomExpertsid(Long chatroomExpertsid) {
        this.chatroomExpertsid = chatroomExpertsid;
    }

    public Long getChatroomUserid() {
        return chatroomUserid;
    }

    public void setChatroomUserid(Long chatroomUserid) {
        this.chatroomUserid = chatroomUserid;
    }

    public Long getChatroomTime() {
        return chatroomTime;
    }

    public void setChatroomTime(Long chatroomTime) {
        this.chatroomTime = chatroomTime;
    }

    public String getChartroomRemake() {
        return chartroomRemake;
    }

    public void setChartroomRemake(String chartroomRemake) {
        this.chartroomRemake = chartroomRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.chatroomId;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
        ", chatroomId=" + chatroomId +
        ", chatroomExpertsid=" + chatroomExpertsid +
        ", chatroomUserid=" + chatroomUserid +
        ", chatroomTime=" + chatroomTime +
        ", chartroomRemake=" + chartroomRemake +
        "}";
    }
}
