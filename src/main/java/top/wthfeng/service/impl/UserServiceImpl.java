package top.wthfeng.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.wthfeng.dao.UserDAO;
import top.wthfeng.service.UserService;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:44
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	private int LOGINFLAG;
	
	@Autowired
	private UserDAO userDAO;

	
	@Override
	public Integer login(String username, String password) {
		
			
		/*String password = userDAO.selectByName(username);*/
		return 0;
			
		
		
	}

	@Override
	public void register(String username, String password) {
		
	}
	
	

}
