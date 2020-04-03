package cn.stylefeng.guns.modular.myself.service;

import cn.stylefeng.guns.modular.system.model.Industry;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-10
 */
public interface IIndustryService extends IService<Industry> {

	List<Map<String, Object>> industry();

}
