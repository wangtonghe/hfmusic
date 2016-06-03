package top.wthfeng.hfmusic.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.hfmusic.model.view.ViewUserLogin;
import top.wthfeng.hfmusic.util.MD5Util;
import top.wthfeng.hfmusic.model.param.RegisterUserParam;
import top.wthfeng.hfmusic.model.user.UserInfo;
import top.wthfeng.hfmusic.service.user.UserService;
import top.wthfeng.hfmusic.util.GUIDUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/24.
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Resource
    private UserService userService;

    private String DEFAULTPHOTO = "http://wthfeng.top/hfupload/photo/0c7aa282-26ab-45b8-aca2-5433477f121d.jpg";
    private Byte DEFAULTSTARNUM = 1;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(String username, String password) throws Exception {
        Map<String, Object> result = new HashMap<>();
        UserInfo user = userService.selectByUserName(username);
        if (user == null) {
            result.put("code", 1);
            result.put("data", "抱歉，用户名不存在");
        } else if (!user.getPassword().equals(MD5Util.string2MD5(password))) {
            String pwd =MD5Util.string2MD5(password);
            result.put("code", 1);
            result.put("data", "密码不正确，请重试......");
        } else {
            String accessToken = GUIDUtil.normalGUID();
            Date loginTime = new Date();
            userService.updateTokenAndTime(user.getUserId(), accessToken, loginTime);
            ViewUserLogin data = new ViewUserLogin();
            data.setUserId(user.getUserId());
            data.setAccessToken(accessToken);
            data.setNickName(user.getNickName());
            data.setHeadPortrait(user.getHeadPortrait());
            data.setSex(user.getSex());
            data.setStarNum(user.getStarNum());
            data.setUsername(user.getUsername());
            result.put("code", 0);
            result.put("data", data);
        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(String username, String password) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (username == null) {
            result.put("code", 1);
            result.put("data", "用户名不能为空");
        } else if (password == null) {
            result.put("code", 1);
            result.put("data", "密码不能为空");
        } else {
            RegisterUserParam param = new RegisterUserParam();
            param.setAccessToken(GUIDUtil.normalGUID());
            param.setHeadPortrait(DEFAULTPHOTO);
            param.setLastLoginTime(new Date());
            param.setStarNum(DEFAULTSTARNUM);
            param.setPassword(MD5Util.string2MD5(password));
            param.setUsername(username);
            param.setNickName(username);

            int value =userService.register(param);
            if(value==-1) {
                result.put("code", -1);
                result.put("data", "该账号已存在！");
            }else {
                ViewUserLogin data = new ViewUserLogin();
                data.setAccessToken(param.getAccessToken());
                data.setHeadPortrait(param.getHeadPortrait());
                data.setStarNum(param.getStarNum());
                data.setUsername(param.getUsername());
                result.put("code", 0);
                result.put("data", data);
            }
        }
        return result;
    }


}
