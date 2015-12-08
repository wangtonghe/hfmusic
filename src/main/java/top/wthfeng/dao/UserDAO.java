package top.wthfeng.dao;

import top.wthfeng.po.User;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:59:10
 */
public interface UserDAO {
	/**
	 * 添加用户
	 * @param user
	 */
	public void  insert(User user);
	public User selectById(Long id);

}
