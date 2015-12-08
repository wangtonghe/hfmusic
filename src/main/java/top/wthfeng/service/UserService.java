package top.wthfeng.service;

import top.wthfeng.po.User;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:10
 */
public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 */
	public void insert(User user);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public User selectById(long id);

}
