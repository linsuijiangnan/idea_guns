package cn.stylefeng.guns.modular.myself.service.impl;

import cn.stylefeng.guns.modular.system.model.Question;
import cn.stylefeng.guns.modular.system.dao.QuestionMapper;
import cn.stylefeng.guns.modular.myself.service.IQuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
