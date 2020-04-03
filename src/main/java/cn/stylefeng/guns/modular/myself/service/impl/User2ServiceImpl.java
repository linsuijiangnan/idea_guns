package cn.stylefeng.guns.modular.myself.service.impl;

import cn.stylefeng.guns.modular.system.model.OperationLog;
import cn.stylefeng.guns.modular.system.model.User2;
import cn.stylefeng.guns.modular.system.dao.User2Mapper;
import cn.stylefeng.guns.modular.myself.service.IUser2Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-05
 */
@Service
public class User2ServiceImpl extends ServiceImpl<User2Mapper, User2> implements IUser2Service {
	@Autowired
	private User2Mapper mapper;

	@Override
	public List<Map<String, Object>> scoreall(String industry, String industrytype) {
		// TODO Auto-generated method stub
		return mapper.scoreall(industry, industrytype);
	}

	@Override
	public List<Map<String, Object>> addressproince() {
		// TODO Auto-generated method stub
		return mapper.addressproince();
	}

	@Override
	public List<Map<String, Object>> getlist(Page<User2> page) {
		// TODO Auto-generated method stub
		return mapper.getlist(page);
	}
	
	@Override
	public List<Map<String, Object>> screen(String expertsname,Page<User2> page, String industry, String industrytype,
			String addressproince, String orderByField, boolean asc) {
		// TODO Auto-generated method stub
		return mapper.screen(expertsname,page,industry,industrytype,addressproince,orderByField,asc);
	}

	@Override
	public List<Map<String, Object>> xiangxi(String expertsid) {
		// TODO Auto-generated method stub
		return mapper.xiangxi(expertsid);
	}



}
