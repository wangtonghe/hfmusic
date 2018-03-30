package com.wthfeng.hfmusic.service.user;


import com.wthfeng.hfmusic.model.param.RegisterUserParam;
import com.wthfeng.hfmusic.model.system.SysUser;
import com.wthfeng.hfmusic.model.user.UserInfo;

import java.util.Date;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:10
 */
public interface UserService {
	
	/**
	 * 用户登录
	 * @param username
	 * @return 0登录成功，1账号错误，2密码错误
	 */
	public UserInfo selectByUserName(String username)throws Exception;
	
	/**
	 * 用户注册
	 * @param param
	 */
	public Integer register(RegisterUserParam param) throws Exception;

	/**
	 * 更新用户令牌及登录时间
	 * @param id
	 * @param accessToken
	 * @param loginTime
	 */
	public void updateTokenAndTime(Integer id, String accessToken, Date loginTime)throws Exception;

	/**
	 * 检验accessToken是否有效
	 * @param accessToken
	 * @return
     */
	public SysUser checkAccessToken(String accessToken);
	
}
