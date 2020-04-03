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
@TableName("other_chatrecord")
public class Chatrecord extends Model<Chatrecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天内容的id，自动递增从100开始
     */
    @TableId(value = "chatrecord_id", type = IdType.AUTO)
    private Long chatrecordId;
    /**
     * 聊天室的id可以和chatroom主外键
     */
    @TableField("chatroom_id")
    private Long chatroomId;
    /**
     * 聊天时间
     */
    @TableField("chatrecord_time")
    private Long chatrecordTime;
    /**
     * 聊天内容
     */
    @TableField("chatrecord_content")
    private String chatrecordContent;
    @TableField("chatrecord_remake")
    private String chatrecordRemake;


    public Long getChatrecordId() {
        return chatrecordId;
    }

    public void setChatrecordId(Long chatrecordId) {
        this.chatrecordId = chatrecordId;
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public Long getChatrecordTime() {
        return chatrecordTime;
    }

    public void setChatrecordTime(Long chatrecordTime) {
        this.chatrecordTime = chatrecordTime;
    }

    public String getChatrecordContent() {
        return chatrecordContent;
    }

    public void setChatrecordContent(String chatrecordContent) {
        this.chatrecordContent = chatrecordContent;
    }

    public String getChatrecordRemake() {
        return chatrecordRemake;
    }

    public void setChatrecordRemake(String chatrecordRemake) {
        this.chatrecordRemake = chatrecordRemake;
    }

    @Override
    protected Serializable pkVal() {
        return this.chatrecordId;
    }

    @Override
    public String toString() {
        return "Chatrecord{" +
        ", chatrecordId=" + chatrecordId +
        ", chatroomId=" + chatroomId +
        ", chatrecordTime=" + chatrecordTime +
        ", chatrecordContent=" + chatrecordContent +
        ", chatrecordRemake=" + chatrecordRemake +
        "}";
    }
}
