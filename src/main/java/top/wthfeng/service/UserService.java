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
	 */
	public void login(String username,String password);
	
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 */
	public void register(String username,String password);
	
}
