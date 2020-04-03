package cn.stylefeng.guns.modular.myself.service.impl;

import cn.stylefeng.guns.modular.system.dao.IndustryMapper;
import cn.stylefeng.guns.modular.system.model.Industry;
import cn.stylefeng.guns.modular.myself.service.IIndustryService;
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
 * @since 2018-12-03
 */
@Service
public class IndustryServiceImpl extends ServiceImpl<IndustryMapper, Industry> implements IIndustryService {
	@Autowired
	private IndustryMapper mapper;
	@Override
	public List<Map<String, Object>> industry() {
		// TODO Auto-generated method stub
		return mapper.industry();
	}




}
