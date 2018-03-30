package com.wthfeng.hfmusic.dao.user;

import com.wthfeng.hfmusic.model.form.DefalutForm;
import com.wthfeng.hfmusic.model.param.RegisterUserParam;
import com.wthfeng.hfmusic.model.system.SysUser;
import com.wthfeng.hfmusic.model.user.UserInfo;
import com.wthfeng.hfmusic.model.view.ViewUserLogin;

import java.util.Map;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:59:10
 */
public interface UserDAO {
	
	/**
	 * 添加用户
	 * @param param
	 */
	 void insertUser(RegisterUserParam param);
	
	/**
	 * 更新用户信息
	 */
	 void updateUser();
	
	/**
	 * 查询是否有此用户
	 * @param username 用户名
	 * @return 密码
	 */
	 UserInfo selectByUserName(String username);

	/**
	 * 更新用户令牌
	 * @param param
     */
	 void updateTokenAndTime(Map<String,Object> param);

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
     */
	 ViewUserLogin getUserById(Integer id);

	/**
	 * 检验accessToken
	 * @param accessToken
	 * @return
     */
	 SysUser checkAccessToken(String accessToken);

	/**
	 * 创建用户默认歌单，名称为“我喜欢的歌”
	 * @param param
     */
	 void createDefaultForm(DefalutForm param);


	

}
