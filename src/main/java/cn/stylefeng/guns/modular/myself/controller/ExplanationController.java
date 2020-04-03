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
import cn.stylefeng.guns.modular.system.model.Explanation;
import cn.stylefeng.guns.modular.myself.service.IExplanationService;

/**
 * 解释控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:42:57
 */
@Controller
@RequestMapping("/explanation")
public class ExplanationController extends BaseController {

    private String PREFIX = "/myself/explanation/";

    @Autowired
    private IExplanationService explanationService;

    /**
     * 跳转到解释首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "explanation.html";
    }

    /**
     * 跳转到添加解释
     */
    @RequestMapping("/explanation_add")
    public String explanationAdd() {
        return PREFIX + "explanation_add.html";
    }

    /**
     * 跳转到修改解释
     */
    @RequestMapping("/explanation_update/{explanationId}")
    public String explanationUpdate(@PathVariable Integer explanationId, Model model) {
        Explanation explanation = explanationService.selectById(explanationId);
        model.addAttribute("item",explanation);
        LogObjectHolder.me().set(explanation);
        return PREFIX + "explanation_edit.html";
    }

    /**
     * 获取解释列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return explanationService.selectList(null);
    }

    /**
     * 新增解释
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Explanation explanation) {
        explanationService.insert(explanation);
        return SUCCESS_TIP;
    }

    /**
     * 删除解释
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer explanationId) {
        explanationService.deleteById(explanationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改解释
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Explanation explanation) {
        explanationService.updateById(explanation);
        return SUCCESS_TIP;
    }

    /**
     * 解释详情
     */
    @RequestMapping(value = "/detail/{explanationId}")
    @ResponseBody
    public Object detail(@PathVariable("explanationId") Integer explanationId) {
        return explanationService.selectById(explanationId);
    }
}
