package top.wthfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * 登录 控制器
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年12月4日 下午8:08:33
 */
@Controller
public class LoginController {
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	@ResponseBody
	public String login(Integer id, String username,String password){

		return "success";
		
	}
	
	@RequestMapping(value="/user/login2",method=RequestMethod.GET)
	public String login2(){
		return "index";
		
	}
	

}
