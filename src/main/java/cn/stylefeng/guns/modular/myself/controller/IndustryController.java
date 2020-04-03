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
import cn.stylefeng.guns.modular.system.model.Industry;
import cn.stylefeng.guns.modular.myself.service.IIndustryService;

/**
 * 行业控制器
 *
 * @author fengshuonan
 * @Date 2018-12-10 21:36:25
 */
@Controller
@RequestMapping("/industry")
public class IndustryController extends BaseController {

    private String PREFIX = "/myself/industry/";

    @Autowired
    private IIndustryService industryService;

    /**
     * 跳转到行业首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "industry.html";
    }

    /**
     * 跳转到添加行业
     */
    @RequestMapping("/industry_add")
    public String industryAdd() {
        return PREFIX + "industry_add.html";
    }

    /**
     * 跳转到修改行业
     */
    @RequestMapping("/industry_update/{industryId}")
    public String industryUpdate(@PathVariable Integer industryId, Model model) {
        Industry industry = industryService.selectById(industryId);
        model.addAttribute("item",industry);
        LogObjectHolder.me().set(industry);
        return PREFIX + "industry_edit.html";
    }

    /**
     * 获取行业列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return industryService.selectList(null);
    }

    /**
     * 新增行业
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Industry industry) {
        industryService.insert(industry);
        return SUCCESS_TIP;
    }

    /**
     * 删除行业
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer industryId) {
        industryService.deleteById(industryId);
        return SUCCESS_TIP;
    }

    /**
     * 修改行业
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Industry industry) {
        industryService.updateById(industry);
        return SUCCESS_TIP;
    }

    /**
     * 行业详情
     */
    @RequestMapping(value = "/detail/{industryId}")
    @ResponseBody
    public Object detail(@PathVariable("industryId") Integer industryId) {
        return industryService.selectById(industryId);
    }
}
