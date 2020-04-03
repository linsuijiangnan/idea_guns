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
import cn.stylefeng.guns.modular.system.model.Evaluation;
import cn.stylefeng.guns.modular.myself.service.IEvaluationService;

/**
 * 评价控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:43:18
 */
@Controller
@RequestMapping("/evaluation")
public class EvaluationController extends BaseController {

    private String PREFIX = "/myself/evaluation/";

    @Autowired
    private IEvaluationService evaluationService;

    /**
     * 跳转到评价首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "evaluation.html";
    }

    /**
     * 跳转到添加评价
     */
    @RequestMapping("/evaluation_add")
    public String evaluationAdd() {
        return PREFIX + "evaluation_add.html";
    }

    /**
     * 跳转到修改评价
     */
    @RequestMapping("/evaluation_update/{evaluationId}")
    public String evaluationUpdate(@PathVariable Integer evaluationId, Model model) {
        Evaluation evaluation = evaluationService.selectById(evaluationId);
        model.addAttribute("item",evaluation);
        LogObjectHolder.me().set(evaluation);
        return PREFIX + "evaluation_edit.html";
    }

    /**
     * 获取评价列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return evaluationService.selectList(null);
    }

    /**
     * 新增评价
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Evaluation evaluation) {
        evaluationService.insert(evaluation);
        return SUCCESS_TIP;
    }

    /**
     * 删除评价
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer evaluationId) {
        evaluationService.deleteById(evaluationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评价
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Evaluation evaluation) {
        evaluationService.updateById(evaluation);
        return SUCCESS_TIP;
    }

    /**
     * 评价详情
     */
    @RequestMapping(value = "/detail/{evaluationId}")
    @ResponseBody
    public Object detail(@PathVariable("evaluationId") Integer evaluationId) {
        return evaluationService.selectById(evaluationId);
    }
}
