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
import cn.stylefeng.guns.modular.system.model.Question;
import cn.stylefeng.guns.modular.myself.service.IQuestionService;

/**
 * 问题控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:42:15
 */
@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {

    private String PREFIX = "/myself/question/";

    @Autowired
    private IQuestionService questionService;

    /**
     * 跳转到问题首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "question.html";
    }

    /**
     * 跳转到添加问题
     */
    @RequestMapping("/question_add")
    public String questionAdd() {
        return PREFIX + "question_add.html";
    }

    /**
     * 跳转到修改问题
     */
    @RequestMapping("/question_update/{questionId}")
    public String questionUpdate(@PathVariable Integer questionId, Model model) {
        Question question = questionService.selectById(questionId);
        model.addAttribute("item",question);
        LogObjectHolder.me().set(question);
        return PREFIX + "question_edit.html";
    }

    /**
     * 获取问题列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return questionService.selectList(null);
    }

    /**
     * 新增问题
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Question question) {
        questionService.insert(question);
        return SUCCESS_TIP;
    }

    /**
     * 删除问题
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer questionId) {
        questionService.deleteById(questionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改问题
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Question question) {
        questionService.updateById(question);
        return SUCCESS_TIP;
    }

    /**
     * 问题详情
     */
    @RequestMapping(value = "/detail/{questionId}")
    @ResponseBody
    public Object detail(@PathVariable("questionId") Integer questionId) {
        return questionService.selectById(questionId);
    }
}
