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
import cn.stylefeng.guns.modular.system.model.Chatrecord;
import cn.stylefeng.guns.modular.myself.service.IChatrecordService;

/**
 * 聊天内容控制器
 *
 * @author fengshuonan
 * @Date 2018-12-11 15:22:19
 */
@Controller
@RequestMapping("/chatrecord")
public class ChatrecordController extends BaseController {

    private String PREFIX = "/myself/chatrecord/";

    @Autowired
    private IChatrecordService chatrecordService;

    /**
     * 跳转到聊天内容首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "chatrecord.html";
    }

    /**
     * 跳转到添加聊天内容
     */
    @RequestMapping("/chatrecord_add")
    public String chatrecordAdd() {
        return PREFIX + "chatrecord_add.html";
    }

    /**
     * 跳转到修改聊天内容
     */
    @RequestMapping("/chatrecord_update/{chatrecordId}")
    public String chatrecordUpdate(@PathVariable Integer chatrecordId, Model model) {
        Chatrecord chatrecord = chatrecordService.selectById(chatrecordId);
        model.addAttribute("item",chatrecord);
        LogObjectHolder.me().set(chatrecord);
        return PREFIX + "chatrecord_edit.html";
    }

    /**
     * 获取聊天内容列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return chatrecordService.selectList(null);
    }

    /**
     * 新增聊天内容
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Chatrecord chatrecord) {
        chatrecordService.insert(chatrecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除聊天内容
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer chatrecordId) {
        chatrecordService.deleteById(chatrecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改聊天内容
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Chatrecord chatrecord) {
        chatrecordService.updateById(chatrecord);
        return SUCCESS_TIP;
    }

    /**
     * 聊天内容详情
     */
    @RequestMapping(value = "/detail/{chatrecordId}")
    @ResponseBody
    public Object detail(@PathVariable("chatrecordId") Integer chatrecordId) {
        return chatrecordService.selectById(chatrecordId);
    }
}
