package cn.stylefeng.guns.modular.myself.service;

import cn.stylefeng.guns.modular.system.model.User2;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-10
 */
public interface IUser2Service extends IService<User2> {

	List<Map<String, Object>> getlist(Page<User2> page);

	List<Map<String, Object>> scoreall(String industry, String industrytype);

	List<Map<String, Object>> addressproince();

	List<Map<String, Object>> xiangxi(String expertsid);

	List<Map<String, Object>> screen(String expertsname, Page<User2> page, String industry, String industrytype,
			String addressproince, String orderByField, boolean asc);

}
