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
import cn.stylefeng.guns.modular.system.model.User1;
import cn.stylefeng.guns.modular.myself.service.IUser1Service;

/**
 * 用户表1控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:58:35
 */
@Controller
@RequestMapping("/user1")
public class User1Controller extends BaseController {

    private String PREFIX = "/myself/user1/";

    @Autowired
    private IUser1Service user1Service;

    /**
     * 跳转到用户表1首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "user1.html";
    }

    /**
     * 跳转到添加用户表1
     */
    @RequestMapping("/user1_add")
    public String user1Add() {
        return PREFIX + "user1_add.html";
    }

    /**
     * 跳转到修改用户表1
     */
    @RequestMapping("/user1_update/{user1Id}")
    public String user1Update(@PathVariable Integer user1Id, Model model) {
        User1 user1 = user1Service.selectById(user1Id);
        model.addAttribute("item",user1);
        LogObjectHolder.me().set(user1);
        return PREFIX + "user1_edit.html";
    }

    /**
     * 获取用户表1列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return user1Service.selectList(null);
    }

    /**
     * 新增用户表1
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(User1 user1) {
        user1Service.insert(user1);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户表1
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer user1Id) {
        user1Service.deleteById(user1Id);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户表1
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(User1 user1) {
        user1Service.updateById(user1);
        return SUCCESS_TIP;
    }

    /**
     * 用户表1详情
     */
    @RequestMapping(value = "/detail/{user1Id}")
    @ResponseBody
    public Object detail(@PathVariable("user1Id") Integer user1Id) {
        return user1Service.selectById(user1Id);
    }
}
