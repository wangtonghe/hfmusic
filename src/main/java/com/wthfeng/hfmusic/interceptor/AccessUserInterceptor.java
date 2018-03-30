package com.wthfeng.hfmusic.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.wthfeng.hfmusic.context.UserContext;
import com.wthfeng.hfmusic.model.system.SysUser;
import com.wthfeng.hfmusic.model.view.ViewError;
import com.wthfeng.hfmusic.service.user.UserService;
import com.wthfeng.hfmusic.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户授权拦截器。 若用户未登录，则不能进行操作
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年12月4日 下午7:33:41
 */
public class AccessUserInterceptor extends HandlerInterceptorAdapter{

	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String accessToken = request.getParameter("accessToken");
		SysUser user =userService.checkAccessToken(accessToken);
		if(user==null){
			try {
				Map<String,Object> result = new HashMap<String,Object>();
				result.put("code", 1);
				result.put("data", new ViewError("您还没有登录，请登录后重试"));
				response.setHeader("Content-Type","text/html;charset=UTF-8");
				response.getWriter().write(StringUtil.map2Json(result));
				response.getWriter().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}else{
			UserContext.setUser(user);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("用户授权登录，处理中");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("用户授权登录，处理结束");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}


}
