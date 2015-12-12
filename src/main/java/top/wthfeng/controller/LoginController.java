package top.wthfeng.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录 控制器
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年12月4日 下午8:08:33
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	private String login(Integer id,String username,String password){

		return "success";
		
	}
	@RequestMapping(value="/register",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  register(String username,String password,String email){
		Map<String,Object> result = new HashMap<>();
		result.put("code",0);
		result.put("data",null);
		return result;


	}

}
