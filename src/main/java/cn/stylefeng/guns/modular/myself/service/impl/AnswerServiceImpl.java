package cn.stylefeng.guns.modular.myself.service.impl;

import cn.stylefeng.guns.modular.system.model.Answer;
import cn.stylefeng.guns.modular.system.dao.AnswerMapper;
import cn.stylefeng.guns.modular.system.dao.User2Mapper;
import cn.stylefeng.guns.modular.myself.service.IAnswerService;
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
 * @since 2018-12-10
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {
	@Autowired
	private AnswerMapper mapper;
	@Override
	public List<Map<String, Object>> pingjia(String expertsid) {
		// TODO Auto-generated method stub
		return mapper.pingjia(expertsid);
	}
	@Override
	public List<Map<String, Object>> wenti(String expertsid) {
		// TODO Auto-generated method stub
		return mapper.wenti(expertsid);
	}

}
