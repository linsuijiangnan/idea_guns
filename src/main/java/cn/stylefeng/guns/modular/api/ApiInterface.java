package cn.stylefeng.guns.modular.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.util.JwtTokenUtil;
import cn.stylefeng.guns.modular.myself.service.IAnswerService;
import cn.stylefeng.guns.modular.myself.service.IChatrecordService;
import cn.stylefeng.guns.modular.myself.service.IChatroomService;
import cn.stylefeng.guns.modular.myself.service.IIndustryService;
import cn.stylefeng.guns.modular.myself.service.IQuestionService;
import cn.stylefeng.guns.modular.myself.service.IUser1Service;
import cn.stylefeng.guns.modular.myself.service.IUser2Service;
import cn.stylefeng.guns.modular.system.model.Chatrecord;
import cn.stylefeng.guns.modular.system.model.Chatroom;
import cn.stylefeng.guns.modular.system.model.Industry;
import cn.stylefeng.guns.modular.system.model.Question;
import cn.stylefeng.guns.modular.system.model.User1;
import cn.stylefeng.guns.modular.system.model.User2;
import cn.stylefeng.roses.core.base.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
	 * 接口控制器提供
	 *
	 * @author stylefeng
	 * @Date 2018/7/20 23:39
	 */
	@RestController
	@RequestMapping("/zhuanApi")
	public class ApiInterface extends BaseController {

	    private UsernamePasswordToken usernamePasswordToken;
	    @Autowired
	    private IIndustryService industryService;
	    @Autowired
	    private IUser2Service user2Service;
	    @Autowired
	    private IUser1Service user1Service ;
	    @Autowired
	    private IQuestionService  questionService;
	    @Autowired
	    private IAnswerService  answerService;
	    @Autowired
	    private IChatroomService chatroomService;
	    @Autowired
	    private IChatrecordService chatrecordService;
	    @Autowired
	    private SqlSession session =null;
	    /**
	     * api登录接口，通过账号密码获取token
	     */
	    @RequestMapping("/denglu")
	    
	    
	    /*
	     * 登陆注册
	     * 
	     */
	    
	    @ApiOperation(value="登陆注册",notes="登陆注册接口",tags= {"apidenglu"},response=User1.class)
	    @ApiImplicitParams({
	    		@ApiImplicitParam(name="user_weixinId",value="微信Id",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="user_weixinname",value="微信名",required=true,dataType="String",paramType="query")
			})
	    public Object auth(@RequestParam("user_weixinId") String weixinId,
	                       @RequestParam("user_weixinname") String weixinname) {
	    	//封装请求账号密码为shiro可验证的token
	    	usernamePasswordToken = new UsernamePasswordToken(weixinId, weixinname.toCharArray());
	    	
	    	EntityWrapper<User1> entityWrapper = new EntityWrapper<>();
	    	Wrapper<User1> user1 = entityWrapper.like("user_weixinId",weixinId);
//	        List<User1> selectList = user1Service.selectList(user1);
	       
//	        User1 us=new User1();
//	        us=user1Service.selectById("101");
	        Integer a=user1Service.selectCount(user1);
	        
	        System.out.println(a);
//	        System.out.println(us.getUserWeixinid());		
//	        System.out.println(us.getUserWeixinname());		
	
	    	if(a.equals(0)) {
	    		//注册
	    		User1 zhuce=new User1();
	    		Date dt = new Date();
	    		zhuce.setUserCreatetime(dt.getTime()/1000); 
	    		zhuce.setUserWeixinid(weixinId);
	    		zhuce.setUserWeixinname(weixinname);
	    			//提交
	    		user1Service.insert(zhuce);
	    		//session.commit();
	    		
	    		HashMap<String, Object> result = new HashMap<>();
	            result.put("token", JwtTokenUtil.generateToken(String.valueOf(zhuce.getUserId())));
	            return result;

	    		
	    	}else {
	    		//登陆
	    		User1 denglu=new User1();
	    		denglu.selectById(weixinId);
	    		HashMap<String, Object> result = new HashMap<>();
	            result.put("token", JwtTokenUtil.generateToken(String.valueOf(denglu.getUserId())));
	            return result;
	    		
	    	}

	    }
	    /*
	     * 退出登录接口
	     * 
	     */
	    @ApiOperation(value="退出",notes="1退出",tags= {"tags1"})
	    @ApiImplicitParams({
	    		
			})
	    @RequestMapping("/sigout")
		public String signout(HttpServletRequest request){
	    	request.getSession().invalidate();
	    	request.getCookies().clone();
	    	usernamePasswordToken.clear();
			return "zhuanApi/denglu";
		}
	    /*
	     * 
	     * 行业列表接口
	     */
	    @ApiOperation(value="行业列表",notes="行业列表",tags= {"ApiInterface"},response=Industry.class)
	    @ApiImplicitParams({})
	    @RequestMapping("/industry")
		public Object industry(){
	    	List<Map<String, Object>> industry = industryService.industry();

	    	
//	    	 Page<User2> page = new PageFactory<User2>().defaultPage();
//	         List<Map<String, Object>> result = user2Service.getlist(page);
			return industry;
		}
	    
	    /*
	     * 行业二级菜单接口
	     * 
	     */
	    @ApiOperation(value="行业二级菜单",notes="行业二级菜单",tags= {"ApiInterface"},response=Industry.class)
	    @ApiImplicitParams({
	    		@ApiImplicitParam(name="industry",value="行业类型",required=true,dataType="String",paramType="query")
			})
	    @RequestMapping(value = "/industrytype")
	    public List list(@RequestParam String industry) {
	    	EntityWrapper<Industry> entityWrapper = new EntityWrapper<>();
	    	Wrapper<Industry> like = entityWrapper.like("industry_direction",industry);
	    	
	        return industryService.selectList(like);
	    }
	    
	    /*
	     * 大神推荐接口，专家推荐，按照行业方向类型
	     * 
	     */
	    @ApiOperation(value="大神接口",notes="大神推荐",tags= {"ApiInterface"},response=Industry.class)
	    @ApiImplicitParams({
	    		@ApiImplicitParam(name="industry",value="行业方向",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="industrytype",value="行业类型",required=false,dataType="String",paramType="query")
			})
	    @RequestMapping(value = "/scoreall")
	    public Object scoreall(
	    		@RequestParam(required = false) String industry,
                @RequestParam(required = false) String industrytype
	    		) {
	    	List<Map<String, Object>> recomend = null;	
	    		recomend = user2Service.scoreall(industry,industrytype);
	    		
	    	return recomend;
	    }
	    
	    /*
	     * 
	     * 发布问题（两种，是否带id）
	     */
	    @ApiOperation(value="发布问题接口",notes="发布问题推荐",tags= {"ApiInterface"},response=Question.class)
	    @ApiImplicitParams({
	    		@ApiImplicitParam(name="userid",value="问问题人的id",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="responder",value="制定回答着的名字",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="direction",value="问题描述",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="picture",value="问题内容及图片",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="pice",value="价格",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="describe",value="行业方向",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="type",value="行业类型",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="photo",value="电话",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="time",value="时间",required=true,dataType="String",paramType="query")
	    		
			
			})
	    @RequestMapping(value = "/question")
	    public Object question(
	    		@RequestParam Long userid,@RequestParam(required = false) String responder,@RequestParam String direction,@RequestParam String type,
	    		@RequestParam String picture,@RequestParam BigDecimal pice,@RequestParam String photo,@RequestParam String describe,@RequestParam Long time) {
	    	//添加到数据库中
	    	Question question=new Question();
	    	BigDecimal a=new BigDecimal(1234.0);
	    	Long id=(long) 101;
	    	question.setUserId(userid);question.setQuestionDescribe(describe);question.setQuestionDirection(direction);question.setQuestionType(type);
	    	question.setQuestionPicture(picture);question.setQuestionPrice(pice);question.setQuestionPhoto(photo);question.setQuestionTime(time);
	    	question.setQuestionResponder(responder);
	    	questionService.insert(question);
	    	//发送给指定专家或者
	    	if(responder.equals("null")) {
	    		return question.getQuestionId();
	    	}else {
	    		return question.getQuestionId();
	    	}
	    	
	    }
	    /*
	     * 已有地方列表接口
	     * 
	     */
	    @ApiOperation(value="地方省会",notes="地方省会",tags= {"ApiInterface"},response=Question.class)
	    @RequestMapping(value = "/addressproince")
	    public Object addressproince() {
	    	List<Map<String, Object>> addressproince=user2Service.addressproince();
	        return addressproince;
	    }
	    /* 
	     *条件筛选列表 ，有筛选条件conditiontype是筛选条件--评分，价格，回答数
	     */
	    @ApiOperation(value="条件筛选接口",notes="条件筛选接口有分页",tags= {"ApiInterface"},response=Question.class)
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name="expertsname",value="指定专家名字",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="industry",value="职业方向",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="industrytype",value="职业类型",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="addressproince",value="地区的省会",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="sort",value="筛条件",required=false,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="order",value="是否正序",required=false,dataType="boolean",paramType="query"),
	    		@ApiImplicitParam(name="limit",value="每页多少条数据",required=true,dataType="String",paramType="query"),
	    		@ApiImplicitParam(name="offset",value="每页的偏移量(本页当前有多少条)",required=true,dataType="String",paramType="query")
			})
	    @RequestMapping(value = "/screen")
	    public Object screen(
	    		@RequestParam(required = false) String expertsname,
	    		@RequestParam String industry,
                @RequestParam(required = false) String industrytype,
                @RequestParam(required = false) String addressproince) {
	    	Page<User2> page = new PageFactory<User2>().defaultPage();
	    	List<Map<String, Object>> screen=user2Service.screen(expertsname,page,industry,industrytype,addressproince, page.getOrderByField(), page.isAsc());
	    	return screen;
	    }

	    /*
	     * 
	     * 专家详细页面
	     */
	    @ApiOperation(value="专家详细页面",notes="专家详细页面",tags= {"ApiInterface"},response=Question.class)
	    @ApiImplicitParams({
	    		@ApiImplicitParam(name="expertsid",value="专家id",required=true,dataType="String",paramType="query")	
			})
	    @RequestMapping(value = "/details")
	    public Object details(@RequestParam String expertsid) {
		
	    	List<Map<String, Object>> introduct=user2Service.xiangxi(expertsid);
	    	List<Map<String, Object>> evaluate=answerService.pingjia(expertsid);
	    	List<Map<String, Object>> ques=answerService.wenti(expertsid);
	    	for(Map<String, Object> product: evaluate){
	    		introduct.add(product);
	    	}
		
	    	for(Map<String, Object> product: ques){
	    		introduct.add(product);
	    	}
	    	return introduct;
	    }
	   /*
	    * 
	    * 收藏接口
	    */
	    
	    
	    /*
	     * 聊天室列表
	     * 
	     */
	    @ApiOperation(value="聊天室列表",notes="聊天室列表,返回与这个人的聊天内容",tags= {"ApiInterface"},response=Question.class)
	    @ApiImplicitParams({
    		@ApiImplicitParam(name="expertsid",value="专家id",required=true,dataType="String",paramType="query")	,
    		@ApiImplicitParam(name="userid",value="用户id",required=true,dataType="String",paramType="query")	
		})
	    @RequestMapping(value = "/chat")
	    public Object chat(
	    		@RequestParam String expertsid,
	    		@RequestParam String userid
	    		) {
			//1.找房间id看有没有
	    	EntityWrapper<Chatroom> entityWrapper = new EntityWrapper<>();
	    	Wrapper<Chatroom> wapper =entityWrapper.where("chatroom_expertsId={0}",expertsid ).where("chatroom_userId={0}",userid);
	    	Integer a=chatroomService.selectCount(wapper);
	    	Long roomid;
	    	if(a.equals(0)) {
	    		//如果房间号为空则创建房间
	    		Chatroom chatroom=new Chatroom();
	    		long expertsId = Long.parseLong(expertsid);
	    		long userId = Long.parseLong(userid);
	    		chatroom.setChatroomUserid(expertsId);
	    		chatroom.setChatroomUserid(userId);
	    		chatroom.insert();
	    		roomid=chatroom.getChatroomId();
	    	}else {
	    		//返回；聊天内容
	    		Chatroom chatroom=chatroomService.selectOne(wapper);
	    		roomid = chatroom.getChatroomId();
	    	}
	    	
	    	EntityWrapper<Chatrecord> recordew = new EntityWrapper<>();
	    	Wrapper<Chatrecord> recordw =recordew.where("chatroom_id={0}", roomid);
			chatrecordService.selectList(recordw);
	    	return chatrecordService.selectList(recordw);
	    }
	    /**
	     * 测试接口是否走鉴权
	     */
	    @RequestMapping(value = "/test", method = RequestMethod.POST)
	    public Object test() {
	        return SUCCESS_TIP;
	    }

	}
