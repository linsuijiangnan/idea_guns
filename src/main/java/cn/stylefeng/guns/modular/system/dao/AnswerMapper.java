package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.Answer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-10
 */
public interface AnswerMapper extends BaseMapper<Answer> {


	List<Map<String, Object>> pingjia(@Param("introduction") String expertsid);

	List<Map<String, Object>> wenti(@Param("expertsid") String expertsid);

}
