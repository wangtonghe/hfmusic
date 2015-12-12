package top.wthfeng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.wthfeng.po.User;
import top.wthfeng.service.UserService;

/**
 * 用户管理controller
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:59:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService; //按名称装配
	
	@RequestMapping(value="/findById",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findById(int id){
		Map<String,Object> result = new HashMap<>();
		User user =userService.selectById(id);
		result.put("code", 0);
		result.put("data", user);
		return result;		
	}
	

}