package top.wthfeng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.dao.user.UserDAO;
import top.wthfeng.model.param.RegisterUserParam;
import top.wthfeng.model.user.UserInfo;
import top.wthfeng.service.user.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:44
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDAO userDAO;

	
	@Override
	public UserInfo selectByUserName(String username)throws Exception {
		
		return userDAO.selectByUserName(username);
	}

	@Override
	public void register(RegisterUserParam param) throws Exception{
		userDAO.insertUser(param);
		
	}
	@Override
	public void updateTokenAndTime(Integer id, String accessToken, Date loginTime)throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("id",id);
		param.put("accessToken",accessToken);
		param.put("loginTime",loginTime);
		userDAO.updateTokenAndTime(param);

    }

	@Override
	public boolean checkAccessToken(String accessToken) {
		return (userDAO.checkAccessToken(accessToken)==null)?false:true;
	}


}
