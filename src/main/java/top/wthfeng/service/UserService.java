package top.wthfeng.service;


/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:10
 */
public interface UserService {
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 0登录成功，1账号错误，2密码错误，3其他错误
	 */
	public Integer  login(String username,String password);
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 */
	public void register(String username,String password);
	
}
