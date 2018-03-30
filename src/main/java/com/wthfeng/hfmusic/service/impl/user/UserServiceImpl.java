package com.wthfeng.hfmusic.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.wthfeng.hfmusic.dao.user.UserDAO;
import com.wthfeng.hfmusic.model.form.DefalutForm;
import com.wthfeng.hfmusic.model.param.RegisterUserParam;
import com.wthfeng.hfmusic.model.system.SysUser;
import com.wthfeng.hfmusic.service.user.UserService;
import com.wthfeng.hfmusic.model.user.UserInfo;

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

	@Value("${configure.hfmusic.site.form.defalutcover}")
	private String DEFAULT_FORMCOVER;
	@Value("${configure.hfmusic.site.form.defaultname}")
	private String DEFAULT_FORMNAME;



	
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
			DefalutForm defaultForm = new DefalutForm();
			defaultForm.setCreateTime(new Date());
			defaultForm.setUserId(param.getUserId());
			defaultForm.setCover(DEFAULT_FORMCOVER);
			defaultForm.setFormName(DEFAULT_FORMNAME);
			defaultForm.setIsSystem(0);
			defaultForm.setOnline(0);
			userDAO.createDefaultForm(defaultForm);
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
	public SysUser checkAccessToken(String accessToken) {
		return userDAO.checkAccessToken(accessToken);
	}


}
