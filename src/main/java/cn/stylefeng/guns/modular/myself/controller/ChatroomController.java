package cn.stylefeng.guns.modular.myself.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Chatroom;
import cn.stylefeng.guns.modular.myself.service.IChatroomService;

/**
 * 聊天室控制器
 *
 * @author fengshuonan
 * @Date 2018-12-11 15:21:54
 */
@Controller
@RequestMapping("/chatroom")
public class ChatroomController extends BaseController {

    private String PREFIX = "/myself/chatroom/";

    @Autowired
    private IChatroomService chatroomService;

    /**
     * 跳转到聊天室首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "chatroom.html";
    }

    /**
     * 跳转到添加聊天室
     */
    @RequestMapping("/chatroom_add")
    public String chatroomAdd() {
        return PREFIX + "chatroom_add.html";
    }

    /**
     * 跳转到修改聊天室
     */
    @RequestMapping("/chatroom_update/{chatroomId}")
    public String chatroomUpdate(@PathVariable Integer chatroomId, Model model) {
        Chatroom chatroom = chatroomService.selectById(chatroomId);
        model.addAttribute("item",chatroom);
        LogObjectHolder.me().set(chatroom);
        return PREFIX + "chatroom_edit.html";
    }

    /**
     * 获取聊天室列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return chatroomService.selectList(null);
    }

    /**
     * 新增聊天室
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Chatroom chatroom) {
        chatroomService.insert(chatroom);
        return SUCCESS_TIP;
    }

    /**
     * 删除聊天室
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer chatroomId) {
        chatroomService.deleteById(chatroomId);
        return SUCCESS_TIP;
    }

    /**
     * 修改聊天室
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Chatroom chatroom) {
        chatroomService.updateById(chatroom);
        return SUCCESS_TIP;
    }

    /**
     * 聊天室详情
     */
    @RequestMapping(value = "/detail/{chatroomId}")
    @ResponseBody
    public Object detail(@PathVariable("chatroomId") Integer chatroomId) {
        return chatroomService.selectById(chatroomId);
    }
}
