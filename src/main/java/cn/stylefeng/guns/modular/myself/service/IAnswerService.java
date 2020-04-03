package cn.stylefeng.guns.modular.myself.service;

import cn.stylefeng.guns.modular.system.model.Answer;

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
public interface IAnswerService extends IService<Answer> {

	List<Map<String, Object>> pingjia(String expertsid);

	List<Map<String, Object>> wenti(String expertsid);

}
