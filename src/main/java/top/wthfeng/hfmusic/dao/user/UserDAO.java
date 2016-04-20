package top.wthfeng.hfmusic.dao.user;

import top.wthfeng.hfmusic.model.param.RegisterUserParam;
import top.wthfeng.hfmusic.model.view.ViewUserLogin;
import top.wthfeng.hfmusic.model.user.UserInfo;

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
	public void insertUser(RegisterUserParam param);
	
	/**
	 * 更新用户信息
	 */
	public void updateUser();
	
	/**
	 * 查询是否有此用户
	 * @param username 用户名
	 * @return 密码
	 */
	public UserInfo selectByUserName(String username);

	/**
	 * 更新用户令牌
	 * @param param
     */
	public void updateTokenAndTime(Map<String,Object> param);

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
     */
	public ViewUserLogin getUserById(Integer id);

	/**
	 * 检验accessToken
	 * @param accessToken
	 * @return
     */
	public String checkAccessToken(String accessToken);
	

}
