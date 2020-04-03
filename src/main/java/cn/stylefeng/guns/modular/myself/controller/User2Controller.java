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
import cn.stylefeng.guns.modular.system.model.User2;
import cn.stylefeng.guns.modular.myself.service.IUser2Service;

/**
 * 用户表2控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:35:42
 */
@Controller
@RequestMapping("/user2")
public class User2Controller extends BaseController {

    private String PREFIX = "/myself/user2/";

    @Autowired
    private IUser2Service user2Service;

    /**
     * 跳转到用户表2首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "user2.html";
    }

    /**
     * 跳转到添加用户表2
     */
    @RequestMapping("/user2_add")
    public String user2Add() {
        return PREFIX + "user2_add.html";
    }

    /**
     * 跳转到修改用户表2
     */
    @RequestMapping("/user2_update/{user2Id}")
    public String user2Update(@PathVariable Integer user2Id, Model model) {
        User2 user2 = user2Service.selectById(user2Id);
        model.addAttribute("item",user2);
        LogObjectHolder.me().set(user2);
        return PREFIX + "user2_edit.html";
    }

    /**
     * 获取用户表2列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return user2Service.selectList(null);
    }

    /**
     * 新增用户表2
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(User2 user2) {
        user2Service.insert(user2);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户表2
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer user2Id) {
        user2Service.deleteById(user2Id);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户表2
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(User2 user2) {
        user2Service.updateById(user2);
        return SUCCESS_TIP;
    }

    /**
     * 用户表2详情
     */
    @RequestMapping(value = "/detail/{user2Id}")
    @ResponseBody
    public Object detail(@PathVariable("user2Id") Integer user2Id) {
        return user2Service.selectById(user2Id);
    }
}
