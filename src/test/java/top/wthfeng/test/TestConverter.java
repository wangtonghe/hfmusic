package top.wthfeng.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年12月18日 下午12:31:51
 */
@Controller
public class TestConverter {
	@RequestMapping(value="/test/getText")
	@ResponseBody
	public String getText(@RequestBody String text){
		return "this is text";
	}

}
