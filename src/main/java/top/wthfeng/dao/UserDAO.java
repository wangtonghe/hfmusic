package top.wthfeng.dao;

import java.util.Map;


/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:59:10
 */
public interface UserDAO {
	
	/**
	 * 添加用户
	 * @param username
	 * @param password
	 */
	public void insertUser(String username,String password);
	
	/**
	 * 更新用户信息
	 */
	public void updateUser();
	
	/**
	 * 查询是否有此用户
	 * @param username 用户名
	 * @return 密码
	 */
	public Map<String,Object> selectByName(String username);
	
	/**
	 * 更新用户令牌
	 * @param id
	 */
	public void updateAccessToken(Integer id);
	

}
