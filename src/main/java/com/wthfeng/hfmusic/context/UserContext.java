package com.wthfeng.hfmusic.context;

import com.wthfeng.hfmusic.model.system.SysUser;

/**
 * @author wangtonghe
 * @date 2016/5/15 19:29
 * @email wthfeng@126.com
 */
public class UserContext {
    private static final ThreadLocal<SysUser> user = new ThreadLocal<>();

    public static SysUser getUser() {
        return user.get();
    }

    public static void setUser(SysUser sysuser) {
        user.set(sysuser);
    }
}
