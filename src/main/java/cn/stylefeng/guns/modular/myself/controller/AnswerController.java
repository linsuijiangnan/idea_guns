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
import cn.stylefeng.guns.modular.system.model.Answer;
import cn.stylefeng.guns.modular.myself.service.IAnswerService;

/**
 * 回答控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:38:28
 */
@Controller
@RequestMapping("/answer")
public class AnswerController extends BaseController {

    private String PREFIX = "/myself/answer/";

    @Autowired
    private IAnswerService answerService;

    /**
     * 跳转到回答首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "answer.html";
    }

    /**
     * 跳转到添加回答
     */
    @RequestMapping("/answer_add")
    public String answerAdd() {
        return PREFIX + "answer_add.html";
    }

    /**
     * 跳转到修改回答
     */
    @RequestMapping("/answer_update/{answerId}")
    public String answerUpdate(@PathVariable Integer answerId, Model model) {
        Answer answer = answerService.selectById(answerId);
        model.addAttribute("item",answer);
        LogObjectHolder.me().set(answer);
        return PREFIX + "answer_edit.html";
    }

    /**
     * 获取回答列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return answerService.selectList(null);
    }

    /**
     * 新增回答
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Answer answer) {
        answerService.insert(answer);
        return SUCCESS_TIP;
    }

    /**
     * 删除回答
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer answerId) {
        answerService.deleteById(answerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改回答
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Answer answer) {
        answerService.updateById(answer);
        return SUCCESS_TIP;
    }

    /**
     * 回答详情
     */
    @RequestMapping(value = "/detail/{answerId}")
    @ResponseBody
    public Object detail(@PathVariable("answerId") Integer answerId) {
        return answerService.selectById(answerId);
    }
}
