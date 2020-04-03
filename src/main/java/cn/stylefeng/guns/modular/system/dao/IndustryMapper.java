package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Industry;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-10
 */
public interface IndustryMapper extends BaseMapper<Industry> {

	List<Map<String, Object>> industry();

}
