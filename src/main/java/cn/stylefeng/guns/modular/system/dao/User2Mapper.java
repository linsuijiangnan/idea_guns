package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.User2;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-05
 */
public interface User2Mapper extends BaseMapper<User2> {
	List<Map<String, Object>> scoreall(@Param("user_industry")String industry, @Param("user_industrytype")String industrytype);
	
	List<Map<String, Object>> addressproince();

	List<Map<String, Object>> getlist(Page<User2> page);

	List<Map<String, Object>> screen(@Param("expertsname")String expertsname,Page<User2> page, @Param("user_industry")String industry, @Param("user_industrytype")String industrytype, 
			@Param("user_addressproince")String addressproince, @Param("orderByField") String orderByField, @Param("isAsc") boolean isAsc);

	List<Map<String, Object>> xiangxi(@Param("expertsid")String expertsid);



}
