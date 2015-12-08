package top.wthfeng.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.wthfeng.dao.UserDAO;
import top.wthfeng.po.User;
import top.wthfeng.service.UserService;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:44
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDAO userDAO; //@Resource按名称进行装配
	
	public void insert(User user){
		userDAO.insert(user);
	}

	public User selectById(long id) {
		return userDAO.selectById(id);
	}

}
