package top.wthfeng.hfmusic.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.user.UserDAO;
import top.wthfeng.hfmusic.model.param.RegisterUserParam;
import top.wthfeng.hfmusic.service.user.UserService;
import top.wthfeng.hfmusic.model.user.UserInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtonghe
 * @email wangtonghe@nggirl.com.cn
 * @time 2015年11月25日 下午2:58:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDAO userDAO;

	
	@Override
	public UserInfo selectByUserName(String username)throws Exception {
		
		return userDAO.selectByUserName(username);
	}

	@Override
	public Integer register(RegisterUserParam param) throws Exception{
		if(userDAO.selectByUserName(param.getUsername())==null) {
			userDAO.insertUser(param);
			return  0;
		}else return -1;
		
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
